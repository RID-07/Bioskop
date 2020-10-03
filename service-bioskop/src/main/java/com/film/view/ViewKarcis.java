/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.view;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author ridho
 */
@Data
public class ViewKarcis {

    public String kodeTiket, kodeStudio, namaPembeli, judulFilm;
    public int point;
    public Date waktuFilm;
}
