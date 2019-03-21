/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Classe;
import bean.EcolePrive;
import bean.Matiere;
import helperfx.MatiereFxHelper;
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
import service.MatiereService;

/**
 * FXML Controller class
 *
 * @author abdou
 */
public class MatiereViewController implements Initializable {

    @FXML
    private ComboBox<EcolePrive> ecole;
    @FXML
    private ComboBox<Classe> classe;
    @FXML
    private TextField nom;
    @FXML
    private TableView tab;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button retour;

    List<EcolePrive> ecolePrives;
    EcolePriveService ecolePriveService = new EcolePriveService();
    ClasseService classeService = new ClasseService();
    MatiereService matiereService = new MatiereService();
    List<Classe> classes;
    MatiereFxHelper matiereFxHelper;
    List<Matiere> matieres;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initEcoles();
        initHelper();
    }

    public void initEcoles() {
        ecole.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            initComboClasse(newValue);
        });
        ecolePrives = ecolePriveService.findAll();
        ecole.getItems().addAll(ecolePrives);
    }

    public void initHelper() {
        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        matiereFxHelper = new MatiereFxHelper(tab);

    }

    public void setHelperList(Long id) {
        matieres = matiereService.findByClasse(id);
        matiereFxHelper.setList(matieres);
    }

    public void initComboClasse(EcolePrive e) {
        classe.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            setHelperList(newValue.getId());
        });
        classes = classeService.findByEcole(e.getId());
        classe.getItems().clear();
        classe.getItems().addAll(classes);
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        if (!nom.getText().isEmpty()) {
            Matiere m = new Matiere(nom.getText(), classe.getSelectionModel().getSelectedItem());
            int res = matiereService.creer(m);
            if (res == 1) {
                matiereFxHelper.setList(matiereService.findByClasse(m.getClasse().getId()));
                JOptionPane.showMessageDialog(null, "MATIERE AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "MATIERE EXISTE DEJA ", "info", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    @FXML
    private void Modifer(ActionEvent event) {
        if (!nom.getText().isEmpty()) {
            Matiere m = matiereFxHelper.getSelected();
            m.setNom(nom.getText());
            matiereService.edit(m);
            JOptionPane.showMessageDialog(null, " MATIERE MODIFIER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
            matiereFxHelper.setList(matiereService.findByClasse(m.getClasse().getId()));

        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        if (!nom.getText().isEmpty()) {
            Matiere m = matiereFxHelper.getSelected();
            matiereService.remove(m);
            nom.setText("");
            matiereFxHelper.setList(matiereService.findByClasse(m.getClasse().getId()));
            JOptionPane.showMessageDialog(null, " MATIERE EST SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    private void click(MouseEvent event) {
        nom.setText(matiereFxHelper.getSelected().getNom());
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
