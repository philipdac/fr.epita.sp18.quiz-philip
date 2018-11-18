package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.epita.sp18.quizphilip.common.QuestionType;
import fr.epita.sp18.quizphilip.common.ScoringType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    
    private String title;
    private String content;
    private QuestionType typeId;
    private Float score;
    private ScoringType scoringType;
    private String answer;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "quizId", nullable = false)
    private Quiz quiz;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "questionId")
    private List<QuestionChoice> choices = new ArrayList<>();
    
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
    
    public ScoringType getScoringType()
    {
        return scoringType;
    }
    
    public void setScoringType(ScoringType scoringType)
    {
        this.scoringType = scoringType;
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
