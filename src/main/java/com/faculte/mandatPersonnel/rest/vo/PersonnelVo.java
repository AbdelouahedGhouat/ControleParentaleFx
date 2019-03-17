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

public class PersonnelVo {
    private Long id;
    private String nom;    
    private String prenom;
    private String dateNaissance;
    private String etatSocial;
    private String cin;
    private String numeroLocation;
    private String lieuNaissance;
    private String nombreEnfants;
    private String lieuAffectation;
    private String dateExerciceEchelle;
    private String grade;
    private String dateActivation;
    private String dateAccesFonctionPublique;
    private TypePersonnelVo typePersonnelVo;
    private String dateDebutTypePersonnel;
    private String codeEchelle;
    private String codeEchelon;

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

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
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

    public String getNombreEnfants() {
        return nombreEnfants;
    }

    public void setNombreEnfants(String nombreEnfants) {
        this.nombreEnfants = nombreEnfants;
    }

    public String getLieuAffectation() {
        return lieuAffectation;
    }

    public void setLieuAffectation(String lieuAffectation) {
        this.lieuAffectation = lieuAffectation;
    }

    public String getDateExerciceEchelle() {
        return dateExerciceEchelle;
    }

    public void setDateExerciceEchelle(String dateExerciceEchelle) {
        this.dateExerciceEchelle = dateExerciceEchelle;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDateActivation() {
        return dateActivation;
    }

    public void setDateActivation(String dateActivation) {
        this.dateActivation = dateActivation;
    }

    public String getDateAccesFonctionPublique() {
        return dateAccesFonctionPublique;
    }

    public void setDateAccesFonctionPublique(String dateAccesFonctionPublique) {
        this.dateAccesFonctionPublique = dateAccesFonctionPublique;
    }

    public TypePersonnelVo getTypePersonnelVo() {
        return typePersonnelVo;
    }

   
    public void setTypePersonnelVo(TypePersonnelVo typePersonnelVo) {
        this.typePersonnelVo = typePersonnelVo;
    }

    public String getDateDebutTypePersonnel() {
        return dateDebutTypePersonnel;
    }

    public void setDateDebutTypePersonnel(String dateDebutTypePersonnel) {
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
    
    
    
}
