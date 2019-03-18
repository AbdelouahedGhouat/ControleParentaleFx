/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Evenement;
import bean.NotifEvent;
import helperfx.EventNotifFxHelper;
import helperfx.NotifEventFxHelper;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import service.NotifEventService;
import util.Session;

/**
 *
 * @author abdou
 */
public class EventNotifViewController implements Initializable {

    @FXML
    private TableView tab;
    @FXML
    private Button retour;

    Evenement e = (Evenement) Session.getAttribut("event");
   NotifEventService notifEventService = new NotifEventService();
    List<NotifEvent> notifEvents;
    EventNotifFxHelper eventNotifFxHelper;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();

    }

    public void initHelper() {
//        notifEvents = notifEventService.findByEvent(e.getId());
//        eventNotifFxHelper = new EventNotifFxHelper(tab, notifEvents);
    }

}
