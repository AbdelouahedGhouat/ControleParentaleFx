/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdou
 */
public class MenuViewController implements Initializable {

    @FXML
    private Button etudiant;
    @FXML
    private Button event;
    @FXML
    private Button parent;
    @FXML
    private Button typeEvent;
    @FXML
    private Button devoir;
    @FXML
    private Button noteDevoir;
    @FXML
    private Button ecole;
    @FXML
    private Button matiere;
    @FXML
    private Button retour;
    @FXML
    private Button classe;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void Etudiant(ActionEvent event) {
        ((Stage) etudiant.getScene().getWindow()).close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EtudiantView.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Event(ActionEvent event) {
        ((Stage) etudiant.getScene().getWindow()).close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EventView.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void parent(ActionEvent event) {
        ((Stage) parent.getScene().getWindow()).close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ParentView.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void TypeEvent(ActionEvent event) {
        ((Stage) etudiant.getScene().getWindow()).close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TypeEventView.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Devoir(ActionEvent event) {
        ((Stage) etudiant.getScene().getWindow()).close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("DevoirView.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void NoteDevoir(ActionEvent event) {
        ((Stage) etudiant.getScene().getWindow()).close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NoteDevoirView.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Ecole(ActionEvent event) {
        ((Stage) etudiant.getScene().getWindow()).close();

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("EcolePrive.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Matiere(ActionEvent event) {
        ((Stage) etudiant.getScene().getWindow()).close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MatiereView.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Classe(ActionEvent event) {
         ((Stage) etudiant.getScene().getWindow()).close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ClassView.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Retour(ActionEvent event) {
       ((Stage) retour.getScene().getWindow()).close();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viewGlobale/Globale.fxml"));
            javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
            Stage nextStage = new Stage();
            nextStage.setScene(new Scene(root1));
            nextStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
