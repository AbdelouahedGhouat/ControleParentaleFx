/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classe;
import bean.EcolePrive;
import java.util.List;

/**
 *
 * @author abdou
 */
public class ClasseService extends AbstractFacade<Classe> {

    public ClasseService() {
        super(Classe.class);
    }

    public int creerClasse(String nom, EcolePrive ecole) {
        List<Classe> classes = getEntityManager().createQuery("SELECT c FROM Classe c WHERE c.nom='" + nom + "' and c.ecolePrive.id='" + ecole.getId() + "'").getResultList();
        if (classes.isEmpty()) {
            Classe classe = new Classe(nom, ecole);
            create(classe);
            return 1;
        } else {
            return -1;
        }
    }

    public int modifierClasse(Classe c, String name) {
        int res = creerClasse(name, c.getEcolePrive());
        if (res == 1) {
            remove(c);
        }
        return res;
    }

    public List<Classe> findByEcole(Long ecole) {
        return getEntityManager().createQuery("SELECT c FROM Classe c where c.ecolePrive.id=" + ecole).getResultList();
    }

    /*public void delete(Classe c){
        getEntityManager().createQuery("DELETE FROM Classe c where c.nom='"+c.getId()+"' and c.ecolePrive.id='" + c.getEcolePrive().getId() + "'").executeUpdate();
    }*/
}
