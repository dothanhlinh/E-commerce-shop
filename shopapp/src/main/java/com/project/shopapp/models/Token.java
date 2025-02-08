package com.project.shopapp.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "token", length = 255)
    private String token;

    @Column(name = "token_type", length = 50)
    private String tokenType;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    private boolean revoked;
    private boolean expired;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructor không tham số
    public Token() {}

    // Constructor có tham số (sử dụng Builder)
    private Token(Builder builder) {
        this.id = builder.id;
        this.token = builder.token;
        this.tokenType = builder.tokenType;
        this.expirationDate = builder.expirationDate;
        this.revoked = builder.revoked;
        this.expired = builder.expired;
        this.user = builder.user;
    }

    // Getters và Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }

    public LocalDateTime getExpirationDate() { return expirationDate; }
    public void setExpirationDate(LocalDateTime expirationDate) { this.expirationDate = expirationDate; }

    public boolean isRevoked() { return revoked; }
    public void setRevoked(boolean revoked) { this.revoked = revoked; }

    public boolean isExpired() { return expired; }
    public void setExpired(boolean expired) { this.expired = expired; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    // Builder Pattern
    public static class Builder {
        private Long id;
        private String token;
        private String tokenType;
        private LocalDateTime expirationDate;
        private boolean revoked;
        private boolean expired;
        private User user;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder tokenType(String tokenType) {
            this.tokenType = tokenType;
            return this;
        }

        public Builder expirationDate(LocalDateTime expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public Builder revoked(boolean revoked) {
            this.revoked = revoked;
            return this;
        }

        public Builder expired(boolean expired) {
            this.expired = expired;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Token build() {
            return new Token(this);
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", expirationDate=" + expirationDate +
                ", revoked=" + revoked +
                ", expired=" + expired +
                ", user=" + (user != null ? user.getId() : "null") +
                '}';
    }
}
