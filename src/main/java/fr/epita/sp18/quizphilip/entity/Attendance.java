package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.epita.sp18.quizphilip.common.ShuffleType;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Attendance extends AuditModel
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long attendanceId;

    private Long examId;
    private String studentEmail;
    private Timestamp startTime;
    private Timestamp endTime;
    private String positionLastSeen;
    private ShuffleType shuffleType;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "attendanceId")
    private List<AttendanceQuestion> questions = new ArrayList<>();
    
    public Attendance() {}
    
    public Attendance(Exam exam, String studentEmail) {
        this.examId = exam.getExamId();
        this.studentEmail = studentEmail;
        this.startTime = new Timestamp(System.currentTimeMillis());
        
        int quizLength = exam.getQuiz().getDuration() > 0 ? exam.getQuiz().getDuration() : 99999;
        this.endTime = new Timestamp(System.currentTimeMillis());
        this.endTime.setTime(this.startTime.getTime() + TimeUnit.MINUTES.toMillis(quizLength));
        
        this.positionLastSeen = "";
        this.shuffleType = exam.getShuffleType();
    }
    
    public Long getAttendanceId()
    {
        return attendanceId;
    }
    
    public void setAttendanceId(Long attendanceId)
    {
        this.attendanceId = attendanceId;
    }
    
    public Long getExamId()
    {
        return examId;
    }
    
    public void setExamId(Long examId)
    {
        this.examId = examId;
    }
    
    public String getStudentEmail()
    {
        return studentEmail;
    }
    
    public void setStudentEmail(String studentEmail)
    {
        this.studentEmail = studentEmail;
    }
    
    public Timestamp getStartTime()
    {
        return startTime;
    }
    
    public void setStartTime(Timestamp startTime)
    {
        this.startTime = startTime;
    }
    
    public Timestamp getEndTime()
    {
        return endTime;
    }
    
    public void setEndTime(Timestamp endTime)
    {
        this.endTime = endTime;
    }
    
    public String getPositionLastSeen()
    {
        return positionLastSeen;
    }
    
    public void setPositionLastSeen(String positionLastSeen)
    {
        this.positionLastSeen = positionLastSeen;
    }
    
    public ShuffleType getShuffleType()
    {
        return shuffleType;
    }
    
    public void setShuffleType(ShuffleType shuffleType)
    {
        this.shuffleType = shuffleType;
    }
    
    public List<AttendanceQuestion> getQuestions()
    {
        return questions;
    }
    
    public void setQuestions(List<AttendanceQuestion> questions)
    {
        this.questions = questions;
    }
}
