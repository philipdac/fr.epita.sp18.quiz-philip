package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import fr.epita.sp18.quizphilip.common.MultiChoiceScoringType;
import fr.epita.sp18.quizphilip.common.QuestionType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionId;
    
    private String title;
    private String content;
    private QuestionType typeId;
    private Float score;
    private MultiChoiceScoringType scoringType;
    private Integer maxNumberOfChoice;
    private String answer;
    
    @ManyToOne
    @JoinColumn(name = "quizId")
    @JsonBackReference
    private Quiz quiz;
    
    @OneToMany(mappedBy = "question")
    @JsonManagedReference
    private List<QuestionChoice> choices;
    
    public Question()
    {
    }
    
    public Long getQuestionId()
    {
        return questionId;
    }
    
    public void setQuestionId(Long questionId)
    {
        this.questionId = questionId;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
    public QuestionType getTypeId()
    {
        return typeId;
    }
    
    public void setTypeId(QuestionType typeId)
    {
        this.typeId = typeId;
    }
    
    public float getScore()
    {
        return score;
    }
    
    public void setScore(float score)
    {
        this.score = score;
    }

    public MultiChoiceScoringType getScoringType()
    {
        return scoringType;
    }
    
    public void setScoringType(MultiChoiceScoringType scoringType)
    {
        this.scoringType = scoringType;
    }
    
    public Integer getMaxNumberOfChoice()
    {
        return maxNumberOfChoice;
    }
    
    public void setMaxNumberOfChoice(Integer maxNumberOfChoice)
    {
        this.maxNumberOfChoice = maxNumberOfChoice;
    }
    
    public String getAnswer()
    {
        return answer;
    }
    
    public void setAnswer(String answer)
    {
        this.answer = answer;
    }
    
    public Quiz getQuiz()
    {
        return quiz;
    }
    
    public void setQuiz(Quiz quiz)
    {
        this.quiz = quiz;
    }
    
    public List<QuestionChoice> getChoices()
    {
        return choices;
    }
    
    public void setChoices(List<QuestionChoice> choices)
    {
        this.choices = choices;
    }
}
