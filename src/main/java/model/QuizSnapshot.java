package model;

import fr.epita.sp18.quizphilip.common.ShuffleType;
import fr.epita.sp18.quizphilip.entity.Exam;

import java.util.List;

public class QuizSnapshot
{
    private Long quizId;
    private String title;
    private Integer duration;
    private ShuffleType shuffleType;
    private List<Exam> exams;
    private Long teacherId;
    private String teacherName;
    
    public QuizSnapshot(Long quizId, String title, Integer duration, ShuffleType shuffleType, List<Exam> exams, Long teacherId)
    {
        this.quizId = quizId;
        this.title = title;
        this.duration = duration;
        this.shuffleType = shuffleType;
        this.exams = exams;
        this.teacherId = teacherId;
    }
    
    public Long getQuizId()
    {
        return quizId;
    }
    
    public void setQuizId(Long quizId)
    {
        this.quizId = quizId;
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
    
    public List<Exam> getExams()
    {
        return exams;
    }
    
    public void setExams(List<Exam> exams)
    {
        this.exams = exams;
    }
    
    public Long getTeacherId()
    {
        return teacherId;
    }
    
    public void setTeacherId(Long teacherId)
    {
        this.teacherId = teacherId;
    }
    
    public String getTeacherName()
    {
        return teacherName;
    }
    
    public void setTeacherName(String teacherName)
    {
        this.teacherName = teacherName;
    }
}
