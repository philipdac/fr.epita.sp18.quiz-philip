package fr.epita.sp18.quizphilip.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/api/quizzes")
public class QuizController
{
    @GetMapping()
    public String list() {
        return "List of quizzes";
    }
}
