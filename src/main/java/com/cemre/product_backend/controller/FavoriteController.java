package com.cemre.product_backend.controller;

import com.cemre.product_backend.dto.FavoriteDto;
import com.cemre.product_backend.model.entity.Favorite;
import com.cemre.product_backend.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/{userId}")
    public List<FavoriteDto> getUserFavorites(@PathVariable Integer userId) {
        List<Favorite> favorites = favoriteService.getUserFavorites(userId);
        return favorites.stream()
                .map(fav -> new FavoriteDto(
                        fav.getFavoriteId(),
                        fav.getProduct().getId(),
                        fav.getProduct().getName(),
                        fav.getProduct().getImageSrc(),
                        fav.getProduct().getPrice()

                ))
                .collect(Collectors.toList());
    }

    @PostMapping("/{userId}/{productId}")
    public FavoriteDto addFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
        Favorite favorite = favoriteService.addFavorite(userId, productId);
        return new FavoriteDto(
                favorite.getFavoriteId(),
                favorite.getProduct().getId(),
                favorite.getProduct().getName(),
                favorite.getProduct().getImageSrc(),
                favorite.getProduct().getPrice()

        );
    }

    @DeleteMapping("/{userId}/{productId}")
    public void removeFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
        favoriteService.removeFavorite(userId, productId);
    }
}
