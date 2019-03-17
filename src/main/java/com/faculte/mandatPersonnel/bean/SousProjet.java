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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author abdou
 */
@Entity
public class SousProjet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String referenceSousProjet;

    @OneToMany(cascade = {CascadeType.ALL},mappedBy = "sousProjet")
    private List<EntiteAdministratif> entiteAdministratifs;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Projet projet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getReferenceSousProjet() {
        return referenceSousProjet;
    }

    public void setReferenceSousProjet(String referenceSousProjet) {
        this.referenceSousProjet = referenceSousProjet;
    }

    @JsonIgnore
    public List<EntiteAdministratif> getEntiteAdministratifs() {
        return entiteAdministratifs;
    }

    @JsonSetter
    public void setEntiteAdministratifs(List<EntiteAdministratif> entiteAdministratifs) {
        this.entiteAdministratifs = entiteAdministratifs;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
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
        if (!(object instanceof SousProjet)) {
            return false;
        }
        SousProjet other = (SousProjet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Com.faculte.MandatPersonnel.bean.SousProjet[ id=" + id + " ]";
    }

}
