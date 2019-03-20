/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Devoir;
import bean.NoteDevoir;
import bean.NotifDevoir;
import java.util.List;
import util.DateUtil;

/**
 *
 * @author abdou
 */
public class NotifDevoirService extends AbstractFacade<NotifDevoir> {

    NoteDevoirService noteDevoirService = new NoteDevoirService();

    public NotifDevoirService() {
        super(NotifDevoir.class);
    }

    public List<NotifDevoir> findByEtudiant(Long id) {
        List<NotifDevoir> notifDevoirs = getEntityManager().createQuery("SELECT nd From NotifDevoir nd where nd.notedevoir.etudient.id=" + id).getResultList();
        notifDevoirs.stream().forEach(d -> {
            if (d.getDateLecture() != null) {
                d.setDateLecture(DateUtil.convertFromDateToTimestamp(d.getDateLecture()));
            }
        });
        return notifDevoirs;
    }

    public void creer(Devoir d) {
        List<NoteDevoir> noteDevoirs = noteDevoirService.creerNote(d);
        for (NoteDevoir noteDevoir : noteDevoirs) {
            NotifDevoir notifDevoir = new NotifDevoir();
            notifDevoir.setNotedevoir(noteDevoir);
            create(notifDevoir);
        }
    }

    public void suppByDevoir(Devoir d) {
        List<NotifDevoir> notifDevoirs = getEntityManager().createQuery("SELECT n FROM NotifDevoir n WHERE n.notedevoir.devoir.id=" + d.getId()).getResultList();
        for (NotifDevoir notifDevoir : notifDevoirs) {
            remove(notifDevoir);
        }
        noteDevoirService.suppByDevoir(d);
    }

    public List<NotifDevoir> findByDevoir(Long id) {
        List<NotifDevoir> notifDevoirs = getEntityManager().createQuery("SELECT n FROM NotifDevoir n WHERE n.notedevoir.devoir.id=" + id).getResultList();
        notifDevoirs.stream().forEach(d -> {
            if (d.getDateLecture() != null) {
                d.setDateLecture(DateUtil.convertFromDateToTimestamp(d.getDateLecture()));
            }
        });
        return notifDevoirs;
    }
}
