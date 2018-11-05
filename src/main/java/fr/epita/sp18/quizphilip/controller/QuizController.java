package fr.epita.sp18.quizphilip.controller;

import fr.epita.sp18.quizphilip.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/quizzes")
public class QuizController
{
    private final QuizService service;
    
    @Autowired
    public QuizController(QuizService service)
    {
        this.service = service;
    }
    
    @GetMapping()
    public String list()
    {
        return service.get();
    }
    
    @PostMapping()
    public Integer create()
    {
        return service.create();
    }
}
