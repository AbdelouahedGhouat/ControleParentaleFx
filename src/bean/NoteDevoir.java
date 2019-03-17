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

/**
 *
 * @author abdou
 */
@Entity
public class NoteDevoir implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double note;
    @ManyToOne
    private Devoir devoir;
    @ManyToOne
    private Etudiant etudient;

    public NoteDevoir() {
    }

    public NoteDevoir(Long id, Devoir devoir, Etudiant etudient) {
        this.id = id;
        this.devoir = devoir;
        this.etudient = etudient;
    }
    
    

    public NoteDevoir(double note, Devoir devoir, Etudiant etudient) {
        this.note = note;
        this.devoir = devoir;
        this.etudient = etudient;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public Devoir getDevoir() {
        return devoir;
    }

    public void setDevoir(Devoir devoir) {
        this.devoir = devoir;
    }

    public Etudiant getEtudient() {
        return etudient;
    }

    public void setEtudient(Etudiant etudient) {
        this.etudient = etudient;
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
        if (!(object instanceof NoteDevoir)) {
            return false;
        }
        NoteDevoir other = (NoteDevoir) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.NoteDevoir[ id=" + id + " ]";
    }
    
}
