/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Classe;
import bean.EcolePrive;
import bean.Evenement;
import bean.TypeEvent;
import helperfx.EventFxHelper;
import java.io.IOException;
import java.net.URL;
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
import javafx.stage.Stage;
import service.ClasseService;
import service.EcolePriveService;
import service.EventService;
import service.TypeEventService;
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
    private TableView tab;
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
    
    EventFxHelper eventHelper;
    List<Evenement> events;
    List<EcolePrive> ecolePrives;
    List<TypeEvent> typeEvents;
    List<Classe> classes;
    EventService eventService = new EventService();
    EcolePriveService ecolePriveService = new EcolePriveService();
    ClasseService classeService = new ClasseService();
    TypeEventService typeEventService = new TypeEventService();
    @FXML
    private DatePicker date;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initEcoles();
        initHelper();
        initComboClasse();
        initComboTypeEvent();
        initSelected();
    }
 private void initHelper() {
        eventHelper = new EventFxHelper(tab);

    }
    private void initSelected(){
          Evenement e = (Evenement) Session.getAttribut("event");
        if (e!=null) {
            remplireCases(e);
            setHelperList(e.getClasse().getId());
        }
    }

    public void initEcoles() {
        ecolePrives = ecolePriveService.findAll();
        for (EcolePrive e : ecolePrives) {
            //ecole.addItem(e.getNom());
        }
    }
    
     public void setHelperList(Long id) {
        events = eventService.findByClasse(id);
        eventHelper.setList(events);
    }

    public void initComboClasse() {
//        classe.addItemListener((ie) -> {
//            String item = (String) ie.getItem();
//            for (Classe c : classes) {
//                if (item.equals(c.getNom())) {
//                    setHelperList(c.getId());
//                }
//            }
//        });
    }

    public void initComboTypeEvent() {
        typeEvents = typeEventService.findAll();
        for (TypeEvent typeEvent : typeEvents) {
          //  type.addItem(typeEvent.getType());

        }
    }

    public void remplireCases(Evenement e) {
        //ecole.setSelectedItem(e.getClasse().getEcolePrive().getNom());
        //classe.setSelectedItem(e.getClasse().getNom());
        //type.setSelectedItem(e.getTypeEvent());
        //nom.setText(e.getNom());
        //desc.setText(e.getDescription());
        //dates.setDate(e.getDate());

    }
    @FXML
    private void change(ActionEvent event) throws IOException {
       
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("MenuView.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.show();
    }

  
    
   
    
}
