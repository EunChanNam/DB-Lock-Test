package study.lock.locktest.review.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select distinct r from Review r " +
            "left join fetch r.likeReviews " +
            "where r.id = :id")
    Optional<Review> findWithLikeById(@Param("id") Long id);
}
