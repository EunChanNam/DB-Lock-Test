package study.lock.locktest.wishList.domain;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.Optional;

public interface WishListRepository extends JpaRepository<WishList, Long> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    @Query("select w from WishList w " +
            "join fetch w.hairstyle " +
            "where w.id = :id")
    Optional<WishList> findWithHairStyleById(@Param("id") Long id);
}
