package study.lock.locktest.review.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

    @Id
    private Long id;

    private String Contents;

    private int likes = 0;

    @OneToMany(mappedBy = "review", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final Set<LikeReview> likeReviews = new HashSet<>();

    public Review(String contents) {
        Contents = contents;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addLike() {
        LikeReview likeReview = new LikeReview(this);
        likeReviews.add(likeReview);
        likes++;
    }
}
