package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.common.ExamStatus;
import fr.epita.sp18.quizphilip.entity.Exam;
import fr.epita.sp18.quizphilip.entity.Attendance;
import fr.epita.sp18.quizphilip.model.ApiResponse;
import fr.epita.sp18.quizphilip.repository.AttendanceRepository;
import fr.epita.sp18.quizphilip.model.AnswerRequest;
import fr.epita.sp18.quizphilip.model.AttendRequest;
import fr.epita.sp18.quizphilip.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class AttendanceService
{
    private final ExamRepository examRepo;
    private final AttendanceRepository attendRepo;
    
    @Autowired
    public AttendanceService(ExamRepository examRepo, AttendanceRepository attendRepo)
    {
        this.examRepo = examRepo;
        this.attendRepo = attendRepo;
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
                attendance = attendRepo.save(new Attendance(exam, request.getEmail()));
                
                // Shuffle the question list if needed
                ShuffleTheQuestions();
            }
        } else {
            // Is the student runs out of his time?
            if (attendance.getEndTime().getTime() < System.currentTimeMillis()) {
                response.setHasError(true);
                response.setErrorMessage("You have run out of time for this exam.");
                return response;
            }
        }
    
        // Ok to go
        response.setData(attendance);
    
        return response;
    }
    
    private void ShuffleTheQuestions() {
    
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
