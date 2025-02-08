package com.project.shopapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.shopapp.models.Order;
import com.project.shopapp.models.OrderDetail;

import java.time.LocalDate;
import java.util.List;

public class OrderResponse extends BaseResponse{
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("fullname")
    private String fullName;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("email")
    private String email;

    @JsonProperty("address")
    private String address;

    @JsonProperty("note")
    private String note;

    @JsonProperty("order_date")
    private LocalDate orderDate;

    @JsonProperty("status")
    private String status;

    @JsonProperty("total_money")
    private double totalMoney;

    @JsonProperty("shipping_method")
    private String shippingMethod;

    @JsonProperty("shipping_address")
    private String shippingAddress;

    @JsonProperty("shipping_date")
    private LocalDate shippingDate;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("order_details")
    private List<OrderDetail> orderDetails;

    // No-argument constructor
    public OrderResponse() {
    }

    // All-arguments constructor
    public OrderResponse(Long id, Long userId, String fullName, String phoneNumber, String email, String address,
                         String note, LocalDate orderDate, String status, double totalMoney, String shippingMethod,
                         String shippingAddress, LocalDate shippingDate, String paymentMethod, List<OrderDetail> orderDetails) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.note = note;
        this.orderDate = orderDate;
        this.status = status;
        this.totalMoney = totalMoney;
        this.shippingMethod = shippingMethod;
        this.shippingAddress = shippingAddress;
        this.shippingDate = shippingDate;
        this.paymentMethod = paymentMethod;
        this.orderDetails = orderDetails;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    // Static method for creating an instance from Order
//    public static OrderResponse fromOrder(Order order) {
//        return OrderResponse.builder()
//                .id(order.getId())
//                .userId(order.getId())
//                .fullName(order.getFullName())
//                .phoneNumber(order.getPhoneNumber())
//                .email(order.getEmail())
//                .address(order.getAddress())
//                .note(order.getNote())
//                .orderDate(order.getOrderDate())
//                .status(order.getStatus())
//                .totalMoney(order.getTotalMoney())
//                .shippingMethod(order.getShippingMethod())
//                .shippingAddress(order.getShippingAddress())
//                .shippingDate(order.getShippingDate())
//                .paymentMethod(order.getPaymentMethod())
////                .orderDetails(order.getOrderDetails())
//                .build();
//    }

    // Builder pattern
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private Long userId;
        private String fullName;
        private String phoneNumber;
        private String email;
        private String address;
        private String note;
        private LocalDate orderDate;
        private String status;
        private double totalMoney;
        private String shippingMethod;
        private String shippingAddress;
        private LocalDate shippingDate;
        private String paymentMethod;
        private List<OrderDetail> orderDetails;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
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

        public Builder totalMoney(double totalMoney) {
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

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder orderDetails(List<OrderDetail> orderDetails) {
            this.orderDetails = orderDetails;
            return this;
        }

        public OrderResponse build() {
            return new OrderResponse(id, userId, fullName, phoneNumber, email, address, note, orderDate, status, totalMoney, shippingMethod, shippingAddress, shippingDate, paymentMethod, orderDetails);
        }
    }
}
