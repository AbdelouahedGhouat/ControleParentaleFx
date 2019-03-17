/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classe;
import bean.Etudiant;
import bean.Parent;
import java.util.List;

/**
 *
 * @author abdou
 */
public class EtudiantService extends AbstractFacade<Etudiant> {

    public EtudiantService() {
        super(Etudiant.class);
    }

    public int creerEtudiant(Long id ,String nom, String prenom, Classe classe, Parent parent) {
        List<Etudiant> etudiants = getEntityManager().createQuery("SELECT e FROM Etudiant e WHERE e.id="+ id ).getResultList();
        if (etudiants.isEmpty()) {
            Etudiant etu = new Etudiant(nom, prenom, classe, parent);
            create(etu);
            return 1;
        } else {
            return -1;
        }
    }

    

    public List<Etudiant> findByParent(String cin) {
        List<Etudiant> etudiants = getEntityManager().createQuery("SELECT e from Etudiant e WHERE e.parent.cin='" + cin + "'").getResultList();
        return etudiants;
    }

    public List<Etudiant> findByClasse(Classe c) {
        return getEntityManager().createQuery("SELECT e FROM Etudiant e WHERE e.classe.id=" + c.getId()).getResultList();
    }
    
    
    
     public List<Etudiant> findByParent(Long id){
       return getEntityManager().createQuery("SELECT e FROM Etudiant e WHERE e.parent.id="+ id).getResultList();
   }
     
     public List<Etudiant> findByParentClasse(Long parent ,Long ecole){
         return getEntityManager().createQuery("SELECT e FROM Etudiant e WHERE e.parent.id="+ parent+ " and e.classe.ecolePrive.id="+ ecole).getResultList();
     }
    
   
}
