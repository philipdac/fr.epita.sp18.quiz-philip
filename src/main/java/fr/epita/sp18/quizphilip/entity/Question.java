package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.*;
import fr.epita.sp18.quizphilip.common.ScoringType;
import fr.epita.sp18.quizphilip.common.QuestionType;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Question
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Set<QuestionChoice> choices;
    
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
    
    public Set<QuestionChoice> getChoices()
    {
        return choices;
    }
    
    public void setChoices(Set<QuestionChoice> choices)
    {
        this.choices = choices;
    }
}
