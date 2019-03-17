/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classe;
import bean.Devoir;
import bean.Etudiant;
import bean.NoteDevoir;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abdou
 */
public class NoteDevoirService extends AbstractFacade<NoteDevoir> {
    
    EtudiantService etudiantService = new EtudiantService();
    
    public NoteDevoirService() {
        super(NoteDevoir.class);
    }
    
    public List<NoteDevoir> creerNote(Devoir d) {
        List<NoteDevoir> noteDevoirs = new ArrayList<>();
        List<Etudiant> etu = etudiantService.findByClasse(d.getMatiere().getClasse());
        for (Etudiant etudiant : etu) {
            NoteDevoir noteDevoir = new NoteDevoir(generateId("NoteDevoir", "id"), d, etudiant);
            create(noteDevoir);
            noteDevoirs.add(noteDevoir);
        }
        return noteDevoirs;
    }
    
    public void suppByDevoir(Devoir d) {
        List<NoteDevoir> noteDevoirs = getEntityManager().createQuery("SELECT n FROM NoteDevoir n where n.devoir.id=" + d.getId()).getResultList();
        for (NoteDevoir noteDevoir : noteDevoirs) {
            remove(noteDevoir);
        }
    }
    
    public void updateNote(Devoir d, Etudiant e, Double note) {
//        getEntityManager().createQuery("Update NoteDevoir n SET n.note=" + note + " where n.devoir.id=" + d.getId() + ""
//                + " and n.etudient.id=" + e.getId()).executeUpdate();
        List<NoteDevoir> noteDevoirs = getEntityManager().createQuery("SELECT n FROM NoteDevoir n where n.devoir.id=" + d.getId() + " and n.etudient.id=" + e.getId()).getResultList();
        if (!noteDevoirs.isEmpty()) {
            NoteDevoir noteDevoir = noteDevoirs.get(0);
            noteDevoir.setNote(note);
            edit(noteDevoir);
        } else {
            NoteDevoir noteDevoir = new NoteDevoir(note, d, e);
            create(noteDevoir);
        }
    }
    
    public List<NoteDevoir> findByClasse(Classe c) {
        return getEntityManager().createQuery("SELECT n FROM NoteDevoir n WHERE n.devoir.matiere.classe.id=" + c.getId()).getResultList();
    }
    public List<NoteDevoir> findByDevoir(Devoir d) {
        return getEntityManager().createQuery("SELECT n FROM NoteDevoir n WHERE n.devoir.id=" + d.getId()).getResultList();
    }
    
}
