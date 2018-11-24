package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.common.ExamStatus;
import fr.epita.sp18.quizphilip.common.QuestionType;
import fr.epita.sp18.quizphilip.common.ShuffleType;
import fr.epita.sp18.quizphilip.entity.*;
import fr.epita.sp18.quizphilip.model.*;
import fr.epita.sp18.quizphilip.repository.AttendanceQuestionRepository;
import fr.epita.sp18.quizphilip.repository.AttendanceRepository;
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
    private final QuestionRepository questionRepo;
    private final AttendanceRepository attendRepo;
    private final AttendanceQuestionRepository attendQuestionRepo;
    
    @Autowired
    public AttendanceService(ExamRepository examRepo, QuestionRepository questionRepo, AttendanceRepository attendRepo, AttendanceQuestionRepository attendQuestionRepo)
    {
        this.examRepo = examRepo;
        this.questionRepo = questionRepo;
        this.attendRepo = attendRepo;
        this.attendQuestionRepo = attendQuestionRepo;
    }
    
    private Specification<Exam> hasRoomName(String name)
    {
        return (exam, cq, cb) -> cb.equal(exam.get("examRoom"), name);
    }
    
    public List<Attendance> list(long examId)
    {
        return attendRepo.findAllBy(examId);
    }
    
    public ApiResponse<AttendResponse> attend(AttendRequest request)
    {
        ApiResponse<AttendResponse> response;
        
        // validation is not null when examRoom invalid or the exam was completed/deleted already
        response = validateAttendRequest(request);
        if (response != null) return response;
        
        Exam exam = examRepo.findOne(hasRoomName(request.getExamRoom())).orElse(new Exam());
        Attendance attendance = null;
        List<Attendance> attendanceList = attendRepo.findByExamAndEmail(exam.getExamId(), request.getEmail());
        if (!attendanceList.isEmpty()) {
            attendance = attendanceList.get(0);
        }
        
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
                Attendance newAtd = new Attendance(exam, request.getEmail());
                newAtd.setQuestions(getQuestions(exam));
                attendance = attendRepo.save(newAtd);
            }
        } else {
            // Is the student runs out of his time?
            if (attendance.getEndTime().getTime() < System.currentTimeMillis()) {
                response.setHasError(true);
                response.setErrorMessage("Can not attend. You have run out of time for this exam.");
                return response;
            }
        }
        
        response.setData(getAttendResponse(exam, attendance));
        
        return response;
    }
    
    private AttendResponse getAttendResponse(Exam exam, Attendance attendance)
    {
        AttendResponse response = new AttendResponse(
                attendance.getAttendanceId(), attendance.getStudentEmail(),
                exam.getQuiz().getTitle(), exam.getQuiz().getDuration(),
                attendance.getStartTime(), attendance.getEndTime()
        );
        
        // Sort the question base on the shuffled result
        List<AttendanceQuestion> questions = attendance.getQuestions();
        questions.sort(new SortTheQuestions());
        
        List<ExamQuestion> examQuestions = new ArrayList<>();
        for (AttendanceQuestion aQuest : questions) {
            Question question = aQuest.getQuestion();
            ExamQuestion eQuest = new ExamQuestion(
                    question.getQuestionId(), question.getTitle(), question.getContent(), question.getTypeId(), question.getScore()
            );
            
            // Load the question's choices
            List<ExamQuestionChoice> examChoices;
            
            if (question.getTypeId() == QuestionType.OPEN_QUESTION) {
                examChoices = getExamOpenQuestion(aQuest);
            } else {
                examChoices = getExamSelectedChoices(aQuest);
            }
            
            eQuest.setChoices(examChoices);
            
            // Load student's answer to this question
            
            // Add to the list
            examQuestions.add(eQuest);
        }
        
        response.setQuestions(examQuestions);
        
        return response;
    }
    
    private List<ExamQuestionChoice> getExamOpenQuestion(AttendanceQuestion aQuest)
    {
        List<ExamQuestionChoice> list = new ArrayList<>();
        List<AttendanceAnswer> answers = aQuest.getAnswers();
        
        String openAnswer = "";
        if (!answers.isEmpty()) {
            openAnswer = answers.get(0).getOpenAnswer();
        }
        
        ExamQuestionChoice eChoice = new ExamQuestionChoice(0L, "OPEN_QUESTION", false, openAnswer);
        list.add(eChoice);
        
        return list;
    }
    
    private List<ExamQuestionChoice> getExamSelectedChoices(AttendanceQuestion aQuest)
    {
        Question question = aQuest.getQuestion();
        List<QuestionChoice> choices = question.getChoices();
        List<AttendanceAnswer> answers = aQuest.getAnswers();
        
        List<ExamQuestionChoice> list = new ArrayList<>();
        
        String[] array = aQuest.getShuffledChoices().split(", ");
        for (int i = 0; i < choices.size(); i++) {
            
            int choicePos = i;
            if (i < array.length && !array[i].isEmpty()) {
                choicePos = Integer.parseInt(array[i]);
            }
            
            QuestionChoice choice = choices.get(choicePos);
            Long choiceId = choice.getQuestionChoiceId();
            boolean selected = false;
            
            for (AttendanceAnswer answer : answers) {
                if (answer.getQuestionChoiceId().equals(choiceId)) {
                    selected = true;
                }
            }
            
            ExamQuestionChoice eChoice = new ExamQuestionChoice(choiceId, choice.getDescription(), selected, "");
            
            list.add(eChoice);
        }
        
        return list;
    }
    
    private class SortTheQuestions implements Comparator<AttendanceQuestion>
    {
        public int compare(AttendanceQuestion a, AttendanceQuestion b)
        {
            return a.getPosition() - b.getPosition();
        }
    }
    
    private List<Integer> getShuffledArray(int length)
    {
        List<Integer> array = new ArrayList<>();
        
        for (int i = 0; i < length; i++) {
            array.add(i);
        }
        
        Collections.shuffle(array);
        
        return array;
    }
    
    private List<AttendanceQuestion> getQuestions(Exam exam)
    {
        List<Question> questions = questionRepo.findAllBy(exam.getQuiz().getQuizId());
        List<Integer> shuffled = getShuffledArray(questions.size());
        
        List<AttendanceQuestion> list = new ArrayList<>();
        
        int i = 0;
        
        for (Question question : questions) {
            AttendanceQuestion aQuest = new AttendanceQuestion();
            aQuest.setQuestion(question);
            aQuest.setScoreEarned(0f);
            aQuest.setPosition(shuffled.get(i++));
            
            if (exam.getShuffleType() == ShuffleType.SHUFFLE_QUIZ_AND_CHOICE) {
                // Get the shuffled array
                List<Integer> shuffledChoices = getShuffledArray(question.getChoices().size());
                
                // Convert the array to string
                String order = shuffledChoices.toString();
                
                // Remove the '[' and ']' from the string
                order = order.substring(1, order.length() - 1);
                
                aQuest.setShuffledChoices(order);
            } else {
                aQuest.setShuffledChoices("");
            }
            
            list.add(aQuest);
        }
        
        return list;
    }
    
    private ApiResponse<AttendResponse> validateAttendRequest(AttendRequest request)
    {
        ApiResponse<AttendResponse> response = new ApiResponse<>();
        
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
        if ((examStatus == ExamStatus.COMPLETED) || (examStatus == ExamStatus.DELETED)) {
            response.setHasError(true);
            response.setErrorMessage("The exam was already completed or deleted.");
            return response;
        }
        return null;
    }
    
    private List<AttendanceAnswer> answerOpenQuestion(AttendanceQuestion question, AnswerRequest request)
    {
        List<AttendanceAnswer> answers = question.getAnswers();
        AttendanceAnswer answer;
        
        // Open question has only one answer
        if (answers.isEmpty()) {
            // First time save
            answer = new AttendanceAnswer(request.getAttendanceId(), request.getQuestionId(), 0L, request.getOpenAnswer());
            answers.add(answer);
        } else {
            // Saved. Update the openAnswer now
            answer = answers.get(0);
            answer.setOpenAnswer(request.getOpenAnswer());
            
            answers.set(0, answer);
        }
        
        return answers;
    }
    
    private QuestionChoice getQuestionChoiceById(List<QuestionChoice> choices, Long choiceId)
    {
        for (QuestionChoice choice : choices) {
            if (choice.getQuestionChoiceId() == choiceId) { return choice; }
            ;
        }
        
        return new QuestionChoice();
    }
    
    
    private List<AttendanceAnswer> answerMultipleChoices(AttendanceQuestion question, AnswerRequest request)
    {
        List<AttendanceAnswer> answers = question.getAnswers();
        List<Long> selections = request.getSelections();
        List<QuestionChoice> choices = question.getQuestion().getChoices();
        
        int totalAnswers = answers.size();
        int totalSelections = selections.size();
        
        int minIdx = totalAnswers <= totalSelections ? totalAnswers : totalSelections;
        int maxIdx = totalAnswers > totalSelections ? totalAnswers : totalSelections;
        
        if (totalAnswers > totalSelections) {
            // Number of new selections this time are LESS than the saved ones
            // Delete the redundant answers
            answers.subList(minIdx, maxIdx).clear();
        }
        
        if (totalAnswers < totalSelections) {
            // Number of new selections this time are MORE than the saved ones
            // Add more answers
            for (int idx = minIdx; idx < maxIdx; idx++) {
                AttendanceAnswer answer = new AttendanceAnswer(request.getAttendanceId(), request.getQuestionId(), 0L, "");
                answers.add(answer);
            }
        }
        
        // Set new information
        totalAnswers = answers.size();
        for (int idx = 0; idx < totalAnswers; idx++) {
            AttendanceAnswer answer = answers.get(idx);
            answer.setQuestionChoiceId(selections.get(idx));
            
            // Set correct answer and scoreEarned
            QuestionChoice questChoice = getQuestionChoiceById(choices, answer.getQuestionChoiceId());
            boolean correctAnswer = questChoice.getCorrectChoice();
            
            answer.setCorrectAnswer(correctAnswer);
            answer.setScoreEarned(correctAnswer ? questChoice.getScore() : 0f);
            
            answers.set(idx, answer);
        }
        
        return answers;
    }
    
    public Long answer(Long attendanceId, Long questionId, AnswerRequest request)
    {
        AttendanceQuestion question = attendQuestionRepo.findOne(attendanceId, questionId);
        List<AttendanceAnswer> answers;
        
        if (question.getQuestion().getTypeId() == QuestionType.OPEN_QUESTION) {
            answers = answerOpenQuestion(question, request);
        } else {
            answers = answerMultipleChoices(question, request);
        }
        
        question.setAnswers(answers);
        attendQuestionRepo.save(question);
        
        return 0L;
    }
}
