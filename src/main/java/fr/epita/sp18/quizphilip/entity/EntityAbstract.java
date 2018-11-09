package fr.epita.sp18.quizphilip.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class EntityAbstract
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
