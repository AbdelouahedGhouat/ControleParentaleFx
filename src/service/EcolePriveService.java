/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.EcolePrive;
import java.util.List;

/**
 *
 * @author abdou
 */
public class EcolePriveService extends AbstractFacade<EcolePrive> {

    public EcolePriveService() {
        super(EcolePrive.class);
    }

    public int creerEcole(String ecole) {
        List<EcolePrive> ecolePrives = getEntityManager().createQuery("SELECT ep FROM EcolePrive ep WHERE ep.nom='" + ecole + "'").getResultList();
        if (ecolePrives.isEmpty()) {
            EcolePrive ecolePrive = new EcolePrive(ecole);
            create(ecolePrive);
            return 1;
        } else {
            return -1;
        }

    }
    

}
