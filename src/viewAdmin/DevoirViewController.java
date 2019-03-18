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
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
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
    private ComboBox<String> ecole;
    @FXML
    private ComboBox<String> classe;
    @FXML
    private TableView<Devoir> tab;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;

    @FXML
    private ComboBox<String> matiere;
    @FXML
    private DatePicker date;
    @FXML
    private Button info;

    List<EcolePrive> ecolePrives;
    EcolePriveService ecolePriveService = new EcolePriveService();
    DevoirService devoirService = new DevoirService();
    List<Classe> classes;
    DevoirFxHelper devoirFxHelper;
    List<Matiere> matieres;
    ClasseService classeService = new ClasseService();
    MatiereService matiereService = new MatiereService();
    List<Devoir> devoirs;

    ObservableList<String> listEcole = FXCollections.observableArrayList();
    ObservableList<String> listClasse = FXCollections.observableArrayList();
    ObservableList<String> listMatiere = FXCollections.observableArrayList();
    @FXML
    private Button retour;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initEcoles();

    }

    public void initEcoles() {
//         ecole.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
//            setHelperList(newValue.getId());
//        });
//        ecolePrives = ecolePriveService.findAll();
//        ecole.getItems().addAll(ecolePrives);

        listEcole.add("EL Bachir");
        listEcole.add("AL Manal");
        ecole.setItems(listEcole);
    }

    @FXML
    public void initClasse() {
        if (ecole.getValue().equals("EL Bachir")) {
            listClasse.clear();
            listClasse.add("CP");
            listClasse.add("CE1");
            listClasse.add("CE2");
        } else if (ecole.getValue().equals("AL Manal")) {
            listClasse.clear();
            listClasse.add("CE1");
            listClasse.add("CE2");
            listClasse.add("CP");
        } else {
            listClasse.clear();

        }
        classe.setItems(listClasse);
    }

    @FXML
    public void initComboMatiere() {

        if (classe.getValue().equals("CP") &&ecole.getValue().equals("EL Bachir")) {
            listMatiere.clear();
            listMatiere.add("Math");
            listMatiere.add("Physique");
            listMatiere.add("Info");
        } else if (classe.getValue().equals("CE1") && ecole.getValue().equals("AL Manal")) {
            listMatiere.clear();
            listMatiere.add("Info");
            listMatiere.add("Math");
        } else {
            listMatiere.clear();

        }
           matiere.setItems(listMatiere);
    }

    public void initHelper() {
        devoirFxHelper = new DevoirFxHelper(tab);
    }

    public void setHelperList(Long idMatiere) {
        devoirs = devoirService.findByMatiere(idMatiere);
        devoirFxHelper.setList(devoirs);
    }

//    public void remplireCases(Devoir d) {
//        ecole.setSelectedItem(d.getMatiere().getClasse().getEcolePrive().getNom());
//        classe.setSelectedItem(d.getMatiere().getClasse().getNom());
//        matiere.setSelectedItem(d.getMatiere().getClasse().getNom());
//        jdate.setDate(d.getDate());
//
//    }
    @FXML
    private void click(MouseEvent event) {

    }

    @FXML
    private void Ajouter(ActionEvent event) {
//         if (date.getDate() != null) {
//            Date d = date.getDate();
//            date = DateUtil.convertFromDateToTimestamp(d);
//            Devoir d = new Devoir(date, matieres.get(matiere.getSelectedIndex()));
           // int res = devoirService.creerDevoir(date, d.getMatiere());
            //if (res == 1) {
            //    setHelperList(matieres.get(matiere.getSelectedIndex()).getId());
//                JOptionPane.showMessageDialog(null, "DEVOIR AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "DEVOIR EXIST DEJA ", "ERROR", JOptionPane.ERROR_MESSAGE);
//            }
//        
    }

    @FXML
    private void Modifier(ActionEvent event) {
//         Devoir m = devoirFxHelper.getSelected();
//        Date d = date.getDate();
//        
//       // date = DateUtil.convertFromDateToTimestamp(date);
//        m.setDate(date);
//        devoirService.edit(m);
//        setHelperList(matieres.get(matiere.getSelectedIndex()).getId());
//       
    }

    @FXML
    private void Supprimer(ActionEvent event) {

//            Devoir d = devoirFxHelper.getSelected();
//            devoirService.supprimer(d);
////            date.setDate(null);
////            setHelperList(matieres.get(matiere.getSelectedIndex()).getId());
//            JOptionPane.showMessageDialog(null, " DEVOIR EST SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    private void Info(ActionEvent event) {
//        Devoir d = devoirFxHelper.getSelected();
//        if(d!=null){
//        Session.updateAttribute(d, "devoir");    
        //  }
    }

    @FXML
    private void Retour(ActionEvent event) {
    }

}
