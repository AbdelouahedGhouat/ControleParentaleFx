/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.dao;

import com.faculte.mandatPersonnel.bean.Responsabilite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdou
 */

@Repository
public interface ResponsabiliteDao extends JpaRepository<Responsabilite, Long>{
    public Responsabilite findByPoste(String poste);
}

