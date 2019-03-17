/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.rest.vo;


/**
 *
 * @author abdou
 */
public class TypePersonnelVo {
     private Long id;
    private String libelle;

    
    private PersonnelVo personnelVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public PersonnelVo getPersonnelVo() {
        return personnelVo;
    }

    public void setPersonnelVo(PersonnelVo personnelVo) {
        this.personnelVo = personnelVo;
    }
    
    
}
