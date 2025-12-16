package com.testprojg.testproja.securityConfig;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {

    private String token;
    private String tokenType = "Bearer";
    private String username;
    private Long userId;
    private String refreshToken;
    private List<String> roles;
    private long expiresAt;

    public JwtResponse(String jwt, String refreshToken) {
        this.token = jwt;
        this.tokenType = "Bearer";
        this.refreshToken = refreshToken;
    }
}