package fr.epita.sp18.quizphilip.repository;

import fr.epita.sp18.quizphilip.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value= "SELECT * FROM QUESTION q WHERE q.QUIZ_ID = ?1", nativeQuery = true)
    List<Question> findAllBy(Long quizId);
}
