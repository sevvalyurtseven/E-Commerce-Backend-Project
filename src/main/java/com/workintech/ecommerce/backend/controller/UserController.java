package com.workintech.ecommerce.backend.controller;

import com.workintech.ecommerce.backend.dto.UserResponseRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public UserResponseRecord sayHi(){
        return new UserResponseRecord("This is user site");
    }
}
