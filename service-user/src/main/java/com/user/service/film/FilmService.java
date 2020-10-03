/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.service.film;

import com.user.entity.film.DataFilm;
import com.user.entity.film.Hadiah;
import com.user.entity.film.IndexHadiah;
import com.user.entity.film.Tiket;
import com.user.repository.film.DataFilmRepository;
import com.user.repository.film.HadiahRepository;
import com.user.repository.film.IndexHadiahRepository;
import com.user.repository.film.TicketRepository;
import com.user.view.ViewResponse;
import com.user.view.ViewTicket;
import com.user.view.ViewTotalPoint;
import com.user.view.ViewTukarHadiah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ridho
 */
@Service
public class FilmService {

    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    DataFilmRepository dataFilmRepository;
    @Autowired
    HadiahRepository hadiahRepository;
    @Autowired
    IndexHadiahRepository indexHadiahRepository;

    public ViewResponse tukarHadiah(ViewTukarHadiah tukarHadiah) {
        ViewResponse response = new ViewResponse();
        int totalPointTicket = ticketRepository.getTotalPointByEmail(tukarHadiah.getEmail());
        Hadiah hadiah = hadiahRepository.findByKodeHadiah(tukarHadiah.getKdHadiah());
        if  (totalPointTicket <= hadiah.getTotalPoint()) {
            response.setRes("POINT YANG ANDA MILIKI MASIH KURANG");
        } else {
            int sisaPoint = totalPointTicket - hadiah.getTotalPoint();
            saveHadiah(tukarHadiah, hadiah.getKodeHadiah());
            response.setRes("ANDA BERHASIL TUKAR HADIAH, SISA POINT ANDA SEBESAR : " + sisaPoint);
        }
        return response;
    } 
    
    public ViewTicket selectViewKarcis(String kdTicket) {
        ViewTicket karcis = new ViewTicket();
        Tiket tiket = ticketRepository.findByKdTicket(kdTicket);
        DataFilm dataFilm = dataFilmRepository.findByKdFilm(tiket.getKdFilm());
        karcis.setKodeTiket(tiket.getKdTicket());
        karcis.setKodeStudio(dataFilm.getKdStudio());
        karcis.setNamaPembeli(tiket.getNamaPembeli());
        karcis.setJudulFilm(dataFilm.getJudulFilm());
        karcis.setWaktuFilm(dataFilm.getWaktuFilm());
        karcis.setPoint(tiket.getPoint());
        return karcis;
    }

    public void saveHadiah(ViewTukarHadiah tukarHadiah, String kdHadiah) {
        IndexHadiah hadiah = new IndexHadiah();
        Hadiah h = hadiahRepository.findByKodeHadiah(kdHadiah);
        hadiah.setIdIndex(indexHadiahRepository.getNextval());
        hadiah.setKodeHadiah(tukarHadiah.getKdHadiah());
        hadiah.setNamaHadiah(h.getNamaHadiah());
        indexHadiahRepository.save(hadiah);       
    }
    
    public ViewTotalPoint totalPoint(String email) {
        ViewTotalPoint point = new ViewTotalPoint();
        int totalPoint = ticketRepository.getTotalPointByEmail(email);
        point.setTotalPoint(totalPoint);
        return point;
    }
}
