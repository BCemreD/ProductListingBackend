package com.cemre.product_backend.dto;

import java.math.BigDecimal;

public class FavoriteDto {

    private Integer favoriteId;
    private Integer productId;
    private String name;
    private String imageSrc;
    private BigDecimal price;

    public FavoriteDto(Integer favoriteId, Integer productId, String name, String imageSrc, BigDecimal price) {
        this.favoriteId = favoriteId;
        this.productId = productId;
        this.name = name;
        this.imageSrc = imageSrc;
        this.price = price;
    }

    // Getter ve Setter’lar
    public Integer getFavoriteId() { return favoriteId; }
    public void setFavoriteId(Integer favoriteId) { this.favoriteId = favoriteId; }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImageSrc() { return imageSrc; }
    public void setImageSrc(String imageSrc) { this.imageSrc = imageSrc; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
