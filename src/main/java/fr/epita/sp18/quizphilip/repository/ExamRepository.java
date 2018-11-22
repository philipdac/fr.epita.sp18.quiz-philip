package fr.epita.sp18.quizphilip.repository;

import fr.epita.sp18.quizphilip.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>, JpaSpecificationExecutor<Exam>
{
    @Query(value= "select count(q.QUIZ_ID) from EXAM q where q.QUIZ_ID = ?1", nativeQuery = true)
    Long countByQuiz(Long quizId);
    
    @Query(value= "SELECT * FROM EXAM q WHERE q.QUIZ_ID = ?1", nativeQuery = true)
    List<Exam> findAllBy(Long quizId);
}
