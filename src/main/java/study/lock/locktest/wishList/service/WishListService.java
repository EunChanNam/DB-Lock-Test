package study.lock.locktest.wishList.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.lock.locktest.wishList.domain.HairStyleRepository;
import study.lock.locktest.wishList.domain.Hairstyle;
import study.lock.locktest.wishList.domain.WishList;
import study.lock.locktest.wishList.domain.WishListRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class WishListService {

    private final HairStyleRepository hairStyleRepository;
    private final WishListRepository wishListRepository;
    private Long wishListId = 1L;

    public void createHairStyle() {
        hairStyleRepository.save(new Hairstyle(1L));
    }

    public void createWishList() {
        Hairstyle hairstyle = hairStyleRepository.findById(1L).orElseThrow();
        wishListRepository.save(new WishList(wishListId++, hairstyle));
        hairstyle.addCount();
        log.info("after plus count = {}", hairstyle.getCount());
    }

    public void deleteWishList(Long id) {
        WishList wishList = wishListRepository.findWithHairStyleById(id).orElseThrow();
        wishList.getHairstyle().minusCount();
        log.info("after minus count = {}", wishList.getHairstyle().getCount());
        wishListRepository.deleteById(id);
    }
}
