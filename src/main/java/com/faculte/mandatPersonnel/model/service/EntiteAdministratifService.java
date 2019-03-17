/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;

/**
 *
 * @author abdou
 */
public interface EntiteAdministratifService {
    public EntiteAdministratif createEntiteAdministratif(String entite);
    public EntiteAdministratif findByReferenceEntiteAdministratif(String referenceEntiteAdministratif);
}
