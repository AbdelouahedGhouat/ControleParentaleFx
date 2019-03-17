/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.EntiteAdministratif;
import com.faculte.mandatPersonnel.bean.Mandat;
import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.Responsabilite;
import com.faculte.mandatPersonnel.model.dao.MandatDao;
import com.faculte.mandatPersonnel.model.service.EntiteAdministratifService;
import com.faculte.mandatPersonnel.model.service.MandatService;
import com.faculte.mandatPersonnel.model.service.PersonnelService;
import com.faculte.mandatPersonnel.model.service.ResponsabiliteService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abdou
 */
@Service
public class MandatServiceImpl implements MandatService {

    @Autowired
    private MandatDao mandatDao;

    @Autowired
    private EntiteAdministratifService entiteAdministratifService;
    
    @Autowired
    private ResponsabiliteService responsabiliteService;
    
    @Autowired
    private PersonnelService personnelService;
    
    @Override
    public Mandat findByDateDebutMandatAndPersonnelCin(String cin,Date dateDebutMandat) {
        return mandatDao.findByDateDebutMandatAndPersonnelCin(cin,dateDebutMandat);
    }

    @Override
    public Mandat creerMandat(Mandat mandat) {
        if (mandat != null) {
            Mandat m = findByDateDebutMandatAndPersonnelCin(mandat.getPersonnel().getCin(),mandat.getDateDebutMandat());
            if (m != null ) {
                return null;
            } else {
                mandatDao.save(mandat);
                entiteAdministratifService.createEntiteAdministratif(mandat.getEntiteAdministratif().getReferenceEntiteAdministratif());
                responsabiliteService.creerResopnsabilite(mandat.getResponsabilite());
                personnelService.creerPersonnel(mandat.getPersonnel());
                System.out.println("mandat");
                return mandat;
                
            }
        }
        return null;
    }

    public MandatDao getMandatDao() {
        return mandatDao;
    }

    public void setMandatDao(MandatDao mandatDao) {
        this.mandatDao = mandatDao;
    }

    public EntiteAdministratifService getEntiteAdministratifService() {
        return entiteAdministratifService;
    }

    public void setEntiteAdministratifService(EntiteAdministratifService entiteAdministratifService) {
        this.entiteAdministratifService = entiteAdministratifService;
    }

    public ResponsabiliteService getResponsabiliteService() {
        return responsabiliteService;
    }

    public void setResponsabiliteService(ResponsabiliteService responsabiliteService) {
        this.responsabiliteService = responsabiliteService;
    }

    public PersonnelService getPersonnelService() {
        return personnelService;
    }

    public void setPersonnelService(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    
}
