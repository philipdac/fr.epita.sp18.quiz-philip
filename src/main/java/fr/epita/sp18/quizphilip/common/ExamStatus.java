package fr.epita.sp18.quizphilip.common;

public enum ExamStatus
{
    OPEN, // Open for students to join the exam and submit their works
    SUBMISSION_ONLY, // Do not allow late students to join the exam but allow the current ones submit their works
    COMPLETED, // No more join nor work submission
    DELETED,
}
