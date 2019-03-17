/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.Parent;
import helperfx.ParentFxHelper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import service.EtudiantService;
import service.ParentService;

/**
 * FXML Controller class
 *
 * @author abdou
 */
public class ParentViewController implements Initializable {

    @FXML
    private TableView<Parent> tab;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TextField cin;
    @FXML
    private TextField password;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField tel;
    @FXML
    private Button retour;

    ParentFxHelper parentFxHelper;
    ParentService parentService = new ParentService();
    EtudiantService etudiantService = new EtudiantService();

    public void initHelper() {
        parentFxHelper = new ParentFxHelper(tab, parentService.findAll());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();
    }

    @FXML
    private void setParam(MouseEvent event) {
        cin.setText(parentFxHelper.getSelected().getCin());
        password.setText(parentFxHelper.getSelected().getPassword());
        nom.setText(parentFxHelper.getSelected().getNom());
        prenom.setText(parentFxHelper.getSelected().getPrenom());
        tel.setText(new Long(parentFxHelper.getSelected().getTel()) + "");
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        if (!cin.getText().isEmpty() && !password.getText().isEmpty() && !nom.getText().isEmpty() && !prenom.getText().isEmpty() && !tel.getText().isEmpty()) {
            int res = parentService.creerParent(cin.getText(), password.getText(), nom.getText(), prenom.getText(), new Long(tel.getText()));
            if (res == 1) {
                parentFxHelper.setList(parentService.findAll());
                JOptionPane.showMessageDialog(null, "PARENT AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    @FXML
    private void Modifier(ActionEvent event) {
        if (!cin.getText().isEmpty() && !password.getText().isEmpty() && !nom.getText().isEmpty() && !prenom.getText().isEmpty() && !tel.getText().isEmpty()) {
            Parent p = parentFxHelper.getSelected();
            p.setCin(cin.getText());
            p.setPassword(password.getText());
            p.setNom(nom.getText());
            p.setPrenom(prenom.getText());
            p.setTel(new Long(tel.getText()));
            parentService.edit(p);
            parentFxHelper.setList(parentService.findAll());
            JOptionPane.showMessageDialog(null, " PARENT MODIFIER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
        if (!cin.getText().isEmpty() && !password.getText().isEmpty() && !nom.getText().isEmpty() && !prenom.getText().isEmpty() && !tel.getText().isEmpty()) {
            Parent p = parentFxHelper.getSelected();
            parentService.remove(p);
            cin.setText("");
            password.setText("");
            nom.setText("");
            prenom.setText("");
            tel.setText("");
            parentFxHelper.setList(parentService.findAll());
            JOptionPane.showMessageDialog(null, " PARENT EST SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @FXML
    private void Retour(ActionEvent event) {
    }
}
