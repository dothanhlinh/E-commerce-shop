package com.project.shopapp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    // Constructor không tham số
    public Role() {}

    // Constructor có tham số
    private Role(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    // Getters và Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Builder Pattern
    public static class Builder {
        private Long id;
        private String name;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Role build() {
            return new Role(this);
        }
    }

    // toString method
    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

     //Constants for role names
    public static final String ADMIN = "ADMIN";
    public static final String USER = "USER";
}
