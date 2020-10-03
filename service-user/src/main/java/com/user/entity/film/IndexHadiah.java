/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.entity.film;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(schema = "bioskop", name = "indexhadiah")
@Data
public class IndexHadiah implements Serializable {
    
    @Id
    @Column(name = "id_index")
    private BigInteger idIndex;
    @Column(name = "kode_hadiah")
    private String kodeHadiah;
    @Column(name = "nama_hadiah")
    private String namaHadiah;
}
