package fr.epita.sp18.quizphilip.repository;

import fr.epita.sp18.quizphilip.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    
    @Query(value= "SELECT * FROM EXAM q WHERE q.QUIZ_ID = ?1", nativeQuery = true)
    List<Exam> findAllBy(Long quizId);
}
