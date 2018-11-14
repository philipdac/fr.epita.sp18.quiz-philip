package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quiz {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long quizId;
    
    private Long teacherId;
    private String title;
    private Integer duration;
    
    @OneToMany(mappedBy = "quiz")
    @JsonManagedReference
    private List<Question> questions;
    
    @OneToMany(mappedBy = "quiz")
    @JsonManagedReference
    private List<Exam> exams;
    
    public Long getQuizId() {
        return quizId;
    }
    
    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
    
    public Long getTeacherId()
    {
        return teacherId;
    }
    
    public void setTeacherId(Long teacherId)
    {
        this.teacherId = teacherId;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public Integer getDuration()
    {
        return duration;
    }
    
    public void setDuration(Integer duration)
    {
        this.duration = duration;
    }
    
    public List<Question> getQuestions()
    {
        return questions;
    }
    
    public void setQuestion(List<Question> questions)
    {
        this.questions = questions;
    }
    
    public List<Exam> getExams()
    {
        return exams;
    }
    
    public void setExams(List<Exam> exams)
    {
        this.exams = exams;
    }
}
