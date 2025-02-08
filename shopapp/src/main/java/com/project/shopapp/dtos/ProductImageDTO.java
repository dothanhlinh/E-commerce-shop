package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class ProductImageDTO {

    @JsonProperty("product_id")
    @Min(value = 1, message = "Product's ID must be > 0")
    private Long productId;

    @Size(min = 5, max = 200, message = "Image's name must be between 5 and 200 characters")
    @JsonProperty("image_url")
    private String imageUrl;

    // Default constructor
    public ProductImageDTO() {
    }

    // All-arguments constructor
    public ProductImageDTO(Long productId, String imageUrl) {
        this.productId = productId;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    // Builder pattern implementation
    public static class Builder {
        private Long productId;
        private String imageUrl;

        public Builder() {
        }

        public Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public ProductImageDTO build() {
            return new ProductImageDTO(productId, imageUrl);
        }
    }
    // toString method
    @Override
    public String toString() {
        return "ProductImageDTO{" +
                "productId=" + productId +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
