/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewParent;

import bean.Etudiant;
import bean.NotifDevoir;
import bean.NotifEvent;
import bean.Parent;
import helperfx.EtudiantFxHelper;
import helperfx.NotifDevoirFxHelper;
import helperfx.NotifEventFxHelper;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import service.EtudiantService;
import service.NotifDevoirService;
import service.NotifEventService;
import util.Session;

/**
 *
 * @author abdou
 */
public class AcceuillParentController implements Initializable {

    @FXML
    private TableView<NotifDevoir> tabD;
    @FXML
    private ComboBox<Etudiant> etudiant;
    @FXML
    private TableView<NotifEvent> tabE;

    EtudiantService etudiantService = new EtudiantService();
    NotifDevoirService notifDevoirService = new NotifDevoirService();
    NotifEventService notifEventService = new NotifEventService();
    NotifDevoirFxHelper notifDevoirFxHelper;
    NotifEventFxHelper notifEventFxHelper;
    EtudiantFxHelper etudiantFxHelper;
    List<Etudiant> etudiants;
    @FXML
    private Button deconnection;
    @FXML
    private Button recherche;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();
        initComboBox1();
    }

    public void initHelper() {
        notifDevoirFxHelper = new NotifDevoirFxHelper(tabD);
        notifEventFxHelper = new NotifEventFxHelper(tabE);
    }

    @FXML
    private void Deconnection(ActionEvent event) {

    }

    @FXML
    private void Recherche(ActionEvent event) {
        setHelperList(etudiant.getSelectionModel().getSelectedItem().getId());
    }

    @FXML
    private void tabDevoirClick(MouseEvent event) {
        NotifDevoir notifDevoir = notifDevoirFxHelper.getSelected();
        if (notifDevoir.getDateLecture() == null) {
            notifDevoir.setDateLecture(new Date());
            notifDevoirService.edit(notifDevoir);
        }
        Session.updateAttribute(notifDevoir, "notifDevoir");

    }

    @FXML
    private void tabEventClick(MouseEvent event) {
        NotifEvent notifEvent = notifEventFxHelper.getSelected();
        if (notifEvent.getDateLecture() == null) {
            notifEvent.setDateLecture(new Date());
            notifEventService.edit(notifEvent);
        }
        Session.updateAttribute(notifEvent, "notifEvent");
//        FXMLLoader notifEventParentView = new FXMLLoader();
//        notifEventParentView.getLocation();

    }

    private void setHelperList(Long etudiant) {
        List<NotifDevoir> notifDevoirs = notifDevoirService.findByEtudiant(etudiant);
        if (!notifDevoirs.isEmpty()) {
            notifDevoirFxHelper.setList(notifDevoirs);
        }

        List<NotifEvent> notifEvens = notifEventService.findByEtdudiant(etudiant);
        if (!notifEvens.isEmpty()) {
            notifEventFxHelper.setList(notifEvens);
        }
    }

    @FXML
    public void initComboBox1() {
        Parent p = (Parent) Session.getAttribut("connectedParent");
//        etudiant.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
//            setHelperList(newValue.getId());
//        });
        etudiants = etudiantService.findByParent(p.getCin());
        etudiant.getItems().clear();
        etudiant.getItems().addAll(etudiants);

    }

}
