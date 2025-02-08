package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartItemDTO {

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("quantity")
    private Integer quantity;

    // No-argument constructor
    public CartItemDTO() {
    }

    // All-argument constructor
    public CartItemDTO(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    // toString method
    @Override
    public String toString() {
        return "CartItemDTO{" +
                "productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
