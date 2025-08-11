package com.cemre.product_backend.service;

import com.cemre.product_backend.model.entity.Favorite;

import java.util.List;

public interface FavoriteService {

    public List<Favorite> getUserFavorites(Integer userId);

    public Favorite addFavorite(Integer userId, Integer id);

    public void removeFavorite(Integer userId, Integer id);
}
