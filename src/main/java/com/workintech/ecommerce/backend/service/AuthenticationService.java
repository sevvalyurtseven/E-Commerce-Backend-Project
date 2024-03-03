package com.workintech.ecommerce.backend.service;

import com.workintech.ecommerce.backend.Application;
import com.workintech.ecommerce.backend.entity.Role;
import com.workintech.ecommerce.backend.entity.User;
import com.workintech.ecommerce.backend.repository.RoleRepository;
import com.workintech.ecommerce.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String name, String email, String password){
        //Password encode edildi
        String encodedPassword = passwordEncoder.encode(password);
        //Her kullanici ilk register olurken spesifik bir rol ile eklendi
        Role userRole = roleRepository.findByAuthority("Müşteri").get();

        //Bulunan rol bir set'e eklendi
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        //User objesi tanimlandi
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(encodedPassword);
        user.setRoles(roles);

        //Veritabanina user save edildi
        return userRepository.save(user);

    }
}
