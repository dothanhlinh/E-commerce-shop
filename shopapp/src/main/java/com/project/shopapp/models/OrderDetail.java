package com.project.shopapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "number_of_products", nullable = false)
    private int numberOfProducts;

    @Column(name = "total_money", nullable = false)
    private Float totalMoney;

    @Column(name = "color")
    private String color;

    // Constructors
    public OrderDetail() {}

    private OrderDetail(Builder builder) {
        this.id = builder.id;
        this.order = builder.order;
        this.product = builder.product;
        this.price = builder.price;
        this.numberOfProducts = builder.numberOfProducts;
        this.totalMoney = builder.totalMoney;
        this.color = builder.color;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

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
        private Order order;
        private Product product;
        private Float price;
        private int numberOfProducts;
        private Float totalMoney;
        private String color;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder order(Order order) {
            this.order = order;
            return this;
        }

        public Builder product(Product product) {
            this.product = product;
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

        public OrderDetail build() {
            return new OrderDetail(this);
        }
    }

    // toString method
    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", price=" + price +
                ", numberOfProducts=" + numberOfProducts +
                ", totalMoney=" + totalMoney +
                ", color='" + color + '\'' +
                '}';
    }
}
