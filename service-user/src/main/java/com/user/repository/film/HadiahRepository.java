/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.repository.film;

import com.user.entity.film.Hadiah;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ridho
 */
@Repository
public interface HadiahRepository extends JpaRepository<Hadiah, String>{
    
    @Override
    public List<Hadiah> findAll();
    
    public Hadiah findByKodeHadiah(String kodeHadiah);
}
