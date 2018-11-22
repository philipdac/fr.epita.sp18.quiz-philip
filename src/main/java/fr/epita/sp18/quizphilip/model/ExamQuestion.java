package fr.epita.sp18.quizphilip.model;

import fr.epita.sp18.quizphilip.common.QuestionType;

import java.util.ArrayList;
import java.util.List;

public class ExamQuestion
{
    private Long questionId;
    
    private String title;
    private String content;
    private QuestionType typeId;
    private Float score;
    
    private List<ExamQuestionChoice> choices = new ArrayList<>();
    
    public ExamQuestion(Long questionId, String title, String content, QuestionType typeId, Float score)
    {
        this.questionId = questionId;
        this.title = title;
        this.content = content;
        this.typeId = typeId;
        this.score = score;
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
    
    public Float getScore()
    {
        return score;
    }
    
    public void setScore(Float score)
    {
        this.score = score;
    }
    
    public List<ExamQuestionChoice> getChoices()
    {
        return choices;
    }
    
    public void setChoices(List<ExamQuestionChoice> choices)
    {
        this.choices = choices;
    }
}
