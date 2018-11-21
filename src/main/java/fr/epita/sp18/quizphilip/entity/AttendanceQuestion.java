package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AttendanceQuestion extends AuditModel
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long attendanceQuestionId;
    private Long attendanceId;
    private Long questionId;
    private Float score;
    private Integer position;
    private String shuffledChoices;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "attendanceQuestionId")
    private List<AttendanceAnswer> answers = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendanceId")
    
    public Long getAttendanceQuestionId()
    {
        return attendanceQuestionId;
    }
    
    public void setAttendanceQuestionId(Long attendanceQuestionId)
    {
        this.attendanceQuestionId = attendanceQuestionId;
    }
    
    public Long getAttendanceId()
    {
        return attendanceId;
    }
    
    public void setAttendanceId(Long attendanceId)
    {
        this.attendanceId = attendanceId;
    }
    
    public Long getQuestionId()
    {
        return questionId;
    }
    
    public void setQuestionId(Long questionId)
    {
        this.questionId = questionId;
    }
    
    public Float getScore()
    {
        return score;
    }
    
    public void setScore(Float score)
    {
        this.score = score;
    }
    
    public Integer getPosition()
    {
        return position;
    }
    
    public void setPosition(Integer position)
    {
        this.position = position;
    }
    
    public String getShuffledChoices()
    {
        return shuffledChoices;
    }
    
    public void setShuffledChoices(String shuffledChoices)
    {
        this.shuffledChoices = shuffledChoices;
    }
    
    public List<AttendanceAnswer> getAnswers()
    {
        return answers;
    }
    
    public void setAnswers(List<AttendanceAnswer> answers)
    {
        this.answers = answers;
    }
}