package com.sirhconnect.controller;

import com.sirhconnect.model.User;
import com.sirhconnect.security.JwtService;
import com.sirhconnect.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserService userService;

    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        User dbUser = userService.findByUsername(auth.getName()).orElseThrow();
        String token = jwtService.generateToken(dbUser.getUsername(), dbUser.getRole().name());
        return Map.of("token", token);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }
}
