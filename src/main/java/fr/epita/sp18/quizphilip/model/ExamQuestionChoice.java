package fr.epita.sp18.quizphilip.model;

import fr.epita.sp18.quizphilip.common.ChoiceNumber;
import fr.epita.sp18.quizphilip.entity.AuditModel;

import javax.persistence.*;

public class ExamQuestionChoice extends AuditModel
{
    private Long questionChoiceId;
    private ChoiceNumber choiceNumber;
    private String description;
    
    public ExamQuestionChoice(Long questionChoiceId, ChoiceNumber choiceNumber, String description)
    {
        this.questionChoiceId = questionChoiceId;
        this.choiceNumber = choiceNumber;
        this.description = description;
    }
    
    public Long getQuestionChoiceId()
    {
        return questionChoiceId;
    }
    
    public void setQuestionChoiceId(Long questionChoiceId)
    {
        this.questionChoiceId = questionChoiceId;
    }
    
    public ChoiceNumber getChoiceNumber()
    {
        return choiceNumber;
    }
    
    public void setChoiceNumber(ChoiceNumber choiceNumber)
    {
        this.choiceNumber = choiceNumber;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
}
