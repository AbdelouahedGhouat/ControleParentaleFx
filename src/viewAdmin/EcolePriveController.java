/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.EcolePrive;
import helperfx.EcoleFxHelper;
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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import service.EcolePriveService;

/**
 * FXML Controller class
 *
 * @author abdou
 */
public class EcolePriveController implements Initializable {

    @FXML
    private TextField nom;
    @FXML
    private TableView<?> tab;

    List<EcolePrive> ecolePrives;
    private EcoleFxHelper ecoleFxHelper;
    private EcolePriveService ecolePriveService = new EcolePriveService();
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initHelper();
    }

    private void initHelper() {
        ecolePrives = ecolePriveService.findAll();
        ecoleFxHelper = new EcoleFxHelper((TableView<EcolePrive>) tab, ecolePrives);
        tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        int res = ecolePriveService.creerEcole(nom.getText());
        if (res == 1) {
            ecoleFxHelper.setList(ecolePriveService.findAll());
            JOptionPane.showMessageDialog(null, "ECOLE AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "ECOLE EXISTE DEJA  ", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void Modifier(ActionEvent event) {
        if (!nom.getText().isEmpty()) {
            EcolePrive ep = ecoleFxHelper.getSelected();
            ep.setNom(nom.getText());
            ecolePriveService.edit(ep);
            JOptionPane.showMessageDialog(null, "ECOLE MODIFIER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
             ecoleFxHelper.setList(ecolePriveService.findAll());
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        EcolePrive ep = ecoleFxHelper.getSelected();
        ecolePriveService.remove(ep);
        ecoleFxHelper.setList(ecolePriveService.findAll());
        nom.setText("");
        JOptionPane.showMessageDialog(null, "ECOLE SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    private void setParam(MouseEvent event) {
        nom.setText(ecoleFxHelper.getSelected().getNom());
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
