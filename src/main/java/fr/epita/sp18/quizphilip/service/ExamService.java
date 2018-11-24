package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.entity.Attendance;
import fr.epita.sp18.quizphilip.entity.Exam;
import fr.epita.sp18.quizphilip.model.ApiResponse;
import fr.epita.sp18.quizphilip.model.AttendResponse;
import fr.epita.sp18.quizphilip.repository.AttendanceRepository;
import fr.epita.sp18.quizphilip.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService
{
    private final ExamRepository examRepo;
    private final AttendanceRepository attendRepo;
    
    @Autowired
    public ExamService(ExamRepository examRepo, AttendanceRepository attendRepo)
    {
        this.examRepo = examRepo;
        this.attendRepo = attendRepo;
    }
    
    public Exam get(Long examId)
    {
        return examRepo.getOne(examId);
    }
    
    public List<Exam> list(long quizId)
    {
        if (quizId <= 0) return null;
        
        return examRepo.findAllBy(quizId);
    }
    
    public Long save(Exam exam)
    {
        Exam saved = examRepo.save(exam);
        return saved.getExamId();
    }
    
    public ApiResponse delete(Long examId)
    {
        ApiResponse<AttendResponse> response = new ApiResponse<>();
    
        List<Attendance> attendanceList = attendRepo.findAllBy(examId);
        if (attendanceList.isEmpty()) {
            examRepo.deleteById(examId);
        } else {
            response.setHasError(true);
            response.setErrorMessage("There are students have taken this exam already. Can't delete it!");
        }
        
        return response;
    }
    
}
