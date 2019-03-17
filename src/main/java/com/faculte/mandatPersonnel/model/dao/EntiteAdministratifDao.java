/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.dao;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author abdou
 */
@Repository
public interface EntiteAdministratifDao extends JpaRepository<EntiteAdministratif, Long>{
     public EntiteAdministratif findByReferenceEntiteAdministratif(String referenceEntiteAdministratif);
}

