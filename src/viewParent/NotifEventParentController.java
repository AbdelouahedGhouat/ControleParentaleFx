/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewParent;

import bean.NotifEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import service.NotifEventService;
import util.DateUtil;
import util.Session;

/**
 *
 * @author abdou
 */
public class NotifEventParentController implements Initializable {

    @FXML
    private Button valider;
    @FXML
    private Label etudiant;
    @FXML
    private Label classe;
    @FXML
    private Label ecole;
    @FXML
    private Label nomE;
    @FXML
    private Label dateE;
    @FXML
    private Label type;
    @FXML
    private TextArea descEvent;
    @FXML
    private TextArea descParent;

    NotifEventService notifEventService = new NotifEventService();

    public void initInfo() {
       NotifEvent notifEvent = (NotifEvent) Session.getAttribut("notifEvent");
        if (notifEvent != null) {
            etudiant.setText(notifEvent.getEtudiant().getNom() + " " + notifEvent.getEtudiant().getPrenom());
            classe.setText(notifEvent.getEvenement().getClasse().getNom());
            ecole.setText(notifEvent.getEvenement().getClasse().getEcolePrive().getNom());
            nomE.setText(notifEvent.getEvenement().getNom());
            dateE.setText(DateUtil.formateDate("YYYY-MM-dd HH:mm", notifEvent.getEvenement().getDate()));
            type.setText(notifEvent.getEvenement().getTypeEvent().getType()+ "");
            descParent.setText(notifEvent.getDescription());
            descEvent.setText(notifEvent.getEvenement().getDescription());
            
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        initInfo();
    }

    @FXML
    private void Valider(ActionEvent event) {
        NotifEvent notifEvent = (NotifEvent) Session.getAttribut("notifEvent");
        notifEvent.setDescription(descParent.getText());
        notifEventService.edit(notifEvent);
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AcceuillParentView.fxml"));
                javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
                Stage nextStage = new Stage();
                nextStage.setScene(new Scene(root1));
                nextStage.show();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
