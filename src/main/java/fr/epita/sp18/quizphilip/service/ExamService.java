package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.entity.Exam;
import fr.epita.sp18.quizphilip.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService
{
    private final ExamRepository examRepo;
    
    @Autowired
    public ExamService(ExamRepository examRepo)
    {
        this.examRepo = examRepo;
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
    
    public void delete(Long examId)
    {
        if (examRepo.existsById(examId))
            examRepo.deleteById(examId);
    }
    
}
