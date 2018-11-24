package fr.epita.sp18.quizphilip.controller;

import fr.epita.sp18.quizphilip.entity.Question;
import fr.epita.sp18.quizphilip.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/questions")
public class QuestionController
{
    private final QuestionService service;
    
    @Autowired
    public QuestionController(QuestionService service)
    {
        this.service = service;
    }
    
    @GetMapping("/{questionId}")
    public Question get(@PathVariable Long questionId)
    {
        return service.get(questionId);
    }
    
    @GetMapping("")
    public List<Question> list(@RequestParam("quizId") long quizId)
    {
        return service.list(quizId);
    }
    
    @PostMapping()
    public Long create(@Valid @RequestBody Question question)
    {
        question.setQuestionId(null);
        return service.save(question);
    }
    
    @PutMapping("/{questionId}")
    public Long update(@PathVariable Long questionId, @Valid @RequestBody Question question)
    {
        return service.save(question);
    }

    @DeleteMapping("/{questionId}")
    public void delete(@PathVariable Long questionId)
    {
        service.delete(questionId);
    }
}
