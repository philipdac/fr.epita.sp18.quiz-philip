package fr.epita.sp18.quizphilip.model;

import java.sql.Timestamp;
import java.util.List;

public class AttendResponse
{
    private Long attendanceId;
    private String studentEmail;
    private Timestamp startTime;
    private Timestamp endTime;
    
    private List<ExamQuestion> questions;
    
    public AttendResponse(Long attendanceId, String studentEmail, Timestamp startTime, Timestamp endTime)
    {
        this.attendanceId = attendanceId;
        this.studentEmail = studentEmail;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public Long getAttendanceId()
    {
        return attendanceId;
    }
    
    public void setAttendanceId(Long attendanceId)
    {
        this.attendanceId = attendanceId;
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
    
    public List<ExamQuestion> getQuestions()
    {
        return questions;
    }
    
    public void setQuestions(List<ExamQuestion> questions)
    {
        this.questions = questions;
    }
}
