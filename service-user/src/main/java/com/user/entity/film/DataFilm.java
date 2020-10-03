/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.entity.film;

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
@Table(name = "datafilm", schema = "bioskop")
@Data
public class DataFilm implements Serializable {

    @Id
    @Column(name = "kode_film")
    private String kdFilm;
    @Column(name = "kode_studio")
    private String kdStudio;
    @Column(name = "judul_film")
    private String judulFilm;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "waktu_film")
    private Date waktuFilm;
}
