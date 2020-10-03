/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.service.login;

import com.user.entity.login.UserBioskop;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author ridho
 */
@Data
public class CustomUserDetails implements UserDetails {

    private UserBioskop userBioskop;
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        userBioskop.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_" + role)).collect(Collectors.toList());
        return null;
    }

    @Override
    public String getPassword() {
        return userBioskop.getPassword();
    }

    @Override
    public String getUsername() {
        return userBioskop.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
