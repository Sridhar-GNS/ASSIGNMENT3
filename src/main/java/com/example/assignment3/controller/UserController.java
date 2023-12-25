package com.example.assignment3.controller;

import com.example.assignment3.User;
import com.example.assignment3.exceptions.UserAlreadyEnrolledException;
import com.example.assignment3.exceptions.UserNotFoundException;
import com.example.assignment3.service.AuthenticationService;
import com.example.assignment3.service.UserService;
import com.example.assignment3.serviceImpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @Autowired
    AuthenticationService service;

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollForOfflinePayment(@RequestParam int user_id) {
        try {
            userService.enrollForOfflinePayment(user_id);
            return ResponseEntity.ok("Enrolled for offline payment successfully.");
        } catch (UserNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        } catch (UserAlreadyEnrolledException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User is already enrolled.");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
