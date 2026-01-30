package com.betolara1.user.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.betolara1.user.DTO.RegisterDTO;
import com.betolara1.user.DTO.UserDTO;
import com.betolara1.user.model.User;
import com.betolara1.user.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder PasswordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterDTO request) {
        User newUser = userService.saveUser(request.username(), request.password());
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> request) {
        Optional<User> userOpt = userService.findByUsername(request.get("username"));

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // O matches verifica se a senha crua bate com o hash
            if (PasswordEncoder.matches(request.get("password"), user.getPassword())) {
                // NUNCA retorne a entidade User completa (tem a senha lá!). Retorne um DTO.
                return ResponseEntity.ok(new UserDTO(user)); 
            }
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

}
