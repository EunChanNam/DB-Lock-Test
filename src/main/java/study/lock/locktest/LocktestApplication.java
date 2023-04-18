package study.lock.locktest;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.lock.locktest.review.domain.Review;
import study.lock.locktest.review.domain.ReviewRepository;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class LocktestApplication {

	private final ReviewRepository reviewRepository;

	@PostConstruct
	public void setUp() {
		Review review = new Review("hello");
		review.setId(1L);
		reviewRepository.save(review);
	}


	public static void main(String[] args) {
		SpringApplication.run(LocktestApplication.class, args);
	}

}
