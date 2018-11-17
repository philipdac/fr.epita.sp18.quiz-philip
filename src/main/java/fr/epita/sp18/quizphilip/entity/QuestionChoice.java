package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.*;
import fr.epita.sp18.quizphilip.common.ChoiceNumber;
import javax.persistence.*;

@Entity
public class QuestionChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionChoiceId;
    private ChoiceNumber choiceNumber;
    private boolean correctChoice;
    private String description;
    private Float score;
    
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "questionId")
    @JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("questionId")
    
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
