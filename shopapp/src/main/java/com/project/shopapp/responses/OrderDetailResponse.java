package com.project.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.models.OrderDetail;

public class OrderDetailResponse {
    private Long id;

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("price")
    private Float price;

    @JsonProperty("number_of_products")
    private int numberOfProducts;

    @JsonProperty("total_money")
    private Float totalMoney;

    private String color;

    // Constructor không tham số
    public OrderDetailResponse() {}

    // Constructor có tham số
    private OrderDetailResponse(Builder builder) {
        this.id = builder.id;
        this.orderId = builder.orderId;
        this.productId = builder.productId;
        this.price = builder.price;
        this.numberOfProducts = builder.numberOfProducts;
        this.totalMoney = builder.totalMoney;
        this.color = builder.color;
    }

    // Getters và Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public int getNumberOfProducts() { return numberOfProducts; }
    public void setNumberOfProducts(int numberOfProducts) { this.numberOfProducts = numberOfProducts; }

    public Float getTotalMoney() { return totalMoney; }
    public void setTotalMoney(Float totalMoney) { this.totalMoney = totalMoney; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    // Builder Pattern
    public static class Builder {
        private Long id;
        private Long orderId;
        private Long productId;
        private Float price;
        private int numberOfProducts;
        private Float totalMoney;
        private String color;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder orderId(Long orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public Builder price(Float price) {
            this.price = price;
            return this;
        }

        public Builder numberOfProducts(int numberOfProducts) {
            this.numberOfProducts = numberOfProducts;
            return this;
        }

        public Builder totalMoney(Float totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public OrderDetailResponse build() {
            return new OrderDetailResponse(this);
        }
    }

    // Phương thức tạo OrderDetailResponse từ OrderDetail
    public static OrderDetailResponse fromOrderDetail(OrderDetail orderDetail) {
        return new Builder()
                .id(orderDetail.getId())
                .orderId(orderDetail.getOrder().getId())
                .productId(orderDetail.getProduct().getId())
                .price(orderDetail.getPrice())
                .numberOfProducts(orderDetail.getNumberOfProducts())
                .totalMoney(orderDetail.getTotalMoney())
                .color(orderDetail.getColor())
                .build();
    }

    // toString method
    @Override
    public String toString() {
        return "OrderDetailResponse{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", price=" + price +
                ", numberOfProducts=" + numberOfProducts +
                ", totalMoney=" + totalMoney +
                ", color='" + color + '\'' +
                '}';
    }
}
