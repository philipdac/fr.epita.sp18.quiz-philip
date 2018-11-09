package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.entity.Quiz;
import fr.epita.sp18.quizphilip.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService
{
    private final QuizRepository repo;
    
    @Autowired
    public QuizService(QuizRepository repo)
    {
        this.repo = repo;
    }
    
    public Quiz get()
    {
        return repo.getOne(0L);
    }
    
    public Integer create()
    {
        return (Integer) 0;
    }
    
    public List<Quiz> list()
    {
        return repo.findAll();
    }
}
