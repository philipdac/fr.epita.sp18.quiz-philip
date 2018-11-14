package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.entity.Question;
import fr.epita.sp18.quizphilip.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService
{
    private final QuestionRepository repo;
    
    @Autowired
    public QuestionService(QuestionRepository repo)
    {
        this.repo = repo;
    }
    
    public Question get(Long questionId)
    {
        return repo.getOne(questionId);
    }
    
    public List<Question> list(long questionId)
    {
        return repo.findAllBy(questionId);
    }
    
    public Long save(Question question)
    {
        Question saved = repo.save(question);
        return saved.getQuestionId();
    }
}
