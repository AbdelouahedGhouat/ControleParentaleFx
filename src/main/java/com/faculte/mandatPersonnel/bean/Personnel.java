/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.mandatPersonnel.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author abdou
 */
@Entity
public class Personnel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String etatSocial;
    private String cin;
    private String numeroLocation;
    private String lieuNaissance;
    private BigDecimal nombreEnfants;
    private String lieuAffectation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateExerciceEchelle;
    private String grade;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateActivation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateAccesFonctionPublique;
    @OneToOne(cascade = {CascadeType.ALL})
    private TypePersonnel typePersonnel;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutTypePersonnel;
    private String codeEchelle;
    private String codeEchelon;
 
    public Personnel() {
    }
    
    
   

  
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEtatSocial() {
        return etatSocial;
    }

    public void setEtatSocial(String etatSocial) {
        this.etatSocial = etatSocial;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNumeroLocation() {
        return numeroLocation;
    }

    public void setNumeroLocation(String numeroLocation) {
        this.numeroLocation = numeroLocation;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public BigDecimal getNombreEnfants() {
        return nombreEnfants;
    }

    public void setNombreEnfants(BigDecimal nombreEnfants) {
        this.nombreEnfants = nombreEnfants;
    }

   

    public String getLieuAffectation() {
        return lieuAffectation;
    }

    public void setLieuAffectation(String lieuAffectation) {
        this.lieuAffectation = lieuAffectation;
    }

    public Date getDateExerciceEchelle() {
        return dateExerciceEchelle;
    }

    public void setDateExerciceEchelle(Date dateExerciceEchelle) {
        this.dateExerciceEchelle = dateExerciceEchelle;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Date getDateActivation() {
        return dateActivation;
    }

    public void setDateActivation(Date dateActivation) {
        this.dateActivation = dateActivation;
    }

    public Date getDateAccesFonctionPublique() {
        return dateAccesFonctionPublique;
    }

    public void setDateAccesFonctionPublique(Date dateAccesFonctionPublique) {
        this.dateAccesFonctionPublique = dateAccesFonctionPublique;
    }

    @JsonIgnore
    public TypePersonnel getTypePersonnel() {
        return typePersonnel;
    }

    @JsonSetter
    public void setTypePersonnel(TypePersonnel typePersonnel) {
        this.typePersonnel = typePersonnel;
    }

    public Date getDateDebutTypePersonnel() {
        return dateDebutTypePersonnel;
    }

    public void setDateDebutTypePersonnel(Date dateDebutTypePersonnel) {
        this.dateDebutTypePersonnel = dateDebutTypePersonnel;
    }

    public String getCodeEchelle() {
        return codeEchelle;
    }

    public void setCodeEchelle(String codeEchelle) {
        this.codeEchelle = codeEchelle;
    }

    public String getCodeEchelon() {
        return codeEchelon;
    }

    public void setCodeEchelon(String codeEchelon) {
        this.codeEchelon = codeEchelon;
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
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.MicroServiceS.MicroServiceS.bean.Personnel[ id=" + id + " ]";
    }

}
