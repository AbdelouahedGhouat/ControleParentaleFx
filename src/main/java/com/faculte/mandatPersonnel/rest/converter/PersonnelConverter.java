/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.converter;

import com.faculte.mandatPersonnel.bean.Personnel;
import com.faculte.mandatPersonnel.common.util.DateUtil;
import com.faculte.mandatPersonnel.common.util.NumberUtil;
import com.faculte.mandatPersonnel.rest.vo.PersonnelVo;


/**
 *
 * @author abdou
 */
public class PersonnelConverter extends AbstractConverter<Personnel ,PersonnelVo>{

    @Override
    public Personnel toItem(PersonnelVo vo) {
         
        if (vo == null) {
            return null;
        } else {
            Personnel item = new Personnel();
            item.setId(vo.getId());
            item.setCin(vo.getCin());
            item.setCodeEchelle(vo.getCodeEchelle());
            item.setCodeEchelon(vo.getCodeEchelon());
            item.setDateAccesFonctionPublique(DateUtil.parse(vo.getDateAccesFonctionPublique()));
            item.setDateActivation(DateUtil.parse(vo.getDateActivation()));
            item.setDateDebutTypePersonnel(DateUtil.parse(vo.getDateDebutTypePersonnel()));
            item.setDateExerciceEchelle(DateUtil.parse(vo.getDateExerciceEchelle()));
            item.setDateNaissance(DateUtil.parse(vo.getDateNaissance()));
            item.setEtatSocial(vo.getEtatSocial());
            item.setGrade(vo.getGrade());
            item.setLieuAffectation(vo.getLieuAffectation());
            item.setLieuNaissance(vo.getLieuNaissance());
            item.setNom(vo.getNom());
            item.setNombreEnfants(NumberUtil.toBigDecimal(vo.getNombreEnfants()));
            item.setNumeroLocation(vo.getNumeroLocation());
            item.setPrenom(vo.getPrenom());
            item.setTypePersonnel(new TypePersonnelConverter().toItem(vo.getTypePersonnelVo()));
            
            
            return item;
        }
    }
    

    @Override
    public PersonnelVo toVo(Personnel item) {
             if(item==null){
            return null;
        }
        else{
            PersonnelVo vo =new PersonnelVo();
            vo.setId(item.getId());
            vo.setCin(item.getCin());
            vo.setCodeEchelle(item.getCodeEchelle());
            vo.setCodeEchelon(item.getCodeEchelon());
            vo.setDateAccesFonctionPublique(DateUtil.formateDate(item.getDateAccesFonctionPublique()));
            vo.setDateActivation(DateUtil.formateDate(item.getDateActivation()));
            vo.setDateDebutTypePersonnel(DateUtil.formateDate(item.getDateDebutTypePersonnel()));
            vo.setDateExerciceEchelle(DateUtil.formateDate(item.getDateExerciceEchelle()));
            vo.setDateNaissance(DateUtil.formateDate(item.getDateNaissance()));
            vo.setEtatSocial(item.getEtatSocial());
            vo.setGrade(item.getGrade());
            vo.setLieuAffectation(item.getLieuAffectation());
            vo.setLieuNaissance(item.getLieuNaissance());
            vo.setNom(item.getNom());
            vo.setNombreEnfants(NumberUtil.toString(item.getNombreEnfants()));
            vo.setNumeroLocation(item.getNumeroLocation());
            vo.setPrenom(item.getPrenom());
            vo.setTypePersonnelVo(new TypePersonnelConverter().toVo(item.getTypePersonnel()));
            return vo;
        }
    

    }
    }
    
