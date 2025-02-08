package com.project.shopapp.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "fullname", length = 100)
    private String fullName;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "phone_number", nullable = false, length = 100)
    private String phoneNumber;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "note", length = 100)
    private String note;

    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name = "status")
    private String status;

    @Column(name = "total_money")
    private Float totalMoney;

    @Column(name = "shipping_method")
    private String shippingMethod;

    @Column(name = "shipping_address")
    private String shippingAddress;

    @Column(name = "shipping_date")
    private LocalDate shippingDate;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "active")
    private Boolean active;

    // Constructors
    public Order() {}

    private Order(Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.fullName = builder.fullName;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.note = builder.note;
        this.orderDate = builder.orderDate;
        this.status = builder.status;
        this.totalMoney = builder.totalMoney;
        this.shippingMethod = builder.shippingMethod;
        this.shippingAddress = builder.shippingAddress;
        this.shippingDate = builder.shippingDate;
        this.trackingNumber = builder.trackingNumber;
        this.paymentMethod = builder.paymentMethod;
        this.active = builder.active;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Float getTotalMoney() { return totalMoney; }
    public void setTotalMoney(Float totalMoney) { this.totalMoney = totalMoney; }

    public String getShippingMethod() { return shippingMethod; }
    public void setShippingMethod(String shippingMethod) { this.shippingMethod = shippingMethod; }

    public String getShippingAddress() { return shippingAddress; }
    public void setShippingAddress(String shippingAddress) { this.shippingAddress = shippingAddress; }

    public LocalDate getShippingDate() { return shippingDate; }
    public void setShippingDate(LocalDate shippingDate) { this.shippingDate = shippingDate; }

    public String getTrackingNumber() { return trackingNumber; }
    public void setTrackingNumber(String trackingNumber) { this.trackingNumber = trackingNumber; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    // Builder Pattern
    public static class Builder {
        private Long id;
        private User user;
        private String fullName;
        private String email;
        private String phoneNumber;
        private String address;
        private String note;
        private LocalDate orderDate;
        private String status;
        private Float totalMoney;
        private String shippingMethod;
        private String shippingAddress;
        private LocalDate shippingDate;
        private String trackingNumber;
        private String paymentMethod;
        private Boolean active;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public Builder orderDate(LocalDate orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder totalMoney(Float totalMoney) {
            this.totalMoney = totalMoney;
            return this;
        }

        public Builder shippingMethod(String shippingMethod) {
            this.shippingMethod = shippingMethod;
            return this;
        }

        public Builder shippingAddress(String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        public Builder shippingDate(LocalDate shippingDate) {
            this.shippingDate = shippingDate;
            return this;
        }

        public Builder trackingNumber(String trackingNumber) {
            this.trackingNumber = trackingNumber;
            return this;
        }

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", note='" + note + '\'' +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", totalMoney=" + totalMoney +
                ", shippingMethod='" + shippingMethod + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", shippingDate=" + shippingDate +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", active=" + active +
                '}';
    }
}
