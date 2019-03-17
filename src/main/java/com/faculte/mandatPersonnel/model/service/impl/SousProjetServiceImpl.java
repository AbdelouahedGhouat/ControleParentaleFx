/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.Projet;
import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.model.dao.SousProjetDao;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





/**
 *
 * @author abdou
 */
@Service
public class SousProjetServiceImpl implements SousProjetService{
    
    @Autowired
    private SousProjetDao sousProjetDao;

    @Override
    public SousProjet findByReferenceSousProjet(String referenceSousProjet) {
        return sousProjetDao.findByReferenceSousProjet(referenceSousProjet);
    }

    @Override
    public List<SousProjet> findByProjetLibelleP(String libelleP) {
        return sousProjetDao.findByProjetLibelleP(libelleP);
    }

    @Override
    public int creerSousProjet(SousProjet sousProjet) {
        sousProjetDao.save(sousProjet);
        return 1 ;
    }

    public SousProjetDao getSousProjetDao() {
        return sousProjetDao;
    }

    public void setSousProjetDao(SousProjetDao sousProjetDao) {
        this.sousProjetDao = sousProjetDao;
    }

    
    
    
}
