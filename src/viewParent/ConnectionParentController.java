/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewParent;

import bean.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import service.ParentService;
import util.Session;

/**
 *
 * @author abdou
 */
public class ConnectionParentController implements Initializable {

    @FXML
    private TextField cin;

    @FXML
    private PasswordField password;

    @FXML
    private Button seConnecter;

    ParentService parentService = new ParentService();

    @FXML
    private void seConnecter(ActionEvent event) {
        Parent p = getParam();
        int i = parentService.connect(p);
        if (i > 0) {
            p = parentService.findByCin(p.getCin());
            Session.updateAttribute(p, "connectedParent");
            AdaptedAlert alert = new AdaptedAlert(AdaptedAlert.AlertType.INFORMATION, null, "Succes", "CONNECTION AVEC SUCCES BIENVENU : " + p.getNom());
            alert.showAndWait();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AcceuillParentView.fxml"));
                javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
                Stage nextStage = new Stage();
                nextStage.setScene(new Scene(root1));
                nextStage.show();
                
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (i == -1) {
            AdaptedAlert alert = new AdaptedAlert(AdaptedAlert.AlertType.WARNING, null, "Succes", "Ce CIN N'EXISTE PAS");
            alert.showAndWait();
        } else {
            AdaptedAlert alert = new AdaptedAlert(AdaptedAlert.AlertType.ERROR, null, "Succes", "Mot de passe INCORRECT");
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public Parent getParam() {
        Parent p = new Parent();
        p.setCin(cin.getText());
        p.setPassword(password.getText());
        return p;
    }

}
