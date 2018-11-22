package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.entity.Question;
import fr.epita.sp18.quizphilip.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService
{
    private final QuestionRepository questionRepo;
    
    @Autowired
    public QuestionService(QuestionRepository questionRepo)
    {
        this.questionRepo = questionRepo;
    }
    
    public Question get(Long questionId)
    {
        return questionRepo.getOne(questionId);
    }
    
    public List<Question> list(long quizId)
    {
        if (quizId <= 0) return null;
        return questionRepo.findAllBy(quizId);
    }
    
    public Long save(Question question)
    {
        Question saved = questionRepo.save(question);
        return saved.getQuestionId();
    }
    
    public void delete(Long questionId)
    {
        if (questionRepo.existsById(questionId))
            questionRepo.deleteById(questionId);
    }
}
