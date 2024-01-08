package com.tylphe.authservice.controller;

import com.tylphe.authservice.dto.AuthRequest;
import com.tylphe.authservice.entity.UserCredential;
import com.tylphe.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;
    private final AuthenticationManager authManager;

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest user) {
        System.out.println("user = " + user);
//        Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.username(), user.password()));
        return service.generateToken(user.username());

//        if (authenticate.isAuthenticated()) {
//            return service.generateToken(user.username());
//        } else {
//            throw new RuntimeException("Invalid access");
//        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        service.validateToken(token);
        return "Token is valid";
    }
}

