package study.lock.locktest.wishList.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hairstyle {

    @Id
    private Long id;

    private int count = 0;

    public Hairstyle(Long id) {
        this.id = id;
    }

    public void addCount() {
        count++;
    }

    public void minusCount() {
        count--;
    }
}
