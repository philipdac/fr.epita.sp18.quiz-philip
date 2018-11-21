package fr.epita.sp18.quizphilip.controller;

import fr.epita.sp18.quizphilip.entity.Quiz;
import fr.epita.sp18.quizphilip.service.QuizService;
import fr.epita.sp18.quizphilip.model.QuizSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/quizzes")
public class QuizController
{
    private final QuizService service;
    
    @Autowired
    public QuizController(QuizService service)
    {
        this.service = service;
    }
    
    @GetMapping("/{quizId}")
    public Quiz get(@PathVariable Long quizId)
    {
        return service.get(quizId);
    }
    
    @GetMapping()
    public List<QuizSnapshot> list(@RequestParam("teacherId") long teacherId)
    {
        return service.list(teacherId);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long create(@RequestBody Quiz quiz)
    {
        quiz.setQuizId(null);
        return service.save(quiz);
    }
    
    @PutMapping("/{quizId}")
    public Long update(@PathVariable Long quizId, @RequestBody Quiz quiz)
    {
        return service.save(quiz);
    }
}
