package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Id;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author abdou
 */
@Entity
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Parent parent;

    public Etudiant() {
    }

    public Etudiant(Long id, String nom, String prenom, Classe classe, Parent parent) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.parent = parent;
    }
    

    public Etudiant(String nom, String prenom, Classe classe, Parent parent) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
        this.parent = parent;
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

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
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
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Etudiant other = (Etudiant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

     @Override
    public String toString() {
        return ""+prenom;
    }
}
