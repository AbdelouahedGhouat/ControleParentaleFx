/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author abdou
 */
@Entity
public class Mandat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutMandat;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinMandat;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    private Personnel personnel;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    private EntiteAdministratif entiteAdministratif;
    
    @ManyToOne(cascade = {CascadeType.ALL})
    private Responsabilite responsabilite;

    public Date getDateDebutMandat() {
        return dateDebutMandat;
    }

    public void setDateDebutMandat(Date dateDebutMandat) {
        this.dateDebutMandat = dateDebutMandat;
    }

    
    public Date getDateFinMandat() {
        return dateFinMandat;
    }

    public void setDateFinMandat(Date dateFinMandat) {
        this.dateFinMandat = dateFinMandat;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public EntiteAdministratif getEntiteAdministratif() {
        return entiteAdministratif;
    }

    public void setEntiteAdministratif(EntiteAdministratif entiteAdministratif) {
        this.entiteAdministratif = entiteAdministratif;
    }

    public Responsabilite getResponsabilite() {
        return responsabilite;
    }

    public void setResponsabilite(Responsabilite responsabilite) {
        this.responsabilite = responsabilite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mandat)) {
            return false;
        }
        Mandat other = (Mandat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.faculte.MandatPersonnel.bean.Mandat[ id=" + id + " ]";
    }

}
