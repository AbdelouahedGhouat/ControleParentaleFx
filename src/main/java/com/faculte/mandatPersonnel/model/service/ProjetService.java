/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.Projet;
import java.util.List;

/**
 *
 * @author abdou
 */
public interface ProjetService {
    public Projet findByLibelleP(String libelleP);
    public Projet creerProjet(Projet projet);
    public List<Projet> findAll();
    
}
