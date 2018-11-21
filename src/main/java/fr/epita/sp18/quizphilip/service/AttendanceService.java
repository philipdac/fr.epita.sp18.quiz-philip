package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.common.ExamStatus;
import fr.epita.sp18.quizphilip.common.ShuffleType;
import fr.epita.sp18.quizphilip.entity.AttendanceQuestion;
import fr.epita.sp18.quizphilip.entity.Exam;
import fr.epita.sp18.quizphilip.entity.Attendance;
import fr.epita.sp18.quizphilip.entity.Question;
import fr.epita.sp18.quizphilip.model.ApiResponse;
import fr.epita.sp18.quizphilip.repository.AttendanceRepository;
import fr.epita.sp18.quizphilip.model.AnswerRequest;
import fr.epita.sp18.quizphilip.model.AttendRequest;
import fr.epita.sp18.quizphilip.repository.ExamRepository;
import fr.epita.sp18.quizphilip.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttendanceService
{
    private final ExamRepository examRepo;
    private final AttendanceRepository attendRepo;
    private final QuestionRepository questionRepo;
    
    @Autowired
    public AttendanceService(ExamRepository examRepo, AttendanceRepository attendRepo, QuestionRepository questionRepo)
    {
        this.examRepo = examRepo;
        this.attendRepo = attendRepo;
        this.questionRepo = questionRepo;
    }

    private Specification<Exam> hasRoomName(String name) {
        return (exam, cq, cb) -> cb.equal(exam.get("examRoom"), name);
    }
    
    private Specification<Attendance> hasStudentEmail(String email) {
        return (examAttendance, cq, cb) -> cb.equal(examAttendance.get("studentEmail"), email);
    }
    
    public List<Attendance> list(long examId)
    {
        return attendRepo.findAllBy(examId);
    }
    
    public ApiResponse<Attendance> attend(AttendRequest request)
    {
        ApiResponse<Attendance> response;
    
        // validation is not null when examRoom invalid or the exam was completed/deleted already
        response = validateAttendRequest(request);
        if (response != null) return response;
    
        Exam exam = examRepo.findOne(hasRoomName(request.getExamRoom())).orElse(new Exam());
        Attendance attendance = attendRepo.findOne(hasStudentEmail(request.getEmail())).orElse(null);
        
        response = new ApiResponse<>();
        if (attendance == null) {
            // This is a new student
            if (exam.getExamStatus() == ExamStatus.SUBMISSION_ONLY) {
                // Do not allow new student to attend any more
                response.setHasError(true);
                response.setErrorMessage("The exam is closed for new attendance.");
                return response;
            } else {
                // Join him to the exam
                Attendance newAtd =  new Attendance(exam, request.getEmail());
                newAtd.setQuestions(getQuestions(exam));
                attendance = attendRepo.save(newAtd);
            }
        } else {
            // Is the student runs out of his time?
            if (attendance.getEndTime().getTime() < System.currentTimeMillis()) {
                response.setHasError(true);
                response.setErrorMessage("You have run out of time for this exam.");
                return response;
            }
        }
    
        // Sort the question base on the shuffled result
        List<AttendanceQuestion> questions = attendance.getQuestions();
        questions.sort(new SortTheQuestions());
        attendance.setQuestions(questions);
        
        response.setData(attendance);
    
        return response;
    }
    
    private class SortTheQuestions implements Comparator<AttendanceQuestion>
    {
        public int compare(AttendanceQuestion a, AttendanceQuestion b)
        {
            return a.getPosition() - b.getPosition();
        }
    }
    
    private List<Integer> getShuffledArray(int length) {
        List<Integer> array = new ArrayList<>();
        
        for (int i=0; i<length; i++) {
            array.add(i);
        }
    
        Collections.shuffle(array);
        
        return array;
    }
    
    private List<AttendanceQuestion> getQuestions(Exam exam) {
        List<Question> questions = questionRepo.findAllBy(exam.getQuiz().getQuizId());
        List<Integer> shuffled = getShuffledArray(questions.size());
        
        List<AttendanceQuestion> list = new ArrayList<>();
    
        int i = 0;
        
        for (Question question: questions ) {
            AttendanceQuestion aQuest = new AttendanceQuestion();
            aQuest.setQuestion(question);
            aQuest.setScore(0f);
            aQuest.setPosition(shuffled.get(i++));
            
            if (exam.getShuffleType() == ShuffleType.SHUFFLE_QUIZ_AND_CHOICE) {
                List<Integer> shuffledChoices = getShuffledArray(question.getChoices().size());
                aQuest.setShuffledChoices(shuffledChoices.toString());
            } else {
                aQuest.setShuffledChoices("");
            }
            
            list.add(aQuest);
        }
        
        return list;
    }
    
    private ApiResponse<Attendance> validateAttendRequest(AttendRequest request)
    {
        ApiResponse<Attendance> response = new ApiResponse<>();
        
        // Is the examRoom valid?
        String examRoom = request.getExamRoom();
        if (examRoom == null || examRoom.isEmpty()) {
            response.setHasError(true);
            response.setErrorMessage("Invalid exam room.");
            return response;
        }
        
        // Is the exam existed?
        Exam exam = examRepo.findOne(hasRoomName(request.getExamRoom())).orElse(null);
        if (exam == null) {
            response.setHasError(true);
            response.setErrorMessage("Invalid exam room.");
            return response;
        }
        
        // Can the student attend the exam?
        ExamStatus examStatus = exam.getExamStatus();
        if ( (examStatus == ExamStatus.COMPLETED) || (examStatus == ExamStatus.DELETED)) {
            response.setHasError(true);
            response.setErrorMessage("The exam was already completed or deleted.");
            return response;
        }
        return null;
    }
    
    public Long answer(Long attendanceId, Long questionId, AnswerRequest request)
    {
        return 0L;
    }
}
