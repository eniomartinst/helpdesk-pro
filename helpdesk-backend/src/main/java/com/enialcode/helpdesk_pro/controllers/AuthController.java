package com.enialcode.helpdesk_pro.controllers;

import com.enialcode.helpdesk_pro.domain.dtos.AuthDTO;
import com.enialcode.helpdesk_pro.domain.dtos.LoginResponseDTO;
import com.enialcode.helpdesk_pro.domain.dtos.RegisterDTO;
import com.enialcode.helpdesk_pro.domain.entities.Usuario;
import com.enialcode.helpdesk_pro.repositories.UsuarioRepository;
import com.enialcode.helpdesk_pro.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173") // Permite chamadas do frontend local
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
        if (this.repository.findByEmail(data.email()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        Usuario newUser = new Usuario(null, data.nome(), data.email(), encryptedPassword, data.perfil(), null);
        
        this.repository.save(newUser);
        return ResponseEntity.ok().build();
    }
}