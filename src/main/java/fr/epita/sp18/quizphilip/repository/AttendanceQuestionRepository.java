package fr.epita.sp18.quizphilip.repository;

import fr.epita.sp18.quizphilip.entity.AttendanceQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceQuestionRepository extends JpaRepository<AttendanceQuestion, Long> {
    @Query(value= "SELECT * FROM ATTENDANCE_QUESTION q WHERE q.ATTENDANCE_ID = ?1 AND q.QUESTION_ID = ?2", nativeQuery = true)
    AttendanceQuestion findOne(Long attendanceId, Long questionId);
}
