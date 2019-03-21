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
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
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
        notifEvents = notifEventService.findByEvent(e.getId());
        eventNotifFxHelper = new EventNotifFxHelper(tab, notifEvents);
        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void Retour(ActionEvent event) {
         ((Stage) retour.getScene().getWindow()).close();
        
          try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EventView.fxml"));
                javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
                Stage nextStage = new Stage();
                nextStage.setScene(new Scene(root1));
                nextStage.show();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
