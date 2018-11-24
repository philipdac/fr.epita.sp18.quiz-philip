package fr.epita.sp18.quizphilip.repository;

import fr.epita.sp18.quizphilip.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>
{
    @Query(value= "SELECT * FROM ATTENDANCE q WHERE q.EXAM_ID = ?1 AND STUDENT_EMAIL = ?2", nativeQuery = true)
    List<Attendance> findByExamAndEmail(Long examId, String email);
    
    @Query(value= "SELECT * FROM ATTENDANCE q WHERE q.EXAM_ID = ?1", nativeQuery = true)
    List<Attendance> findAllBy(Long examId);
}
