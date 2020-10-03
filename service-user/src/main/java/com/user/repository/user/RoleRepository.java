/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.repository.user;

import com.user.entity.login.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ridho
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
}
