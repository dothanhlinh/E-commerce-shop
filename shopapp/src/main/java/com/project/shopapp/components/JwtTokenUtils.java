package com.project.shopapp.components;

import com.project.shopapp.exceptions.InvalidParamException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtils {
    @Value("${jwt.expiration}")
    private int expiration; // Thời gian hết hạn của token (giây)

    @Value("${jwt.secretKey}")
    private String secretKey; // Khóa bí mật để ký token

    // **Tạo JWT Token**
    public String generateToken(com.project.shopapp.models.User user) throws Exception {
        Map<String, Object> claims = new HashMap<>();
        claims.put("phoneNumber", user.getPhoneNumber()); // Thêm phoneNumber vào claims
        try {
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(user.getPhoneNumber()) // Đặt phoneNumber vào subject
                    .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L))
                    .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                    .compact();
        } catch (Exception e) {
            throw new InvalidParamException("Cannot create jwt token, error: " + e.getMessage());
        }
    }

    // **Lấy khóa bí mật**
    private Key getSignInKey() {
        byte[] bytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(bytes);
    }

    // **Giải mã token**
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // **Lấy dữ liệu cụ thể từ token**
    private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // **Lấy phoneNumber từ token (SỬA LỖI)**
    public String extractPhoneNumber(String token) {
        return extractClaims(token, claims -> claims.get("phoneNumber", String.class));
    }

    // **Kiểm tra token hết hạn**
    public boolean isTokenExpired(String token) {
        Date expirationDate = extractClaims(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }

    // **Kiểm tra token hợp lệ**
    public boolean validateToken(String token, UserDetails userDetails) {
        String phoneNumber = extractPhoneNumber(token);
        return phoneNumber != null && phoneNumber.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // **Tạo secret key mới (nếu cần)**
    public String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] keyBytes = new byte[32]; // 256-bit key
        random.nextBytes(keyBytes);
        return Encoders.BASE64.encode(keyBytes);
    }
}
