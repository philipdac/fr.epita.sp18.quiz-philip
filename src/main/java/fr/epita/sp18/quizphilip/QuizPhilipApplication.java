package fr.epita.sp18.quizphilip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuizPhilipApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizPhilipApplication.class, args);
	}
}
