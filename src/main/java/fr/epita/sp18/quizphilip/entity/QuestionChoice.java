package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import fr.epita.sp18.quizphilip.common.ChoiceNumber;
import fr.epita.sp18.quizphilip.common.ChoiceType;

import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionChoiceId;
    private ChoiceNumber choiceNumber;
    private boolean correctChoice;
    private ChoiceType choiceType;
    private String description;
    private Float score;
    
    @ManyToOne
    @JoinColumn(name = "questionId")
    @JsonBackReference
    private Question question;

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

    public ChoiceType getChoiceType()
    {
        return choiceType;
    }
    
    public void setChoiceType(ChoiceType choiceType)
    {
        this.choiceType = choiceType;
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
    
    public Question getQuestion()
    {
        return question;
    }
    
    public void setQuestion(Question question)
    {
        this.question = question;
    }
}
