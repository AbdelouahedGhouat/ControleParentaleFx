/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Etudiant;
import bean.Parent;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author abdou
 */
public class ParentService extends AbstractFacade<Parent>{
    
    public ParentService() {
        super(Parent.class);
    }
    
      public Parent findByCin(String cin) {
        List<Parent> parents = getEntityManager().createQuery("SELECT p FROM Parent p where p.cin='" + cin + "'").getResultList();
        if (parents.isEmpty()) {
            return null;
        } else {
            return parents.get(0);
        }
    }

    public int connect(Parent p) {
        List<Parent> parents = getEntityManager().createQuery("SELECT p FROM Parent p where p.cin='" + p.getCin() + "'").getResultList();
        if (parents.isEmpty()) {
            return -1;
        } else if (!parents.get(0).getPassword().equals(p.getPassword())) {
            return -2;
        } else {
            return 1;
        }
    }
    
   public int creerParent( String cin, String password ,String nom, String prenom, Long tel){
        List<Parent> parents = getEntityManager().createQuery("SELECT p FROM Parent p WHERE p.cin='" + cin+"'" ).getResultList();
        if (parents.isEmpty()) {
            Parent parent = new Parent(cin,password ,nom, prenom, tel );
            create(parent);
            return 1;
        } else {
            return -1;
        }
   }
  
//       public void supp( Parent parent ) {
//      getEntityManager().createQuery("UPDATE Etudiant e SET e.parent=null WHERE e.parent.cin='"+ parent.getCin() +"'").executeUpdate();
//           remove(parent);
//}
    
   public void supp( Parent parent ) {
      getEntityManager().createQuery("DELETE FROM Etudiant e WHERE e.parent.cin='"+ parent.getCin() +"'").executeUpdate();
           
}
   
}