package com.cemre.product_backend.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    private String category;

    private String href = "";

    @Column(name = "image_src")
    private String imageSrc;

    @Column(name = "image_alt")
    private String imageAlt;

    @NotNull
    private BigDecimal price;
}
