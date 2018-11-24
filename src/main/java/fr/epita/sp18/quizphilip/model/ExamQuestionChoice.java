package fr.epita.sp18.quizphilip.model;

import fr.epita.sp18.quizphilip.entity.AuditModel;

import javax.persistence.*;

public class ExamQuestionChoice extends AuditModel
{
    private Long questionChoiceId;
    private String description;
    private Boolean selected;
    private String openAnswer;
    
    public ExamQuestionChoice(Long questionChoiceId, String description, Boolean selected, String openAnswer)
    {
        this.questionChoiceId = questionChoiceId;
        this.description = description;
        this.selected = selected;
        this.openAnswer = openAnswer;
    }
    
    public Long getQuestionChoiceId()
    {
        return questionChoiceId;
    }
    
    public void setQuestionChoiceId(Long questionChoiceId)
    {
        this.questionChoiceId = questionChoiceId;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public Boolean getSelected()
    {
        return selected;
    }
    
    public void setSelected(Boolean selected)
    {
        this.selected = selected;
    }
    
    public String getOpenAnswer()
    {
        return openAnswer;
    }
    
    public void setOpenAnswer(String openAnswer)
    {
        this.openAnswer = openAnswer;
    }
}
