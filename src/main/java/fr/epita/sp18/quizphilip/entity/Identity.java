package fr.epita.sp18.quizphilip.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Identity extends AuditModel
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    protected Long id;
    private String name;
    private String email;
    private String normalizedEmail;
    private String passwordHash;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    public String getNormalizedEmail()
    {
        return normalizedEmail;
    }

    public String getPasswordHash()
    {
        return passwordHash;
    }
    
    public void setEmail(String email)
    {
        this.email = email != null ? email.trim() : null;
        normalizedEmail = email != null ? email.trim().toUpperCase() : null;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNormalizedEmail(String normalizedEmail)
    {
        this.normalizedEmail = normalizedEmail;
    }

    public void setPasswordHash(String passwordHash)
    {
        this.passwordHash = passwordHash;
    }
}
