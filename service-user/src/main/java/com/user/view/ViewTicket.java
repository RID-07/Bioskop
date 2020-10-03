/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.view;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author ridho
 */
@Data
public class ViewTicket {
    
    public String kodeTiket, kodeStudio, namaPembeli, judulFilm;
    private int point;
    public Date waktuFilm;
}
