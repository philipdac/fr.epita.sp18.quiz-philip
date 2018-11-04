package fr.epita.sp18.quizphilip.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

public class StudentQuiz extends EntityAbstract {
    private String studentName;
    private String studentEmail;
    private Long quizId;
    private Date startTime;
    private Date endTime;
}
