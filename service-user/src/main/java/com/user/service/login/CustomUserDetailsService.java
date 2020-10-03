/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.service.login;

import com.user.entity.login.UserBioskop;
import com.user.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author ridho
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBioskop userBioskop = userRepository.findByUsername(username);
        CustomUserDetails userDetails = null;
        if (userBioskop != null) {
            userDetails = new CustomUserDetails();
            userDetails.setUserBioskop(userBioskop);
        } else {
            throw new UsernameNotFoundException("User tidak ditemukan");
        }
        return userDetails;
    } 
}
