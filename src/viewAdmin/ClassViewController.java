/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Classe;
import bean.EcolePrive;
import helperfx.ClasseFxHelper;
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

/**
 * FXML Controller class
 *
 * @author abdou
 */
public class ClassViewController implements Initializable {

    @FXML
    private ComboBox<EcolePrive> ecole;
    @FXML
    private TextField nom;
    @FXML
    private Button ajouter;
    @FXML
    private TableView tab;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    /**
     * Initializes the controller class.
     */
    List<EcolePrive> ecolePrives;
    EcolePriveService ecolePriveService = new EcolePriveService();
    ClasseService classeService = new ClasseService();
    ClasseFxHelper classeFxHelper;
    List<Classe> classes;
    @FXML
    private Button retour;
    


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         initHelper();
         initComboBox1();
        
    }    

    @FXML
    private void ajouter(ActionEvent event) {
         if (!nom.getText().isEmpty()) {
            int res = classeService.creerClasse(nom.getText(), ecole.getSelectionModel().getSelectedItem());
            if (res == 1) {
                classeFxHelper.setList(classeService.findByEcole(ecole.getSelectionModel().getSelectedItem().getId()));
                JOptionPane.showMessageDialog(null, "CLASSE AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "CLASSE EXISTE DEJA  ", "ERROE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
         if (!nom.getText().isEmpty()) {
            Classe c = classeFxHelper.getSelected();
            int res = classeService.modifierClasse(c, nom.getText());
            if (res == 1) {
                classeFxHelper.setList(classeService.findByEcole(ecole.getSelectionModel().getSelectedItem().getId()));
                JOptionPane.showMessageDialog(null, "CLASSE MODIFIER AVEC SUCCES", "info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "CLASSE EXISTE DEJA  ", "ERROE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
         Classe c = classeFxHelper.getSelected();
        classeService.remove(c);
        classeFxHelper.setList(classeService.findByEcole(ecole.getSelectionModel().getSelectedItem().getId()));
        nom.setText("");
        JOptionPane.showMessageDialog(null, "CLASSE SUPPRIMER AVEC SUCCES", "info", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    private void setParam(MouseEvent event) {
         nom.setText(classeFxHelper.getSelected().getNom());
    }
    
  

    private void initHelper() {
        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        classeFxHelper = new ClasseFxHelper(tab);

    }

    private void setHelperList(Long ecole) {
        classes = classeService.findByEcole(ecole);
        classeFxHelper.setList(classes);

    }

    public void initComboBox1() {
        ecole.getSelectionModel().selectedItemProperty().addListener( (options, oldValue, newValue) -> {
            setHelperList(newValue.getId());
        });
        ecolePrives = ecolePriveService.findAll();
        ecole.getItems().addAll(ecolePrives);
        
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
