/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Devoir;
import bean.NotifDevoir;
import helperfx.DevoirNotifFxHelper;
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
import service.NotifDevoirService;
import util.Session;

/**
 *
 * @author abdou
 */
public class DevoirNotifViewController implements Initializable {

    @FXML
    private TableView<NotifDevoir> tab;
    @FXML
    private Button retour;

    Devoir d = (Devoir) Session.getAttribut("devoir");
    NotifDevoirService notifDevoirService = new NotifDevoirService();
    List<NotifDevoir> notifDevoirs;
    DevoirNotifFxHelper devoirNotifFxHelper;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();
    }

    public void initHelper() {
        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        notifDevoirs = notifDevoirService.findByDevoir(d.getId());
        devoirNotifFxHelper = new DevoirNotifFxHelper(tab, notifDevoirs);
    }

    @FXML
    private void Retour(ActionEvent event) {
     ((Stage) retour.getScene().getWindow()).close();
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DevoirView.fxml"));
                javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
                Stage nextStage = new Stage();
                nextStage.setScene(new Scene(root1));
                nextStage.show();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
