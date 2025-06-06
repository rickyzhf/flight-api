package com.example.flightapi.controller;

import com.example.flightapi.dto.*;
import com.example.flightapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponseDTO>> login(@RequestBody LoginRequestDTO loginDTO) {
        LoginResponseDTO data = authService.login(loginDTO);
        return ResponseEntity.ok(BaseResponse.success(data));
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<LoginResponseDTO>> register(@RequestBody RegisterDTO registerDTO) {
        LoginResponseDTO data = authService.register(registerDTO);
        return ResponseEntity.ok(BaseResponse.success(data));
    }

    @GetMapping("/check")
    public ResponseEntity<BaseResponse<Boolean>> checkLogin() {
        // JWT
        return ResponseEntity.ok(BaseResponse.success(true));
    }
}
