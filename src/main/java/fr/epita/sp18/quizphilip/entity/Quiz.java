package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.epita.sp18.quizphilip.common.ShuffleType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long quizId;
    
    private Long teacherId;
    private String title;
    private Integer duration;
    private ShuffleType shuffleType;
    
    @OneToMany(mappedBy = "quiz")
    @JsonManagedReference
    private List<Question> questions;
    
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
    
    public ShuffleType getShuffleType()
    {
        return shuffleType;
    }
    
    public void setShuffleType(ShuffleType shuffleType)
    {
        this.shuffleType = shuffleType;
    }
    
    public List<Question> getQuestions()
    {
        return questions;
    }
    
    public void setQuestion(List<Question> questions)
    {
        this.questions = questions;
    }
}
