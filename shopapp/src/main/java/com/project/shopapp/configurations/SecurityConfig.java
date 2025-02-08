package com.project.shopapp.configurations;

import com.project.shopapp.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    //THỨ TỰ HOẠT ĐỘNG
    //1️⃣ User nhập số điện thoại + mật khẩu
    //2️⃣ AuthenticationManager gọi authenticationProvider()
    //3️⃣ authenticationProvider() kiểm tra phoneNumber + mật khẩu:
    //
    //Tìm user trong database (userDetailsService()).
    //So sánh mật khẩu (passwordEncoder()). 4️⃣ Nếu đúng → Xác thực thành công ✅
    //Nếu sai → Trả về lỗi ❌
    private final UserRepository userRepository;
    public SecurityConfig(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    //user's detail object
    //Trả về thông tin người dùng khi client gửi tài khoản xuống
    @Bean
    public UserDetailsService userDetailsService(){
        return phoneNumber -> userRepository
                .findByPhoneNumber(phoneNumber)
                .orElseThrow(()->
                        new UsernameNotFoundException(
                                "Cannot find user with phone number =" + phoneNumber));
    }

    // Hàm mã hóa pass thành chuỗi hash.
    //Khi user đăng nhập, Spring Security sẽ so sánh hash của mật khẩu nhập vào với hash đã lưu.
    @Bean
    public PasswordEncoder passwordEncoder(){
        //BCryptPasswordEncoder là thuật toán băm mật khẩu an toàn.
        return new BCryptPasswordEncoder();
    }

    //Cấu hình xác thực
    @Bean
    public AuthenticationProvider authenticationProvider(){
        //DaoAuthenticationProvider là một provider xử lý xác thực
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    //Quản lý xác thực
    //AuthenticationManager là trung tâm xử lý đăng nhập
    //Khi user nhập số điện thoại & mật khẩu
    //AuthenticationManager sẽ gọi authenticationProvider()
    //authenticationProvider() sẽ kiểm tra số điện thoại và mật khẩu.
    //Nếu hợp lệ → đăng nhập thành công và ngược lại
    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config
    ) throws Exception {
        return config.getAuthenticationManager();
    }
}
