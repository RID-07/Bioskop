/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.entity.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ridho
 */
@Entity
@Data
@Table(name = "role")
public class Role implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private int role_id;
    @Column(name = "role")
    private String role;
}
