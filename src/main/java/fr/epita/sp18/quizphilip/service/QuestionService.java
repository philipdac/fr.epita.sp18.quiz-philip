package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.entity.Question;
import fr.epita.sp18.quizphilip.entity.QuestionChoice;
import fr.epita.sp18.quizphilip.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService
{
    private final QuestionRepository questionRepo;
    
    @Autowired
    public QuestionService(QuestionRepository repo)
    {
        this.questionRepo = repo;
    }
    
    public Question get(Long questionId)
    {
        return questionRepo.getOne(questionId);
    }
    
    public List<Question> list(long questionId)
    {
        return questionRepo.findAllBy(questionId);
    }
    
    public Long save(Question question)
    {
        for (QuestionChoice choice : question.getChoices()) {
            if (choice.getQuestionChoiceId() == 0) {
                // New entity has id=0. Set its id to null so that Hibernate will do an insert query
                choice.setQuestionChoiceId(null);
            }
        }
        
        Question saved = questionRepo.save(question);
        
        return saved.getQuestionId();
    }
}
