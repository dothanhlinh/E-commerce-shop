package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProductDTO {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 3, max = 200,message = "Name phải lớn hơn 3 và nhỏ hơn 200")
    private String name;
    @NotBlank(message = "Giá không được để trống")
    @Size(min = 0, max = 1000000000,message = "Name phải lớn hơn 0 và nhỏ hơn 1000000000")
    private float price;
    private String thumbnail;
    private String description;

    @JsonProperty("category_id")
    private Long categoryId;


//    public List<MultipartFile> getFiles() {
//        return files;
//    }
//
//    public void setFiles(List<MultipartFile> files) {
//        this.files = files;
//    }
//
//    private List<MultipartFile> files;

    // No-argument constructor
    public ProductDTO() {
    }

    // All-argument constructor
    public ProductDTO(String name, float price, String thumbnail, String description, Long categoryId) {
        this.name = name;
        this.price = price;
        this.thumbnail = thumbnail;
        this.description = description;
        this.categoryId = categoryId;
    }
    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    // toString method
    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", thumbnail='" + thumbnail + '\'' +
                ", description='" + description + '\'' +
                ", categoryId='" + categoryId + '\'' +
                '}';
    }
    // Builder pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private float price;
        private String thumbnail;
        private String description;
        private Long categoryId;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder price(float price) {
            this.price = price;
            return this;
        }

        public Builder thumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductDTO build() {
            return new ProductDTO(name, price, thumbnail, description, categoryId);
        }
    }
}
