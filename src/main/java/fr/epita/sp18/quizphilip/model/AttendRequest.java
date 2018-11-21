package fr.epita.sp18.quizphilip.model;

public class AttendRequest
{
    private String email;
    private String examRoom;
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getExamRoom()
    {
        return examRoom;
    }
    
    public void setExamRoom(String examRoom)
    {
        this.examRoom = examRoom;
    }
}
