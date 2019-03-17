/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Classe;
import bean.Evenement;
import bean.TypeEvent;
import java.util.Date;
import java.util.List;

/**
 *
 * @author abdou
 */
public class EventService extends AbstractFacade<Evenement> {

    NotifEventService notifEventService = new NotifEventService();

    public EventService() {
        super(Evenement.class);
    }

    public int creerEvent(String nom, Date date, Classe c, String description, TypeEvent type) {
        List<Evenement> events = getEntityManager().createQuery("SELECT e FROM Evenement e where e.nom='" + c.getNom() + "' and e.date='" + date + "' and e.classe.id='" + c.getId() + "' and e.type.id=" + type.getId()).getResultList();
        if (events.isEmpty()) {
            Evenement evenement = new Evenement(nom, description, date, c, type);
            evenement.setId(generateId("Evenement", "id"));
            create(evenement);
            notifEventService.creer(evenement);
            return 1;
        } else {
            return -1;
        }

    }

    public List<Classe> findByEcole(Long ecole) {
        return getEntityManager().createQuery("SELECT c FROM Classe c where c.ecolePrive.id=" + ecole).getResultList();
    }

    public List<Evenement> findByClasse(Long id) {
        return getEntityManager().createQuery("SELECT e FROM Evenement e where e.classe.id=" + id + " ORDER BY e.date DESC").getResultList();
    }
    
   
     public void supprimer(Evenement e) {
        notifEventService.suppByEvent(e);
        remove(e);
    }
}
