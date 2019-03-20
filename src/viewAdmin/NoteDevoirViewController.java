/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Classe;
import bean.Devoir;
import bean.EcolePrive;
import bean.Etudiant;
import bean.Matiere;
import bean.NoteDevoir;
import helperfx.NoteDevoirFxHelper;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.ClasseService;
import service.DevoirService;
import service.EcolePriveService;
import service.EtudiantService;
import service.MatiereService;
import service.NoteDevoirService;
import util.DateUtil;


/**
 * FXML Controller class
 *
 * @author abdou
 */
public class NoteDevoirViewController implements Initializable {

    @FXML
    private ComboBox<EcolePrive> ecole;
    @FXML
    private ComboBox<Class> classe;
    @FXML
    private ComboBox<Etudiant> etudiant;
    @FXML
    private TableView tab;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TextField note;
    @FXML
    private ComboBox<Matiere> matiere;
    @FXML
    private ComboBox<Devoir> devoir;

     NoteDevoirFxHelper noteDevoirHelper;
    List<EcolePrive> ecolePrives;
    List<Classe> classes;
    List<NoteDevoir> noteDevoirs;
    List<Matiere> matieres;
    List<Devoir> devoirs;
    List<Etudiant> etudiants;
    ClasseService classeService = new ClasseService();
    EcolePriveService ecolePriveService = new EcolePriveService();
    NoteDevoirService noteDevoirService = new NoteDevoirService();
    MatiereService matiereService = new MatiereService();
    DevoirService devoirService = new DevoirService();
    EtudiantService etudiantService = new EtudiantService();
    @FXML
    private Button retour;

    /**
     * Creates new form NoteView
     */
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();
        initEcoles();
    }
    


    

    public void initEcoles() {
        ecolePrives = ecolePriveService.findAll();
        for (EcolePrive e : ecolePrives) {
            //ecole.addItem(e.getNom());
        }
    }

    public void initHelper() {
       // noteDevoirFxHelper = new NoteDevoirFxHelper();
    }

    private void setHelperList(Devoir devoir) {
        noteDevoirHelper.setList(noteDevoirService.findByDevoir(devoir));
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
