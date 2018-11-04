package fr.epita.sp18.quizphilip.entity;

import fr.epita.sp18.quizphilip.common.MultiChoiceScoringType;
import fr.epita.sp18.quizphilip.common.QuestionType;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Question extends EntityAbstract {
    private Long quizId;
    private String title;
    private String content;
    private QuestionType typeId;
    private MultiChoiceScoringType scoringType;
    private Integer maxNumberOfChoice;

    public Question(Long id, Long quizId, String title, String content) {
        this.id = id;
        this.quizId = quizId;
        this.title = title;
        this.content = content;
    }
    
    public Long getQuizId()
    {
        return quizId;
    }
    
    public void setQuizId(Long quizId)
    {
        this.quizId = quizId;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
