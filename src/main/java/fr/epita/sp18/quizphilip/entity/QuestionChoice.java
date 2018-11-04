package fr.epita.sp18.quizphilip.entity;

import fr.epita.sp18.quizphilip.common.ChoiceNumber;
import fr.epita.sp18.quizphilip.common.ChoiceType;

import javax.persistence.Entity;
import javax.persistence.Table;

public class QuestionChoice extends EntityAbstract {
    private Long   questionId;
    private ChoiceNumber choiceNumber;
    private String description;
    private boolean correctChoice;
    private ChoiceType choiceType;
    private Float score;

    public Long getQuestionId()
    {
        return questionId;
    }
    
    public void setQuestionId(Long questionId)
    {
        this.questionId = questionId;
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
    
    public boolean getCorrectChoice()
    {
        return correctChoice;
    }
    
    public void setCorrectChoice(boolean correctChoice)
    {
        this.correctChoice = correctChoice;
    }
    
    public ChoiceType getChoiceType()
    {
        return choiceType;
    }
    
    public void setChoiceType(ChoiceType choiceType)
    {
        this.choiceType = choiceType;
    }
    
    public float getScore()
    {
        return score;
    }
    
    public void setScore(float score)
    {
        this.score = score;
    }
}
