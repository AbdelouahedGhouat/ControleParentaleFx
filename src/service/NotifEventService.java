/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Etudiant;
import bean.Evenement;
import bean.NotifEvent;
import java.util.List;
import util.DateUtil;

/**
 *
 * @author abdou
 */
public class NotifEventService extends AbstractFacade<NotifEvent> {

    EtudiantService etudiantService = new EtudiantService();

    public NotifEventService() {
        super(NotifEvent.class);

    }

    public List<NotifEvent> findByEtdudiant(Long id) {
        List<NotifEvent> notifEvents = getEntityManager().createQuery("SELECT ne From NotifEvent ne WHERE ne.etudiant.id=" + id).getResultList();
        notifEvents.stream().forEach(d -> {
            if (d.getDateLecture() != null) {
                d.setDateLecture(DateUtil.convertFromDateToTimestamp(d.getDateLecture()));
            }
        });
        return notifEvents;
    }

    public void creer(Evenement e) {
        List<Etudiant> etu = etudiantService.findByClasse(e.getClasse());
        for (Etudiant etudiant : etu) {
            NotifEvent notifEvent = new NotifEvent(etudiant, e);
            create(notifEvent);
        }
    }

    public void suppByEvent(Evenement e) {
        List<NotifEvent> notifEvents = getEntityManager().createQuery("SELECT n FROM NotifEvent n WHERE n.evenement.id=" + e.getId()).getResultList();
        for (NotifEvent notifEvent : notifEvents) {
            remove(notifEvent);
        }
    }

    public List<NotifEvent> findByEvent(Long id) {
        return getEntityManager().createQuery("SELECT n FROM NotifEvent n WHERE n.evenement.id=" + id).getResultList();
    }
}
