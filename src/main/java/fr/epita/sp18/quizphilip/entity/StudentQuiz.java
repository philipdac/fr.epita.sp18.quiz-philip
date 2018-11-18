package fr.epita.sp18.quizphilip.entity;

import java.util.Date;

public class StudentQuiz extends AuditModel
{
    private String studentName;
    private String studentEmail;
    private Long quizId;
    private Date startTime;
    private Date endTime;
}
