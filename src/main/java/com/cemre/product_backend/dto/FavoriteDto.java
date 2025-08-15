package com.cemre.product_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoriteDto {

    private Integer id;
    private Integer productId;
    private String name;
    private String imageSrc;
    private BigDecimal price;

}