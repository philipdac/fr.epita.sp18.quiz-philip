package fr.epita.sp18.quizphilip.entity;

import fr.epita.sp18.quizphilip.common.ChoiceNumber;

import javax.persistence.*;

@Entity
public class AttendanceAnswer extends AuditModel
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long attendanceAnswerId;
    
    private Long attendanceId;
    private Long questionId;
    private Long questionChoiceId;
    private String openAnswer;
    
    private boolean correctAnswer;
    private Float scoreEarned;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendanceQuestionId")
    
    public Long getAttendanceAnswerId()
    {
        return attendanceAnswerId;
    }
    
    public void setAttendanceAnswerId(Long attendanceAnswerId)
    {
        this.attendanceAnswerId = attendanceAnswerId;
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
    
    public Long getQuestionChoiceId()
    {
        return questionChoiceId;
    }
    
    public void setQuestionChoiceId(Long questionChoiceId)
    {
        this.questionChoiceId = questionChoiceId;
    }
    
    public String getOpenAnswer()
    {
        return openAnswer;
    }
    
    public void setOpenAnswer(String openAnswer)
    {
        this.openAnswer = openAnswer;
    }
    
    public boolean isCorrectAnswer()
    {
        return correctAnswer;
    }
    
    public void setCorrectAnswer(boolean correctAnswer)
    {
        this.correctAnswer = correctAnswer;
    }
    
    public Float getScoreEarned()
    {
        return scoreEarned;
    }
    
    public void setScoreEarned(Float scoreEarned)
    {
        this.scoreEarned = scoreEarned;
    }
}
