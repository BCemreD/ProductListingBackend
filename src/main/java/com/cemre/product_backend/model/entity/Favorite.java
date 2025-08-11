package com.cemre.product_backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

    @Entity
    @Table(
            name = "favorite",
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "product_id"})
    )
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Favorite {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer favoriteId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id", nullable = false)
        private Product product;
    }



