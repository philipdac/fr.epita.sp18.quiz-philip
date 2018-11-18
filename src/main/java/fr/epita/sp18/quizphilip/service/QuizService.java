package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.entity.Quiz;
import fr.epita.sp18.quizphilip.repository.QuestionRepository;
import fr.epita.sp18.quizphilip.repository.QuizRepository;
import model.QuizSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService
{
    private final QuizRepository quizRepo;
    private final QuestionRepository questionRepo;
    
    @Autowired
    public QuizService(QuizRepository quizRepo, QuestionRepository questionRepo)
    {
        this.quizRepo = quizRepo;
        this.questionRepo = questionRepo;
    }
    
    public Quiz get(Long quizId)
    {
        return quizRepo.getOne(quizId);
    }
    
    public List<QuizSnapshot> list(long teacherId)
    {
        List<QuizSnapshot> list = new ArrayList<>();
        List<Quiz> quizzes = quizRepo.findAllBy(teacherId);
        
        for (Quiz quiz : quizzes) {
            Long questionCount = questionRepo.countByQuiz(quiz.getQuizId());
            Long examCount = 0L;
            
            QuizSnapshot item = new QuizSnapshot(
                    quiz.getQuizId(),
                    quiz.getTitle(),
                    quiz.getDuration(),
                    questionCount,
                    examCount,
                    quiz.getTeacherId()
            );
            item.setTeacherName("Teacher");
            
            list.add(item);
        }
        
        return list;
    }
    
    public Long save(Quiz quiz)
    {
        Quiz saved = quizRepo.save(quiz);
        return saved.getQuizId();
    }
}
