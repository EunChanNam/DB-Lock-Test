package study.lock.locktest.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.lock.locktest.review.service.LikeService;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @GetMapping("/api/like")
    public ResponseEntity<Void> executeLike() {
        likeService.executeLike();

        return ResponseEntity.noContent().build();
    }
}
