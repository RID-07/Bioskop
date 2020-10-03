/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.user.repository.film;

import com.user.entity.film.IndexHadiah;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ridho
 */
@Repository
public interface IndexHadiahRepository extends JpaRepository<IndexHadiah, BigInteger> {
    
    @Query(value = "select nextval('bioskop.indexhadiah_id_index_seq')", nativeQuery = true)
    public BigInteger getNextval();
}
