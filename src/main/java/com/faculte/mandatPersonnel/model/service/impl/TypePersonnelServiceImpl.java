/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.model.service.impl;

import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.bean.TypePersonnel;
import com.faculte.mandatPersonnel.model.dao.TypePersonnelDao;
import com.faculte.mandatPersonnel.model.service.TypePersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





/**
 *
 * @author abdou
 */
@Service
public class TypePersonnelServiceImpl implements TypePersonnelService{

    @Autowired
     private TypePersonnelDao typePersonnelDao;
    
    @Override
    public TypePersonnel findByPersonnel(Personnel personnel) {
        return typePersonnelDao.findByPersonnel(personnel);
    }
      @Override
    public TypePersonnel findByLibelle(String libelle) {
        return typePersonnelDao.findByLibelle(libelle);
    }
    @Override
    public TypePersonnel createTypePersonnel(String libelle){
        TypePersonnel p = findByLibelle(libelle);
        if(p!= null){
            return null;
        }
        else{
        TypePersonnel typePersonnel = new TypePersonnel();
        typePersonnel.setLibelle(libelle);
        typePersonnelDao.save(typePersonnel);
        return typePersonnel;
    }
        
    }

  

    
}

