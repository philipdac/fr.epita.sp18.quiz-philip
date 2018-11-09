package fr.epita.sp18.quizphilip.repository;

import fr.epita.sp18.quizphilip.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long>
{
}
