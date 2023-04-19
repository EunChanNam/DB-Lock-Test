package study.lock.locktest.wishList.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface HairStyleRepository extends JpaRepository<Hairstyle, Long> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Hairstyle> findById(Long aLong);
}
