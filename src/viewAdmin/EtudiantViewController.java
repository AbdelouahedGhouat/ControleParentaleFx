/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Classe;
import bean.EcolePrive;
import bean.Etudiant;
import helperfx.EtudiantFxHelper;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import service.ClasseService;
import service.EcolePriveService;
import service.EtudiantService;
import service.ParentService;


/**
 * FXML Controller class
 *
 * @author abdou
 */
public class EtudiantViewController implements Initializable {

    @FXML
    private ComboBox<EcolePrive> ecole;
    @FXML
    private ComboBox<Classe> classe;
    @FXML
    private ComboBox<Parent> parent;
    @FXML
    private TableView<Etudiant> tab;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;

    EtudiantFxHelper etudiantFxHelper;
    List<EcolePrive> ecolePrives;
    List<Classe> classes;
    
    List<Parent> parents ;
    List<Etudiant> etudiants;
    EcolePriveService ecolePriveService = new EcolePriveService();
    ClasseService classeService = new ClasseService();
    ParentService parentService = new ParentService();
    EtudiantService etudiantService = new EtudiantService();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();
        initComboEcole();
        
    }

        public void initHelper() {
        etudiantFxHelper = new EtudiantFxHelper(tab);
    }

    public void initComboEcole() {
         ecole.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            setHelperList(newValue.getId());
        });
        ecolePrives = ecolePriveService.findAll();
        ecole.getItems().addAll(ecolePrives);
    }

    @FXML
    public void initComboClasse() {
         classe.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            setHelperList(newValue.getId());
        });
        classes=classeService.findAll();
        classe.getItems().addAll(classes);
    }

    @FXML
    public void initComboParent() {
         parent.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            setHelperList(new Long(newValue.getId()));
        });
       // parents= parentService.findByCin();
        parent.getItems().addAll(parents);
    }
    
    private void setHelperList(Long parent) {
        etudiants = etudiantService.findByParentClasse(parent, ecole.getSelectionModel().getSelectedItem().getId());
        etudiantFxHelper.setList(etudiants);
        
    }
   

    
    private void setParam(Etudiant selected) {
        nom.setText(selected.getNom());
        prenom.setText(selected.getPrenom());
        ecole.getValue().getNom();//setSelectedItem(selected.getClasse().getEcolePrive().getNom());
        classe.getValue().getEcolePrive().getNom();     //setSelectedItem(selected.getClasse().getNom());
        parent.getValue(); //setSelectedItem(selected.getParent().getNom());
        
       
    }
}
