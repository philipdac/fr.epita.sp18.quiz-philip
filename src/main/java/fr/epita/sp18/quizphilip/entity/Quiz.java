package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Quiz
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long quizId;
    
    private Long teacherId;
    private String title;
    private Integer duration;
    
    public Long getQuizId()
    {
        return quizId;
    }
    
    public void setQuizId(Long quizId)
    {
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
}
