package study.lock.locktest.wishList.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WishList {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hair_style_id")
    private Hairstyle hairstyle;

    public WishList(Long id, Hairstyle hairstyle) {
        this.id = id;
        this.hairstyle = hairstyle;
    }
}
