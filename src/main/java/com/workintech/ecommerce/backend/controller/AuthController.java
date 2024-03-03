package com.workintech.ecommerce.backend.controller;

import com.workintech.ecommerce.backend.dto.RegisterUserDto;
import com.workintech.ecommerce.backend.entity.User;
import com.workintech.ecommerce.backend.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterUserDto registerUserDto){
        return authenticationService.register(registerUserDto.name(), registerUserDto.email(), registerUserDto.password());
    }
}
