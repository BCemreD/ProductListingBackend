package com.cemre.product_backend.controller;

import com.cemre.product_backend.model.entity.Favorite;
import com.cemre.product_backend.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;


    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }


    @GetMapping("/{userId}")
    public List<Favorite> getUserFavorites(@PathVariable Integer userId) {
        return favoriteService.getUserFavorites(userId);
    }

    @PostMapping("/{userId}/{productId}")
    public Favorite addFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
        return favoriteService.addFavorite(userId, productId);
    }

    @DeleteMapping("/{userId}/{productId}")
    public void removeFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
        favoriteService.removeFavorite(userId, productId);
    }
}