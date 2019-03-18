/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewParent;

import bean.NotifDevoir;
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
import service.NotifDevoirService;
import util.DateUtil;
import util.Session;

/**
 *
 * @author abdou
 */
public class NotifDevoirParentController implements Initializable {

    @FXML
    private Button valider;
    @FXML
    private Label etudiant;
    @FXML
    private Label classe;
    @FXML
    private Label ecole;
    @FXML
    private Label matiere;
    @FXML
    private Label dateD;
    @FXML
    private Label note;
    @FXML
    private TextArea Jarea;

    NotifDevoirService notifDevoirService = new NotifDevoirService();

    public void initInfo() {
        NotifDevoir notifDevoir = (NotifDevoir) Session.getAttribut("notifDevoir");
        if (notifDevoir != null) {
            etudiant.setText(notifDevoir.getNotedevoir().getEtudient().getNom() + " " + notifDevoir.getNotedevoir().getEtudient().getPrenom());
            classe.setText(notifDevoir.getNotedevoir().getDevoir().getMatiere().getClasse().getNom());
            ecole.setText(notifDevoir.getNotedevoir().getDevoir().getMatiere().getClasse().getEcolePrive().getNom());
            matiere.setText(notifDevoir.getNotedevoir().getDevoir().getMatiere().getNom());
            dateD.setText(DateUtil.formateDate("YYYY-MM-dd HH:mm", notifDevoir.getNotedevoir().getDevoir().getDate()));
            note.setText(notifDevoir.getNotedevoir().getNote() + "");
            Jarea.setText(notifDevoir.getDescription());

        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        initInfo();
    }

    @FXML
    private void Valider(ActionEvent event) {
        NotifDevoir notifDevoir = (NotifDevoir) Session.getAttribut("notifDevoir");
        notifDevoir.setDescription(Jarea.getText());
        notifDevoirService.edit(notifDevoir);
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
