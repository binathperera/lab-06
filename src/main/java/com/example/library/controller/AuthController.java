package com.example.library.controller;

import com.example.library.dto.JwtResponse;
import com.example.library.dto.LoginRequest;
import com.example.library.dto.SignupRequest;
import com.example.library.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = authService.authenticateUser(loginRequest);
        return ResponseEntity.ok(jwtResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
        JwtResponse jwtResponse = authService.registerUser(signupRequest);
        return ResponseEntity.ok(jwtResponse);
    }
}
