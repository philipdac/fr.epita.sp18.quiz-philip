package fr.epita.sp18.quizphilip.repository;

import fr.epita.sp18.quizphilip.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    
    @Query(value= "SELECT * FROM QUIZ q WHERE q.TEACHER_ID = ?1", nativeQuery = true)
    List<Quiz> findAllBy(Long teacherId);
}
