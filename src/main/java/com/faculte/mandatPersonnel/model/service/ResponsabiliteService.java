/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.Responsabilite;

/**
 *
 * @author abdou
 */
public interface ResponsabiliteService {
    public Responsabilite creerResopnsabilite(Responsabilite responsabilite);
    public Responsabilite findByPoste(String poste);
}
