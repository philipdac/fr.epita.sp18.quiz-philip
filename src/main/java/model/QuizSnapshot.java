package model;

import fr.epita.sp18.quizphilip.common.ShuffleType;

public class QuizSnapshot
{
    private Long quizId;
    private String title;
    private Integer duration;
    private Long questionCount;
    private Long examCount;
    private Long teacherId;
    private String teacherName;
    
    public QuizSnapshot(Long quizId, String title, Integer duration,
            Long questionCount, Long examCount, Long teacherId)
    {
        this.quizId = quizId;
        this.title = title;
        this.duration = duration;
        this.questionCount = questionCount;
        this.examCount = examCount;
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
    
    public Long getQuestionCount()
    {
        return questionCount;
    }
    
    public void setQuestionCount(Long questionCount)
    {
        this.questionCount = questionCount;
    }
    
    public Long getExamCount()
    {
        return examCount;
    }
    
    public void setExamCount(Long examCount)
    {
        this.examCount = examCount;
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
