package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.epita.sp18.quizphilip.common.ExamStatus;
import fr.epita.sp18.quizphilip.common.ShuffleType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exam
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long examId;
    
    private String examDesc;
    private String examRoom;
    private ExamStatus examStatus;
    
    @ManyToOne
    @JoinColumn(name = "quizId")
    @JsonBackReference
    private Quiz quiz;
    
    public Long getExamId()
    {
        return examId;
    }
    
    public void setExamId(Long examId)
    {
        this.examId = examId;
    }
    
    public String getExamDesc()
    {
        return examDesc;
    }
    
    public void setExamDesc(String examDesc)
    {
        this.examDesc = examDesc;
    }
    
    public String getExamRoom()
    {
        return examRoom;
    }
    
    public void setExamRoom(String examRoom)
    {
        this.examRoom = examRoom;
    }
    
    public ExamStatus getExamStatus()
    {
        return examStatus;
    }
    
    public void setExamStatus(ExamStatus examStatus)
    {
        this.examStatus = examStatus;
    }
    
    public Quiz getQuiz()
    {
        return quiz;
    }
    
    public void setQuiz(Quiz quiz)
    {
        this.quiz = quiz;
    }
}
