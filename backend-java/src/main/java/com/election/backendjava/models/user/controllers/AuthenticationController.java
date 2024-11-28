package com.election.backendjava.models.user.controllers;

import com.election.backendjava.entities.User;
import com.election.backendjava.models.user.dto.LoginUserDto;
import com.election.backendjava.models.user.dto.RegisterUserDto;
import com.election.backendjava.models.user.responses.LoginResponse;
import com.election.backendjava.models.user.services.AuthenticationService;
import com.election.backendjava.models.user.services.JwtService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@Validated
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@Valid @RequestBody RegisterUserDto user) {
        User registeruser = authenticationService.signUp(user);
        return ResponseEntity.ok(registeruser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@Valid @RequestBody LoginUserDto loginUser) {
        User authenticatedUser = authenticationService.authenticate(loginUser);
        String jwtToken = jwtService.generateToken(new HashMap<>(), authenticatedUser);
        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExperation());
        return ResponseEntity.ok(loginResponse);
    }
}
