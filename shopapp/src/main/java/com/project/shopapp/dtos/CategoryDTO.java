package com.project.shopapp.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryDTO {
    @NotBlank(message = "Tên không được để trống")
    private String name;

    // No-argument constructor
    public CategoryDTO() {
    }

    // All-argument constructor
    public CategoryDTO(String name) {
        this.name = name;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // toString method
    @Override
    public String toString() {
        return "CategoryDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
