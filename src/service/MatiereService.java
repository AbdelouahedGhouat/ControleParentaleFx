/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classe;
import bean.Etudiant;
import bean.Matiere;
import java.util.List;

/**
 *
 * @author abdou
 */
public class MatiereService extends AbstractFacade<Matiere> {

    public MatiereService() {
        super(Matiere.class);
    }

    public int creer(Matiere m) {
        List<Matiere> matieres = getEntityManager().createQuery("SELECT m FROM Matiere m where m.nom='" + m.getNom() + "' and m.classe.id='" + m.getClasse().getId() + "'").getResultList();
        if (matieres.isEmpty()) {
            create(m);
            return 1;
        } else {
            return -1;
        }
    }
    
    public List<Matiere> findByClasse(Long id){
        return getEntityManager().createQuery("SELECT m FROM Matiere m where m.classe.id=" + id).getResultList();
    }
        public List<Matiere> findByEtudiant( Etudiant e){
        return getEntityManager().createQuery("SELECT m FROM Matiere m where m.classe.id" + e.getId()).getResultList();
    }
    
}
