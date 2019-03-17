/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



/**
 *
 * @author abdou
 */

@Entity
public class Projet implements Serializable {

    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelleP;

    @OneToMany(mappedBy = "projet")
    private List<SousProjet> sousProjets;
    
    public String getLibelleP() {
        return libelleP;
    }

    public void setLibelleP(String libelleP) {
        this.libelleP = libelleP;
    }

    @JsonIgnore
    public List<SousProjet> getSousProjets() {
        return sousProjets;
    }

    @JsonSetter
    public void setSousProjets(List<SousProjet> sousProjets) {
        this.sousProjets = sousProjets;
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
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.faculte.MandatPersonnel.bean.Projet[ id=" + id + " ]";
    }
    
    
}
