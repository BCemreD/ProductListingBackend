package com.cemre.product_backend.controller;

import com.cemre.product_backend.dto.FavoriteDto;
import com.cemre.product_backend.model.entity.Favorite;
import com.cemre.product_backend.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "${FRONTEND_URL}")
@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;


    @GetMapping("/{userId}")
    public ResponseEntity<List<FavoriteDto>> getUserFavorites(@PathVariable Integer userId) {
        try {
            List<Favorite> favorites = favoriteService.getUserFavorites(userId);
            List<FavoriteDto> favoriteDtos = favorites.stream()
                    .map(fav -> new FavoriteDto(
                            fav.getId(),
                            fav.getProduct().getId(),
                            fav.getProduct().getName(),
                            fav.getProduct().getImageSrc(),
                            fav.getProduct().getPrice()
                    ))
                    .collect(Collectors.toList());
            return new ResponseEntity<>(favoriteDtos, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Favori ekler
    @PostMapping("/{userId}/{productId}")
    public ResponseEntity<FavoriteDto> addFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
        try {
            Favorite favorite = favoriteService.addFavorite(userId, productId);
            FavoriteDto favoriteDto = new FavoriteDto(
                    favorite.getId(),
                    favorite.getProduct().getId(),
                    favorite.getProduct().getName(),
                    favorite.getProduct().getImageSrc(),
                    favorite.getProduct().getPrice()
            );
            return new ResponseEntity<>(favoriteDto, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            if (e.getMessage() != null && e.getMessage().contains("zaten favorilerinizde")) {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Favori siler
    @DeleteMapping("/{userId}/{productId}")
    public ResponseEntity<Void> removeFavorite(@PathVariable Integer userId, @PathVariable Integer productId) {
        try {
            favoriteService.removeFavorite(userId, productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
