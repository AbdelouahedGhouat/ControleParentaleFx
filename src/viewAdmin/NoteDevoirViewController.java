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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
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
    private ComboBox<Classe> classe;
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

    NoteDevoirFxHelper noteDevoirFxHelper;
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
            initComboEtudiant(c);
            initComboDevoir(newValue);
        });
        matieres = matiereService.findByClasse(c.getId());
        matiere.getItems().clear();
        matiere.getItems().addAll(matieres);
    }

    private void initComboDevoir(Matiere m) {
        devoir.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            //initComboEtudiant(m.getClasse());
            setHelperList(newValue);
        });
        devoirs = devoirService.findByMatiere(m.getId());
        devoir.getItems().clear();
        devoir.getItems().addAll(devoirs);

    }

    private void initComboEtudiant(Classe c) {

        etudiants = etudiantService.findByClasse(c);
        etudiant.getItems().clear();
        etudiant.getItems().addAll(etudiants);

    }

    public void initHelper() {
        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        noteDevoirFxHelper = new NoteDevoirFxHelper(tab);
        
    }

    private void setHelperList(Devoir devoir) {
        noteDevoirFxHelper.setList(noteDevoirService.findByDevoir(devoir));
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

    @FXML
    private void Ajouter(ActionEvent event) {
        if (!note.getText().isEmpty()) {
            NoteDevoir n = new NoteDevoir(new Double(note.getText()), devoir.getSelectionModel().getSelectedItem(), etudiant.getSelectionModel().getSelectedItem());
            noteDevoirService.updateNote(n.getDevoir(), n.getEtudient(), new Double(note.getText()));
            noteDevoirFxHelper.setList(noteDevoirService.findByDevoir(n.getDevoir()));
            JOptionPane.showMessageDialog(null, "NOTE AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    @FXML
    private void Modifier(ActionEvent event) {
        if (!note.getText().isEmpty()) {
            NoteDevoir n = noteDevoirFxHelper.getSelected();
            noteDevoirService.updateNote(n.getDevoir(), n.getEtudient(), new Double(note.getText()));
            NoteDevoir noteDevoir = (NoteDevoir) tab.getSelectionModel().getSelectedItem();
             noteDevoirService.edit(n);
             //noteDevoirFxHelper.setList(noteDevoirService.findByDevoir(n.getDevoir()));
             tab.getItems().set(tab.getSelectionModel().getSelectedIndex(), noteDevoir);
            JOptionPane.showMessageDialog(null, "NOTE MODIFIER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
           
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        NoteDevoir n =  noteDevoirFxHelper.getSelected();
        noteDevoirService.suppByDevoir(n.getDevoir());
        note.setText("");
        setHelperList(n.getDevoir());
       // noteDevoirFxHelper.setList(noteDevoirService.findByDevoir(n.getDevoir()));
        JOptionPane.showMessageDialog(null, " NOTE DEVOIR EST SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    private void click(MouseEvent event) {
        note.setText(noteDevoirFxHelper.getSelected().getNote() + "");
    }
}
