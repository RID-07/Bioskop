/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.film.repository.bioskop;

import com.film.entity.bioskop.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ridho
 */
@Repository
public interface StudioRepository extends JpaRepository<Studio, String> {

    @Query(value = "select kapasitas"
            + " from bioskop.studio"
            + " where kode_studio = :kdStudio", nativeQuery = true)
    public Integer getKapasitas(@Param("kdStudio") String kdStudio);
    
    public Studio findByKdStudio(String kdStudio);
}
