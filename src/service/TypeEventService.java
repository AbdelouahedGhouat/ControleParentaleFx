/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.TypeEvent;
import java.util.List;

/**
 *
 * @author abdou
 */
public class TypeEventService extends AbstractFacade<TypeEvent> {

    
    public TypeEventService() {
        super(TypeEvent.class);
    }
    
    
    public int creerType(String nomType){
        List<TypeEvent> typeEvents =getEntityManager().createQuery("SELECT t FROM TypeEvent t WHERE t.type='" + nomType + "'").getResultList();
        if (typeEvents.isEmpty()) {
            TypeEvent typeEvent = new TypeEvent(nomType);
            create(typeEvent);
            return 1;
        } else {
            return -1;
        }

    }
}
