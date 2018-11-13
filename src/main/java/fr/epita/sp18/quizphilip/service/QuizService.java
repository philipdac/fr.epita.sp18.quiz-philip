package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.entity.Quiz;
import fr.epita.sp18.quizphilip.repository.QuizRepository;
import model.QuizSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
    
    public Quiz get(Long quizId)
    {
        return repo.getOne(quizId);
    }
    
    public List<QuizSnapshot> list(long teacherId)
    {
        List<QuizSnapshot> list = new ArrayList<>();
        List<Quiz> quizzes = repo.findAllBy(teacherId);
        
        for (Quiz quiz : quizzes) {
            QuizSnapshot item = new QuizSnapshot(
                    quiz.getQuizId(),
                    quiz.getTitle(),
                    quiz.getDuration(),
                    quiz.getShuffleType(),
                    quiz.getQuestions().size(),
                    quiz.getExams().size(),
                    quiz.getTeacherId()
            );
            item.setTeacherName("Teacher");
            
            list.add(item);
        }
        
        return list;
    }
    
    public Integer create()
    {
        return (Integer) 0;
    }
}
