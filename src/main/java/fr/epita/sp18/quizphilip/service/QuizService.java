package fr.epita.sp18.quizphilip.service;

import fr.epita.sp18.quizphilip.entity.Attendance;
import fr.epita.sp18.quizphilip.entity.Question;
import fr.epita.sp18.quizphilip.entity.Quiz;
import fr.epita.sp18.quizphilip.model.ApiResponse;
import fr.epita.sp18.quizphilip.model.AttendResponse;
import fr.epita.sp18.quizphilip.repository.ExamRepository;
import fr.epita.sp18.quizphilip.repository.QuestionRepository;
import fr.epita.sp18.quizphilip.repository.QuizRepository;
import fr.epita.sp18.quizphilip.model.QuizSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService
{
    private final QuizRepository quizRepo;
    private final ExamRepository examRepo;
    private final QuestionRepository questionRepo;
    
    @Autowired
    public QuizService(QuizRepository quizRepo, ExamRepository examRepo, QuestionRepository questionRepo)
    {
        this.quizRepo = quizRepo;
        this.examRepo = examRepo;
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
            Long examCount = examRepo.countByQuiz(quiz.getQuizId());
            
            QuizSnapshot item = new QuizSnapshot(
                    quiz.getQuizId(),
                    quiz.getTitle(),
                    quiz.getDuration(),
                    questionCount,
                    examCount,
                    quiz.getTeacher().getId()
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
    
    public ApiResponse delete(Long quizId)
    {
        ApiResponse<AttendResponse> response = new ApiResponse<>();
    
        Long examCount = examRepo.countByQuiz(quizId);
        if (examCount > 0) {
            response.setHasError(true);
            response.setErrorMessage("There is exam already taken place with this quiz. Can't delete this quiz!");
        } else {
            List<Question> questions = questionRepo.findAllBy(quizId);
            for (Question question: questions ) {
                questionRepo.deleteById(question.getQuestionId());
            }
            
            quizRepo.deleteById(quizId);
        }
        
        return response;
    }
}
