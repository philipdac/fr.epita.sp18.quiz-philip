package fr.epita.sp18.quizphilip.entity;

import fr.epita.sp18.quizphilip.common.ChoiceNumber;

public class StudentQuizQuestionChoice
{
    private Long studentQuizId;
    private Long questionChoiceId;
    private ChoiceNumber choiceNumber;
    private String openAnswer;
    private boolean correctAnswer;
    private Float score;
}
