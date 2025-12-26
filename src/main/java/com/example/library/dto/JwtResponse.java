package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String email;
    private List<String> roles;
    private String errorMessage;
    public JwtResponse(String token, String email, List<String> roles) {
        this.token = token;
        this.email = email;
        this.roles = roles;
    }

    public JwtResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
