package com.project.shopapp.responses;

import java.util.List;

public class ProductListResponse {
    private List<ProductResponse> products;
    private int totalPages;

    // Default constructor
    public ProductListResponse() {
    }

    // All-arguments constructor
    public ProductListResponse(List<ProductResponse> products, int totalPages) {
        this.products = products;
        this.totalPages = totalPages;
    }

    // Getters and Setters
    public List<ProductResponse> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    // toString method
    @Override
    public String toString() {
        return "ProductListResponse{" +
                "products=" + products +
                ", totalPages=" + totalPages +
                '}';
    }

    // Builder Pattern
    public static class Builder {
        private List<ProductResponse> products;
        private int totalPages;

        public Builder products(List<ProductResponse> products) {
            this.products = products;
            return this;
        }

        public Builder totalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public ProductListResponse build() {
            return new ProductListResponse(products, totalPages);
        }
    }

    // Static method to get Builder instance
    public static Builder builder() {
        return new Builder();
    }
}
