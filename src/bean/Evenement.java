package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import util.DateUtil;

/**
 *
 * @author abdou
 */
@Entity
public class Evenement implements Serializable {

   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String description ;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date date;
   
    @ManyToOne
    private Classe classe;    
    @OneToOne
    private TypeEvent type;

    public Evenement() {
    }

    public Evenement(String nom, Date date, Classe classe, TypeEvent type) {
        this.nom = nom;
        this.date = date;
        this.classe = classe;
        this.type = type;
    }

    public Evenement(String nom, String description, Date date, Classe classe, TypeEvent type) {
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.classe = classe;
        this.type = type;
    }
 
    
    public Evenement(String nom, Date date, Classe classe) {
        this.nom = nom;
        this.date = date;
        this.classe = classe;
    }
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Classe getClasse() {
        return classe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public TypeEvent getTypeEvent() {
        return type;
    }

    public void setTypeEvent(TypeEvent type) {
        this.type = type;
    }

   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evenement)) {
            return false;
        }
        Evenement other = (Evenement) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ""+nom+" - "+type+" - "+DateUtil.formateDate("dd-MM-yyyy hh:mm", date);
    }
    
}
