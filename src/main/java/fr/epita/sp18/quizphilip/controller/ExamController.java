package fr.epita.sp18.quizphilip.controller;

import fr.epita.sp18.quizphilip.entity.Exam;
import fr.epita.sp18.quizphilip.model.ApiResponse;
import fr.epita.sp18.quizphilip.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/exams")
public class ExamController
{
    private final ExamService service;
    
    @Autowired
    public ExamController(ExamService service)
    {
        this.service = service;
    }
    
    @GetMapping("/{examId}")
    public Exam get(@PathVariable Long examId)
    {
        return service.get(examId);
    }
    
    @GetMapping()
    public List<Exam> list(@RequestParam("quizId") long quizId)
    {
        return service.list(quizId);
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Long create(@RequestBody Exam exam)
    {
        exam.setExamId(null);
        return service.save(exam);
    }
    
    @PutMapping("/{examId}")
    public Long update(@PathVariable Long examId, @RequestBody Exam exam)
    {
        return service.save(exam);
    }
    
    @DeleteMapping("/{examId}")
    public ApiResponse delete(@PathVariable Long examId)
    {
        return service.delete(examId);
    }
    
}
