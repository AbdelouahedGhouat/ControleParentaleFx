/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.dao;

import com.faculte.mandatPersonnel.bean.Projet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



/**
 *
 * @author abdou
 */
@Repository
public interface ProjetDao extends JpaRepository<Projet ,Long> {
    public Projet findByLibelleP(String libelleP);
    
}
