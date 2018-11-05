package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizService
{
    private final QuizRepository repo;
    
    @Autowired
    public QuizService(QuizRepository repo)
    {
        this.repo = repo;
    }
    
    public String get()
    {
        return repo.list();
    }
    
    public Integer create()
    {
        return (Integer) 0;
    }
}
