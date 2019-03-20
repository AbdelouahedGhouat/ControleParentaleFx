/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Classe;
import bean.Devoir;
import bean.EcolePrive;
import bean.Matiere;
import helperfx.DevoirFxHelper;
import helperfx.EcoleFxHelper;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ClasseService;
import service.DevoirService;
import service.EcolePriveService;
import service.MatiereService;
import util.DateUtil;
import util.Session;

/**
 * FXML Controller class
 *
 * @author abdou
 */
public class DevoirViewController implements Initializable {

    @FXML
    private ComboBox<EcolePrive> ecole;
    @FXML
    private ComboBox<Classe> classe;
    @FXML
    private TableView<Devoir> tab;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private ComboBox<Matiere> matiere;
    @FXML
    private DatePicker date;
    @FXML
    private Button info;
    @FXML
    private Button retour;
    @FXML
    private ComboBox<String> time;

    List<EcolePrive> ecolePrives;
    EcolePriveService ecolePriveService = new EcolePriveService();
    DevoirService devoirService = new DevoirService();
    List<Classe> classes;
    DevoirFxHelper devoirFxHelper;
    List<Matiere> matieres;
    ClasseService classeService = new ClasseService();
    MatiereService matiereService = new MatiereService();
    List<Devoir> devoirs;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initEcoles();
        initHelper();
        initTime();
    }

    public void initTime() {
        List<String> times = new ArrayList(Arrays.asList("08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00"));
        time.getItems().addAll(times);
    }

    public void initEcoles() {
        ecole.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            initClasse(newValue);
        });
        ecolePrives = ecolePriveService.findAll();
        ecole.getItems().addAll(ecolePrives);

    }

    public void initClasse(EcolePrive e) {
        classe.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            initComboMatiere(newValue);
        });
        classes = classeService.findByEcole(e.getId());
        classe.getItems().clear();
        classe.getItems().addAll(classes);
    }

    public void initComboMatiere(Classe c) {
        matiere.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            setHelperList(newValue.getId());
        });
        matieres = matiereService.findByClasse(c.getId());
        matiere.getItems().clear();
        matiere.getItems().addAll(matieres);
    }

    public void initHelper() {
        devoirFxHelper = new DevoirFxHelper(tab);
        //tab.getColumns().get(0).setMinWidth(140);
    }

    public void setHelperList(Long idMatiere) {
        devoirs = devoirService.findByMatiere(idMatiere);
        devoirFxHelper.setList(devoirs);
    }

    public void remplireCases(Devoir d) {
        ecole.getSelectionModel().select(d.getMatiere().getClasse().getEcolePrive());
        classe.getSelectionModel().select(d.getMatiere().getClasse());
        matiere.getSelectionModel().select(d.getMatiere());
        date.setValue(convertToLocalDate(d.getDate()));
    }

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public Date convertToDate(LocalDate dateToConvert) {
        return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()
        );
    }

    @FXML
    private void click(MouseEvent event) {
        remplireCases(tab.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        if (date.getValue() != null) {
            Date d = convertToDate(date.getValue());
            String t = time.getSelectionModel().getSelectedItem();
            d.setHours(Integer.valueOf(t.substring(0, 2)));
            d.setMinutes(Integer.valueOf(t.substring(3)));
            int res = devoirService.creerDevoir(DateUtil.getSqlDateTime(d), matiere.getSelectionModel().getSelectedItem());
            if (res == 1) {
                setHelperList(matiere.getSelectionModel().getSelectedItem().getId());
                JOptionPane.showMessageDialog(null, "EVENEMENT AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "  EXIST DEJA ", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "S'il vous plaît! selectionner une date ", "info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    private void Modifier(ActionEvent event) {
        if (date.getValue() != null) {
            Date d = convertToDate(date.getValue());
            String t = time.getSelectionModel().getSelectedItem();
            d.setHours(Integer.valueOf(t.substring(0, 2)));
            d.setMinutes(Integer.valueOf(t.substring(3)));
            Devoir devoir = tab.getSelectionModel().getSelectedItem();
            devoir.setDate(d);
            devoirService.edit(devoir);
            devoir.setDate(DateUtil.convertFromDateToTimestamp(devoir.getDate()));
            JOptionPane.showMessageDialog(null, "DEVOIR MODIFIER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
            tab.getItems().set(tab.getSelectionModel().getSelectedIndex(), devoir);
        } else {
            JOptionPane.showMessageDialog(null, "S'il vous plaît! selectionner une date ", "info", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    @FXML
    private void Supprimer(ActionEvent event) {

        Devoir d = devoirFxHelper.getSelected();
        devoirService.supprimer(d);
        date.setValue(null);
        setHelperList(d.getMatiere().getId());
        JOptionPane.showMessageDialog(null, " DEVOIR EST SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    private void Info(ActionEvent event) {
        Devoir d = devoirFxHelper.getSelected();
        ((Stage) info.getScene().getWindow()).close();
        if (d != null) {
            Session.updateAttribute(d, "devoir");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DevoirNotifView.fxml"));
                javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
                Stage nextStage = new Stage();
                nextStage.setScene(new Scene(root1));
                nextStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void Retour(ActionEvent event) {
        ((Stage) retour.getScene().getWindow()).close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MenuView.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
