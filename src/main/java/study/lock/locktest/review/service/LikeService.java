package study.lock.locktest.review.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.lock.locktest.review.domain.Review;
import study.lock.locktest.review.domain.ReviewRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public void executeLike() {
        Review review = reviewRepository.findWithLikeById(1L).orElseThrow();

        review.addLike();

        log.info("likes = {}", review.getLikes());
    }
}
