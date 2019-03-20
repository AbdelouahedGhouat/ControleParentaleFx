/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Devoir;
import bean.Matiere;
import java.util.Date;
import java.util.List;
import util.DateUtil;

/**
 *
 * @author abdou
 */
public class DevoirService extends AbstractFacade<Devoir> {

    NotifDevoirService notifDevoirService = new NotifDevoirService();

    public DevoirService() {
        super(Devoir.class);
    }
    
    public int creerDevoir(Date date, Matiere m) {
        List<Devoir> devoirs = getEntityManager().createQuery("SELECT d FROM Devoir d WHERE d.date='" + date + "' and d.matiere.id=" + m.getId()+ "").getResultList();
        if (devoirs.isEmpty()) {
            Devoir devoir = new Devoir(generateId("Devoir", "id"), date, m);
            create(devoir);
            notifDevoirService.creer(devoir);
            return 1;
        } else {
            return -1;
        }

    }

    public List<Devoir> findByMatiere(Long id) {
        List<Devoir> devoirs = getEntityManager().createQuery("SELECT d FROM Devoir d where d.matiere.id=" + id + " ORDER BY d.date DESC").getResultList();
        devoirs.stream().forEach(d -> { d.setDate(DateUtil.convertFromDateToTimestamp(d.getDate()));});
        return devoirs;
    }

    public void supprimer(Devoir d) {
        notifDevoirService.suppByDevoir(d);
        remove(d);
    }

}
