package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.*;
import fr.epita.sp18.quizphilip.common.ChoiceNumber;

import javax.persistence.*;

@Entity
public class QuestionChoice extends AuditModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionChoiceId;
    private ChoiceNumber choiceNumber;
    private boolean correctChoice;
    
    @Lob
    private String description;
    
    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    
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
    
    public boolean getCorrectChoice()
    {
        return correctChoice;
    }
    
    public void setCorrectChoice(boolean correctChoice)
    {
        this.correctChoice = correctChoice;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
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
