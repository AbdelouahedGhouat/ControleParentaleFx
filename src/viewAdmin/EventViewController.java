/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Classe;
import bean.Devoir;
import bean.EcolePrive;
import bean.Evenement;
import bean.TypeEvent;
import helperfx.EventFxHelper;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.ClasseService;
import service.EcolePriveService;
import service.EventService;
import service.TypeEventService;
import util.DateUtil;
import util.Session;

/**
 * FXML Controller class
 *
 * @author abdou
 */
public class EventViewController implements Initializable {

    @FXML
    private ComboBox<EcolePrive> ecole;
    @FXML
    private ComboBox<Classe> classe;
    @FXML
    private ComboBox<TypeEvent> type;
    @FXML
    private TableView<Evenement> tab;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button info;
    @FXML
    private TextField nom;
    @FXML
    private TextArea desc;
    @FXML
    private Button retour;
    @FXML
    private DatePicker date;
    EventFxHelper eventFxHelper;
    List<Evenement> events;
    List<EcolePrive> ecolePrives;
    List<TypeEvent> typeEvents;
    List<Classe> classes;
    EventService eventService = new EventService();
    EcolePriveService ecolePriveService = new EcolePriveService();
    ClasseService classeService = new ClasseService();
    TypeEventService typeEventService = new TypeEventService();
    @FXML
    private ComboBox<String> time;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initEcoles();
        initHelper();
        initTime();
        initComboTypeEvent();
        initSelected();
    }

    private void initHelper() {
        eventFxHelper = new EventFxHelper(tab);
        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void initSelected() {
        Evenement e = (Evenement) Session.getAttribut("event");
        if (e != null) {
            remplireCases(e);
            setHelperList(e.getClasse().getId());
        }
    }

    public void initEcoles() {
        ecole.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            initComboClasse(newValue);
        });
        ecolePrives = ecolePriveService.findAll();
        ecole.getItems().addAll(ecolePrives);
    }

    public void setHelperList(Long id) {
        events = eventService.findByClasse(id);
        eventFxHelper.setList(events);
    }

    public void initComboClasse(EcolePrive e) {
        classe.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            setHelperList(newValue.getId());
        });
        classes = classeService.findByEcole(e.getId());
        classe.getItems().clear();
        classe.getItems().addAll(classes);
    }

    public void initComboTypeEvent() {
        typeEvents = typeEventService.findAll();
        type.getItems().addAll(typeEvents);
    }

    public void initTime() {
        List<String> times = new ArrayList(Arrays.asList("08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00"));
        time.getItems().addAll(times);
    }

    public void remplireCases(Evenement e) {
        ecole.getSelectionModel().select(e.getClasse().getEcolePrive());
        classe.getSelectionModel().select(e.getClasse());
        type.getSelectionModel().select(e.getTypeEvent());
        nom.setText(e.getNom());
        desc.setText(e.getDescription());
        date.setValue(convertToLocalDate(e.getDate()));
    }

    @FXML
    private void change(ActionEvent event) throws IOException {
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
    private void Ajouter(ActionEvent event) {
        if (date.getValue() != null && !nom.getText().isEmpty()) {
            Date d = convertToDate(date.getValue());
            String t = time.getSelectionModel().getSelectedItem();
            d.setHours(Integer.valueOf(t.substring(0, 2)));
            d.setMinutes(Integer.valueOf(t.substring(3)));
            Evenement e = new Evenement(nom.getText(), DateUtil.getSqlDateTime(d), classe.getSelectionModel().getSelectedItem());
            int res = eventService.creerEvent(nom.getText(), DateUtil.getSqlDateTime(d), classe.getSelectionModel().getSelectedItem(), desc.getText(), type.getSelectionModel().getSelectedItem());
            if (res == 1) {
                tab.getItems().set(tab.getSelectionModel().getSelectedIndex(), e);
                JOptionPane.showMessageDialog(null, "EVENEMENT AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "EVENEMENT EXIST DEJA ", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @FXML
    private void Modifier(ActionEvent event) {
        if (date.getValue() != null) {
            Date d = convertToDate(date.getValue());
            String t = time.getSelectionModel().getSelectedItem();
            d.setHours(Integer.valueOf(t.substring(0, 2)));
            d.setMinutes(Integer.valueOf(t.substring(3)));
            Evenement evenement = tab.getSelectionModel().getSelectedItem();
            evenement.setNom(nom.getText());
            evenement.setDescription(desc.getText());
            evenement.setDate(d);
            eventService.edit(evenement);
            evenement.setDate(DateUtil.convertFromDateToTimestamp(evenement.getDate()));
            JOptionPane.showMessageDialog(null, " EVENEMENT EST MODIFIER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
            tab.getItems().set(tab.getSelectionModel().getSelectedIndex(), evenement);
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        Evenement e = eventFxHelper.getSelected();
        eventService.supprimer(e);
        date.setValue(null);
        setHelperList(e.getClasse().getId());
        JOptionPane.showMessageDialog(null, " EVENEMENT EST SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
        nom.setText("");
        desc.setText("");
    }

    @FXML
    private void Info(ActionEvent event) {
        Evenement ev = eventFxHelper.getSelected();
        ((Stage) info.getScene().getWindow()).close();
        if (ev != null) {
            Session.updateAttribute(ev, "event");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EventNotifView.fxml"));
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
    private void click(MouseEvent event) {
        remplireCases(tab.getSelectionModel().getSelectedItem());
    }

}
