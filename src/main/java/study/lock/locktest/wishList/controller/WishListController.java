package study.lock.locktest.wishList.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import study.lock.locktest.wishList.service.WishListService;

@RestController
@RequiredArgsConstructor
public class WishListController {

    private final WishListService wishListService;

    @PostMapping("/hair")
    public ResponseEntity<Void> createHairStyle() {
        wishListService.createHairStyle();

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/wishlist")
    public ResponseEntity<Void> createWishList() {
        wishListService.createWishList();

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/wishlist/{id}")
    public ResponseEntity<Void> deleteWishList(@PathVariable Long id) {
        wishListService.deleteWishList(id);

        return ResponseEntity.noContent().build();
    }
}
