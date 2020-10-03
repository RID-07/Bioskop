/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.repository.bioskop;

import com.film.entity.bioskop.Tiket;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ridho
 */
@Repository
public interface TiketRepository extends JpaRepository<Tiket, String> {

    public Tiket findByKdTicket(String kdTicket);

    @Query(value = "select now()", nativeQuery = true)
    public Date getDate();

    @Query(value = "select count(a.kode_film)"
            + " from bioskop.ticket a"
            + " join bioskop.datafilm b on a.kode_film = b.kode_film"
            + " where b.kode_film = :kdFilm", nativeQuery = true)
    public Integer getKdFilm(@Param("kdFilm") String kdFilm);

    @Transactional
    @Modifying
    @Query(value = "delete from bioskop.ticket where kode_ticket = :kdTicket", nativeQuery = true)
    public void deleteByKdTicket(@Param("kdTicket") String kdTicket);
}
