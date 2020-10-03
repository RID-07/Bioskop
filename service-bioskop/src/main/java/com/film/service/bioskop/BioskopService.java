/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.service.bioskop;

import com.film.entity.bioskop.DataFilm;
import com.film.entity.bioskop.Hadiah;
import com.film.entity.bioskop.Studio;
import com.film.entity.bioskop.Tiket;
import com.film.repository.bioskop.DataFilmRepository;
import com.film.repository.bioskop.HadiahRepository;
import com.film.repository.bioskop.StudioRepository;
import com.film.repository.bioskop.TiketRepository;
import com.film.view.ViewFilm;
import com.film.view.ViewHadiah;
import com.film.view.ViewKarcis;
import com.film.view.ViewResponse;
import com.film.view.ViewStudio;
import com.film.view.ViewTiket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ridho
 */
@Service
public class BioskopService {

    @Autowired
    TiketRepository tiketRepository;
    @Autowired
    DataFilmRepository dataFilmRepository;
    @Autowired
    StudioRepository studioRepository;
    @Autowired
    HadiahRepository hadiahRepository;

    public ViewResponse postResponse(ViewTiket viewTiket) {
        ViewResponse response = new ViewResponse();
        DataFilm dataFilm = dataFilmRepository.findByKdFilm(viewTiket.getKdFilm());
        Integer count = tiketRepository.getKdFilm(dataFilm.getKdFilm());
        Integer kapasitas = studioRepository.getKapasitas(dataFilm.getKdStudio());
        if (count.compareTo(kapasitas) > 0) {
            response.setRes("Jumlah Penonton melebihi kapasitas studio!");
        } else {
            saveTiket(viewTiket);
            response.setRes("Berhasil simpan data");
        }
        return response;
    }

    public ViewResponse putResponse(ViewTiket viewTiket, String kdTicket) {
        ViewResponse response = new ViewResponse();
        Tiket tiket = tiketRepository.findByKdTicket(kdTicket);
        DataFilm dataFilm = dataFilmRepository.findByKdFilm(tiket.getKdFilm());
        Integer count = tiketRepository.getKdFilm(dataFilm.getKdFilm());
        Integer kapasitas = studioRepository.getKapasitas(dataFilm.getKdStudio());
        if (count.compareTo(kapasitas) > 0) {
            response.setRes("Jumlah Penonton melebihi kapasitas studio!");
        } else {
            updateTiket(viewTiket, kdTicket);
            response.setRes("Berhasil update data");
        }
        return response;
    }

    public ViewKarcis selectViewKarcis(String kdTicket) {
        ViewKarcis karcis = new ViewKarcis();
        Tiket tiket = tiketRepository.findByKdTicket(kdTicket);
        DataFilm dataFilm = dataFilmRepository.findByKdFilm(tiket.getKdFilm());
        karcis.setKodeTiket(tiket.getKdTicket());
        karcis.setKodeStudio(dataFilm.getKdStudio());
        karcis.setNamaPembeli(tiket.getNamaPembeli());
        karcis.setJudulFilm(dataFilm.getJudulFilm());
        karcis.setWaktuFilm(dataFilm.getWaktuFilm());
        karcis.setPoint(tiket.getPoint());
        return karcis;
    }
    
    public ViewFilm selectViewFilm(String kdFilm) {
        ViewFilm film = new ViewFilm();
        DataFilm dataFilm = dataFilmRepository.findByKdFilm(kdFilm);
        film.setJudulFilm(dataFilm.getJudulFilm());
        film.setKdFilm(dataFilm.getKdFilm());
        film.setKdStudio(dataFilm.getKdStudio());
        film.setWaktuFilm(dataFilm.getWaktuFilm());
        return film;
    }
    
    public ViewStudio selectViewStudio(String kdStudio) {
        ViewStudio studio = new ViewStudio();
        Studio s = studioRepository.findByKdStudio(kdStudio);
        studio.setKdStudio(s.getKdStudio());
        studio.setKapasitas(s.getKapasitas());
        return studio;
    }

    public Tiket saveTiket(ViewTiket viewTiket) {
        Tiket tiket = new Tiket();
        tiket.setKdTicket(viewTiket.getKdTicket());
        tiket.setKdFilm(viewTiket.getKdFilm());
        tiket.setNamaPembeli(viewTiket.getNamaPembeli());
        tiket.setEmail(viewTiket.getEmail());
        tiket.setNoTelp(viewTiket.getNoTelp());
        tiket.setWaktuBeli(tiketRepository.getDate());
        tiket.setPoint(5);
        tiketRepository.save(tiket);
        return tiket;
    }

    public Tiket updateTiket(ViewTiket viewTiket, String kdTicket) {
        Tiket tiket = tiketRepository.findByKdTicket(kdTicket);
        tiket.setKdTicket(viewTiket.getKdTicket());
        tiket.setKdFilm(viewTiket.getKdFilm());
        tiket.setNamaPembeli(viewTiket.getNamaPembeli());
        tiket.setEmail(viewTiket.getEmail());
        tiket.setNoTelp(viewTiket.getNoTelp());
        tiket.setWaktuBeli(tiketRepository.getDate());
        tiketRepository.save(tiket);
        return tiket;
    }

    public DataFilm saveDataFilm(ViewFilm viewFilm) {
        DataFilm dataFilm = new DataFilm();
        dataFilm.setKdFilm(viewFilm.getKdFilm());
        dataFilm.setKdStudio(viewFilm.getKdFilm());
        dataFilm.setJudulFilm(viewFilm.getJudulFilm());
        dataFilm.setWaktuFilm(viewFilm.getWaktuFilm());
        dataFilmRepository.save(dataFilm);
        return dataFilm;
    }

    public Studio saveStudio(ViewStudio viewStudio) {
        Studio studio = new Studio();
        studio.setKdStudio(viewStudio.getKdStudio());
        studio.setKapasitas(viewStudio.getKapasitas());
        studioRepository.save(studio);
        return studio;
    }
    
    public void saveHadiah(ViewHadiah viewHadiah) {
        Hadiah hadiah = new Hadiah();
        hadiah.setKodeHadiah(viewHadiah.getKodeHadiah());
        hadiah.setNamaHadiah(viewHadiah.getNamaHadiah());
        hadiah.setTotalPoint(viewHadiah.getTotalPoint());
        hadiahRepository.save(hadiah);
    }
}
