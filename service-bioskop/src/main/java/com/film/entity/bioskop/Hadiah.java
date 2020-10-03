/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.entity.bioskop;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author ridho
 */
@Entity
@Table(schema = "bioskop", name = "hadiah")
@Data
public class Hadiah implements Serializable {
    
    @Id
    @Column(name = "kode_hadiah")
    private String kodeHadiah;
    @Column(name = "nama_hadiah")
    private String namaHadiah;
    @Column(name = "total_point")
    private int totalPoint;
}
