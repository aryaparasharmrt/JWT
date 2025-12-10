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

    private List<String> roles;

    private long expiresAt;

    public JwtResponse(String jwt) {
        this.token = jwt;
        this.tokenType = "Bearer";
    }
}