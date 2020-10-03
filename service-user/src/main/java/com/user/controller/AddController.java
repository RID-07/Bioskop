/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.controller;

import com.user.entity.login.UserBioskop;
import com.user.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ridho
 */
@RestController
@RequestMapping("/save/user")
public class AddController {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserBioskop user) {
        String pwd = user.getPassword();
        String encryptPass = passwordEncoder.encode(pwd);
        user.setPassword(encryptPass);
        userRepository.save(user);
        return "user added success";
    }
}
