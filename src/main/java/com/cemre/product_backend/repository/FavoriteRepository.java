package com.cemre.product_backend.repository;

import com.cemre.product_backend.model.entity.Favorite;
import com.cemre.product_backend.model.entity.User;
import com.cemre.product_backend.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

    public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
        List<Favorite> findByUser(User user);
        Optional<Favorite> findByUserAndProduct(User user, Product product);
        void deleteByUserAndProduct(User user, Product product);
    }


