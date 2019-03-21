/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Classe;
import bean.EcolePrive;
import bean.Etudiant;
import bean.Parent;
import helperfx.EtudiantFxHelper;
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

    List<Parent> parents;
    List<Etudiant> etudiants;
    EcolePriveService ecolePriveService = new EcolePriveService();
    ClasseService classeService = new ClasseService();
    ParentService parentService = new ParentService();
    EtudiantService etudiantService = new EtudiantService();
    @FXML
    private Button retour;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();
        initComboEcole();
        initComboParent();

    }

    public void initHelper() {
        etudiantFxHelper = new EtudiantFxHelper(tab);
        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void initComboEcole() {
        ecole.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            initComboClasse(newValue);
        });
        ecolePrives = ecolePriveService.findAll();
        ecole.getItems().addAll(ecolePrives);
    }

    public void initComboClasse(EcolePrive e) {
        classe.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            setHelperList(newValue.getId());
        });
        classes = classeService.findByEcole(e.getId());
        classe.getItems().clear();
        classe.getItems().addAll(classes);
    }

    public void initComboParent() {
        parents = parentService.findAll();
        parent.getItems().addAll(parents);
    }

    private void setHelperList(Long parent) {
        etudiants = etudiantService.findByParentClasse(parent, ecole.getSelectionModel().getSelectedItem().getId());
        etudiantFxHelper.setList(etudiants);

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

    private void setParam(Etudiant e) {
        nom.setText(etudiantFxHelper.getSelected().getNom());
        prenom.setText(etudiantFxHelper.getSelected().getPrenom());
        ecole.getValue().getNom();
        classe.getValue().getEcolePrive().getNom();
        parent.getValue();
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        if (!nom.getText().isEmpty() && !prenom.getText().isEmpty()) {
            Etudiant e = new Etudiant(nom.getText(), prenom.getText(), classe.getSelectionModel().getSelectedItem(), parent.getSelectionModel().getSelectedItem());
            int res = etudiantService.creerEtudiant(e.getId(), e.getNom(), e.getPrenom(), e.getClasse(), e.getParent());
            if (res == 1) {
                // etudiantFxHelper.setList(etudiantService.findAll());
                setHelperList(parent.getSelectionModel().getSelectedItem().getId());
                JOptionPane.showMessageDialog(null, "ETUDIANT AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
        if (!nom.getText().isEmpty() && !prenom.getText().isEmpty()) {
            Etudiant e = etudiantFxHelper.getSelected();
            e.setNom(nom.getText());
            e.setPrenom(prenom.getText());
            e.setClasse(classe.getSelectionModel().getSelectedItem());
            e.setParent(parent.getSelectionModel().getSelectedItem());
            etudiantService.edit(e);
            etudiantFxHelper.setList(etudiantService.findByParentClasse(e.getParent().getId(), e.getClasse().getEcolePrive().getId()));
            JOptionPane.showMessageDialog(null, " ETUDIANT MODIFIER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        Etudiant e = etudiantFxHelper.getSelected();
        etudiantService.remove(e);
        JOptionPane.showMessageDialog(null, " ETUDIANT EST SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    private void click(MouseEvent event) {
        setParam(tab.getSelectionModel().getSelectedItem());
    }
}
