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

        
    List<EcolePrive> ecolePrives;
    EcolePriveService ecolePriveService = new EcolePriveService();
    DevoirService devoirService = new DevoirService();
    List<Classe> classes;
    DevoirFxHelper devoirFxHelper;
    List<Matiere> matieres;
    ClasseService classeService = new ClasseService();
    MatiereService matiereService = new MatiereService();
    List<Devoir> devoirs;
    EcoleFxHelper ecoleFxHelper;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initSelected();
        initEcoles();
        initHelper();
    }
    
     public void initEcoles() {
         ecole.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            setHelperList(newValue.getId());
        });
        ecolePrives = ecolePriveService.findAll();
        ecole.getItems().addAll(ecolePrives);
    }

    public void initHelper() {
        devoirFxHelper = new DevoirFxHelper(tab);
    }

    public void setHelperList(Long idMatiere) {
        devoirs = devoirService.findByMatiere(idMatiere);
        devoirFxHelper.setList(devoirs);
    }

    public void initComboMatiere() {
        matiere.valueProperty().addListener((ie) -> {
            String item = (String) ie.toString();
            for (Matiere ma : matieres) {
                if (item.equals(ma.getNom())) {
                    setHelperList(ma.getId());
                }
            }
        });
    }

//    public void remplireCases(Devoir d) {
//        ecole.setSelectedItem(d.getMatiere().getClasse().getEcolePrive().getNom());
//        classe.setSelectedItem(d.getMatiere().getClasse().getNom());
//        matiere.setSelectedItem(d.getMatiere().getClasse().getNom());
//        date.setDate(d.getDate());
//
//    }

    
     private void initSelected(){
          Devoir d = (Devoir) Session.getAttribut("devoir");
        if (d!=null) {
           // remplireCases(d);
            setHelperList(d.getId());
        }
    }

    @FXML
    private void click(MouseEvent event) {
         EcolePrive e = ecoleFxHelper.getSelected();
        classes = classeService.findByEcole(e.getId());
        classe.getItems().removeAll();
        for (Classe c : classes) {
         //   classe.add(c.getNom());
        }
    }

    @FXML
    private void Ajouter(ActionEvent event) {
//         if (date.getDate() != null) {
//            Date d = date.getDate();
//            date = DateUtil.convertFromDateToTimestamp(d);
//            Devoir d = new Devoir(date, matieres.get(matiere.getSelectedIndex()));
//            int res = devoirService.creerDevoir(date, d.getMatiere());
//            if (res == 1) {
//                setHelperList(matieres.get(matiere.getSelectedIndex()).getId());
//                JOptionPane.showMessageDialog(null, "DEVOIR AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
//            } else {
//                JOptionPane.showMessageDialog(null, "DEVOIR EXIST DEJA ", "ERROR", JOptionPane.ERROR_MESSAGE);
//            }
//        }
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
        
            Devoir d = devoirFxHelper.getSelected();
            devoirService.supprimer(d);
//            date.setDate(null);
//            setHelperList(matieres.get(matiere.getSelectedIndex()).getId());
            JOptionPane.showMessageDialog(null, " DEVOIR EST SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    private void Info(ActionEvent event) {
    }
    

}
