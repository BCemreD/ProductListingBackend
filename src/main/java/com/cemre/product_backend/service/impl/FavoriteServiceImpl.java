package com.cemre.product_backend.service.impl;

import com.cemre.product_backend.model.entity.Favorite;
import com.cemre.product_backend.model.entity.User;
import com.cemre.product_backend.model.entity.Product;
import com.cemre.product_backend.repository.FavoriteRepository;
import com.cemre.product_backend.repository.UserRepository;
import com.cemre.product_backend.repository.ProductRepository;
import com.cemre.product_backend.service.FavoriteService;
import org.springframework.stereotype.Service;
import java.util.List;

    @Service
    public class FavoriteServiceImpl implements FavoriteService {

        private final FavoriteRepository favoriteRepository;
        private final UserRepository userRepository;
        private final ProductRepository productRepository;

        public FavoriteServiceImpl(FavoriteRepository favoriteRepository,
                                   UserRepository userRepository,
                                   ProductRepository productRepository) {
            this.favoriteRepository = favoriteRepository;
            this.userRepository = userRepository;
            this.productRepository = productRepository;
        }

        public List<Favorite> getUserFavorites(Integer userId) {
            User user = userRepository.findById(userId).orElseThrow();
            return favoriteRepository.findByUser(user);
        }

        public Favorite addFavorite(Integer userId, Integer id) {
            User user = userRepository.findById(userId).orElseThrow();
            Product product = productRepository.findById(id).orElseThrow();

            return favoriteRepository.findByUserAndProduct(user, product)
                    .orElseGet(() -> favoriteRepository.save(new Favorite(null, user, product)));
        }

        public void removeFavorite(Integer userId, Integer id) {
            User user = userRepository.findById(userId).orElseThrow();
            Product product = productRepository.findById(id).orElseThrow();
            favoriteRepository.deleteByUserAndProduct(user, product);
        }
    }


