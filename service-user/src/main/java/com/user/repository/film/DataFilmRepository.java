/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.repository.film;

import com.user.entity.film.DataFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ridho
 */
@Repository
public interface DataFilmRepository extends JpaRepository<DataFilm, String>{
    
    public DataFilm findByKdFilm(String kdFilm);
}
