package com.enialcode.helpdesk_pro.controllers;

import com.enialcode.helpdesk_pro.domain.dtos.AuthDTO;
import com.enialcode.helpdesk_pro.domain.dtos.LoginResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthDTO data) {
        return ResponseEntity.ok(new LoginResponseDTO("token-jwt-gerado-aqui"));
    }
}