package fr.epita.sp18.quizphilip.repository;

import fr.epita.sp18.quizphilip.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value= "SELECT * FROM QUESTION q WHERE q.QUIZ_ID = ?1", nativeQuery = true)
    List<Question> findAllBy(Long quizId);
    
    @Query(value= "select count(q.QUIZ_ID) from QUESTION q where q.QUIZ_ID = ?1", nativeQuery = true)
    Long countByQuiz(Long quizId);
    
    @Modifying
    @Transactional
    @Query(value= "DELETE FROM QUESTION q where q.QUIZ_ID = ?1", nativeQuery = true)
    void deleteByQuizId(Long quizId);
}
