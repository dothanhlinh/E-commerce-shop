package com.project.shopapp.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullname", length = 100)
    private String fullName;

    @Column(name = "phone_number", length = 10, nullable = false)
    private String phoneNumber;

    @Column(name = "address", length = 200)
    private String address;

    @Column(name = "password", length = 200, nullable = false)
    private String password;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "facebook_account_id")
    private int facebookAccountId;

    @Column(name = "google_account_id")
    private int googleAccountId;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private com.project.shopapp.models.Role role;

    // Default constructor
    public User() {
    }

    // All-arguments constructor
    public User(Long id, String fullName, String phoneNumber, String address, String password, boolean active, Date dateOfBirth, int facebookAccountId, int googleAccountId, com.project.shopapp.models.Role role) {
        this.id = id;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.active = active;
        this.dateOfBirth = dateOfBirth;
        this.facebookAccountId = facebookAccountId;
        this.googleAccountId = googleAccountId;
        this.role = role;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("ROLE_"+ getRole().getName().toUpperCase()));
//        authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authorityList;
    }

    public String getPassword() {
        return password;
    }

    // Để ngầm hiểu để biết giá trị nào là để tên đăng nhập
    @Override
    public String getUsername() {
        return phoneNumber;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
//        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
//        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
//        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return true;
//        return UserDetails.super.isEnabled();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getFacebookAccountId() {
        return facebookAccountId;
    }

    public void setFacebookAccountId(int facebookAccountId) {
        this.facebookAccountId = facebookAccountId;
    }

    public int getGoogleAccountId() {
        return googleAccountId;
    }

    public void setGoogleAccountId(int googleAccountId) {
        this.googleAccountId = googleAccountId;
    }

    public com.project.shopapp.models.Role getRole() {
        return role;
    }

    public void setRole(com.project.shopapp.models.Role role) {
        this.role = role;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", dateOfBirth=" + dateOfBirth +
                ", facebookAccountId=" + facebookAccountId +
                ", googleAccountId=" + googleAccountId +
                ", role=" + role +
                '}';
    }

    // Builder Pattern
    public static class Builder {
        private Long id;
        private String fullName;
        private String phoneNumber;
        private String address;
        private String password;
        private boolean active;
        private Date dateOfBirth;
        private int facebookAccountId;
        private int googleAccountId;
        private com.project.shopapp.models.Role role;

        public Builder id(Long id) {
            this.id = id;
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

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public Builder dateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder facebookAccountId(int facebookAccountId) {
            this.facebookAccountId = facebookAccountId;
            return this;
        }

        public Builder googleAccountId(int googleAccountId) {
            this.googleAccountId = googleAccountId;
            return this;
        }

        public Builder role(com.project.shopapp.models.Role role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(id, fullName, phoneNumber, address, password, active, dateOfBirth, facebookAccountId, googleAccountId, role);
        }
    }

    // Static method to get Builder instance
    public static Builder builder() {
        return new Builder();
    }
}
