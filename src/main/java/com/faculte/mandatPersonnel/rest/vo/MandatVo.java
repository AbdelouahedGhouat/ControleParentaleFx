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
public class MandatVo {
    private Long id;
    private String dateDebutMandat;
    private String dateFinMandat;
    private PersonnelVo personnelVo;
    private EntiteAdministratifVo entiteAdministratifVo;
    private ResponsabiliteVo responsabiliteVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateDebutMandat() {
        return dateDebutMandat;
    }

    public void setDateDebutMandat(String dateDebutMandat) {
        this.dateDebutMandat = dateDebutMandat;
    }

    public String getDateFinMandat() {
        return dateFinMandat;
    }

    public void setDateFinMandat(String dateFinMandat) {
        this.dateFinMandat = dateFinMandat;
    }

    public PersonnelVo getPersonnelVo() {
        return personnelVo;
    }

    public void setPersonnelVo(PersonnelVo personnelVo) {
        this.personnelVo = personnelVo;
    }

    public EntiteAdministratifVo getEntiteAdministratifVo() {
        return entiteAdministratifVo;
    }

    public void setEntiteAdministratifVo(EntiteAdministratifVo entiteAdministratifVo) {
        this.entiteAdministratifVo = entiteAdministratifVo;
    }

    public ResponsabiliteVo getResponsabiliteVo() {
        return responsabiliteVo;
    }

    public void setResponsabiliteVo(ResponsabiliteVo responsabiliteVo) {
        this.responsabiliteVo = responsabiliteVo;
    }
    
    
    
    
}
