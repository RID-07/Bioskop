/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.entity.bioskop;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

/**
 *
 * @author ridho
 */
@Entity
@Table(name = "ticket", schema = "bioskop")
@Data
public class Tiket implements Serializable {
    
    @Id
    @Column(name = "kode_ticket")
    private String kdTicket;
    @Column(name = "kode_film")
    private String kdFilm;
    @Column(name = "nama_pembeli")
    private String namaPembeli;
    @Column(name = "no_telp")
    private String noTelp;
    @Column(name = "email")
    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_beli")
    private Date waktuBeli;
    @Column(name = "point")
    private int point;
}
