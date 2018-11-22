package fr.epita.sp18.quizphilip.model;

import java.util.List;

public class AnswerRequest
{
    private Long attendanceId;
    private Long questionId;
    private List<Long> selections;
    private String OpenAnswer;
    
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
    
    public List<Long> getSelections()
    {
        return selections;
    }
    
    public void setSelections(List<Long> selections)
    {
        this.selections = selections;
    }
    
    public String getOpenAnswer()
    {
        return OpenAnswer;
    }
    
    public void setOpenAnswer(String openAnswer)
    {
        OpenAnswer = openAnswer;
    }
}
