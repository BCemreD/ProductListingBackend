package com.cemre.product_backend.service.impl;

import com.cemre.product_backend.model.entity.Favorite;
import com.cemre.product_backend.model.entity.User;
import com.cemre.product_backend.model.entity.Product;
import com.cemre.product_backend.repository.FavoriteRepository;
import com.cemre.product_backend.repository.UserRepository;
import com.cemre.product_backend.repository.ProductRepository;
import com.cemre.product_backend.service.FavoriteService;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
        @Override
        public List<Favorite> getUserFavorites(Integer userId) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found: ID " + userId));
            // FavoriteRepository @EntityGraph prevents N+1
            return favoriteRepository.findByUser(user);
        }

        @Override
        @Transactional
        public Favorite addFavorite(Integer userId, Integer productId) {
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found: ID " + userId));
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found: ID " + productId));

            try {
                Favorite favorite = new Favorite();
                favorite.setUser(user);
                favorite.setProduct(product);
                return favoriteRepository.save(favorite);
            } catch (DataIntegrityViolationException e) {

                throw new RuntimeException("Already favorited.", e);
            }
        }
        @Override
        @Transactional
        public void removeFavorite(Integer userId, Integer productId) {

            Optional<Favorite> favoriteOptional = favoriteRepository.findByUserAndProduct(
                    userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found: ID " + userId)),
                    productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found: ID " + productId))
            );

            if (favoriteOptional.isPresent()) {
                favoriteRepository.delete(favoriteOptional.get());
            } else {
                throw new RuntimeException("Cannot found or already removed: User ID " + userId + ", Product ID " + productId);
            }
        }

        //for frontend
    @Override
    public boolean isFavorite(Integer userId, Integer productId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Product> productOptional = productRepository.findById(productId);

        if (userOptional.isEmpty() || productOptional.isEmpty()) {
            return false;
        }
        return favoriteRepository.findByUserAndProduct(userOptional.get(), productOptional.get()).isPresent();
    }
    }


