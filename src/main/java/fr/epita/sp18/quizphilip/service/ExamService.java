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
    
    public Exam get(Long quizId)
    {
        return examRepo.getOne(quizId);
    }
    
    public List<Exam> list(long quizId)
    {
        return examRepo.findAllBy(quizId);
    }
    
    public Long save(Exam exam)
    {
        Exam saved = examRepo.save(exam);
        return saved.getExamId();
    }
}
