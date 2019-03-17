/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.Responsabilite;
import com.faculte.mandatPersonnel.model.dao.ResponsabiliteDao;
import com.faculte.mandatPersonnel.model.service.ResponsabiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdou
 */
@Service
public class ResponsabiliteServiceImlp implements ResponsabiliteService {

    @Autowired
    private ResponsabiliteDao responsabiliteDao;

    @Override
    public Responsabilite findByPoste(String poste) {
        return responsabiliteDao.findByPoste(poste);
    }

    @Override
    public Responsabilite creerResopnsabilite(Responsabilite responsabilite) {
        Responsabilite r = findByPoste(responsabilite.getPoste());
        if (r != null) {
            return null;
        } else {
            r = new Responsabilite();
            r.setPoste(responsabilite.getPoste());
            responsabiliteDao.save(r);
            return r;
        }

    }

    public ResponsabiliteDao getResponsabiliteDao() {
        return responsabiliteDao;
    }

    public void setResponsabiliteDao(ResponsabiliteDao responsabiliteDao) {
        this.responsabiliteDao = responsabiliteDao;
    }

}
