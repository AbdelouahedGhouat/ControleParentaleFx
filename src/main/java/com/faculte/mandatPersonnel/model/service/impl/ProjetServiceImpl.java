/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.Projet;
import com.faculte.mandatPersonnel.bean.SousProjet;
import com.faculte.mandatPersonnel.model.dao.ProjetDao;
import com.faculte.mandatPersonnel.model.service.ProjetService;
import com.faculte.mandatPersonnel.model.service.SousProjetService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





/**
 *
 * @author abdou
 */
@Service
public class ProjetServiceImpl  implements ProjetService{

    @Autowired
    private ProjetDao projetDao ;
    
    @Autowired
    private SousProjetService sousProjetService;

    @Override
    public Projet findByLibelleP(String libelleP) {
        return projetDao.findByLibelleP(libelleP);
    }
    
   @Override
    public Projet creerProjet(Projet projet) {
        Projet p = findByLibelleP(projet.getLibelleP());
        if (p != null) {
            return null;
        } else {
            projetDao.save(projet);
            List<SousProjet> sousProjets = projet.getSousProjets();
            for (SousProjet sousProjet : sousProjets) {
                sousProjet.setProjet(projet);
                sousProjetService.creerSousProjet(sousProjet);
            }
            return projet;
        }
    }

@Override
    public List<Projet> findAll() {
        return projetDao.findAll();
    }
    

    
    public ProjetDao getProjetDao() {
        return projetDao;
    }

    public void setProjetDao(ProjetDao projetDao) {
        this.projetDao = projetDao;
    }

    public SousProjetService getSousProjetService() {
        return sousProjetService;
    }

    public void setSousProjetService(SousProjetService sousProjetService) {
        this.sousProjetService = sousProjetService;
    }

    
    
    
    
    
    
    
    
}
