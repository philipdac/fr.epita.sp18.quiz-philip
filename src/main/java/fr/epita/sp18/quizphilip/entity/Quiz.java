package fr.epita.sp18.quizphilip.entity;

import fr.epita.sp18.quizphilip.common.QuizStatus;
import fr.epita.sp18.quizphilip.common.ShuffleType;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Quiz extends EntityAbstract {
    private Long teacherId;
    private String title;
    private QuizStatus status;
    private String roomName;
    private Integer duration;
    private ShuffleType shuffleType;
    
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
    
    public QuizStatus getStatus()
    {
        return status;
    }
    
    public void setStatus(QuizStatus status)
    {
        this.status = status;
    }
    
    public String getRoomName()
    {
        return roomName;
    }
    
    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
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
}
