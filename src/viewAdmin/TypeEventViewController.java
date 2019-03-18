/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;

import bean.TypeEvent;
import helperfx.TypeEventFxHelper;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import service.TypeEventService;

;

/**
 *
 * @author abdou
 */
public class TypeEventViewController implements Initializable {

    @FXML
    private TableView tab;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private TextField nom;

    TypeEventService typeEventService = new TypeEventService();
    List<TypeEvent> typeEvents;
    TypeEventFxHelper typeEventHelper;

    private void initHelper() {
        typeEvents = typeEventService.findAll();
        typeEventHelper = new TypeEventFxHelper(tab, typeEvents);
        typeEventHelper.setList(typeEvents);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();
    }

    @FXML
    private void setParam(MouseEvent event) {
        nom.setText(typeEventHelper.getSelected().getType());

    }

    @FXML
    private void Ajouter(ActionEvent event) {
        int res = typeEventService.creerType(nom.getText());
        if (res == 1) {
            typeEventHelper.setList(typeEventService.findAll());
            JOptionPane.showMessageDialog(null, "TYPE EVENEMENT AJOUTER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "TYPE EVENEMENT EXISTE DEJA  ", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void Modifier(ActionEvent event) {
          if (!nom.getText().isEmpty()) {
            TypeEvent t = typeEventHelper.getSelected();
            t.setType(nom.getText());
            typeEventService.edit(t);
            typeEventHelper.setList(typeEventService.findAll());
            JOptionPane.showMessageDialog(null, "TYPE D'EVENEMENT EST MODIFIER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
          TypeEvent t = typeEventHelper.getSelected();
        typeEventService.remove(t);
        typeEventHelper.setList(typeEventService.findAll());
        nom.setText("");
        JOptionPane.showMessageDialog(null, "TYPE D'EVENEMENT EST SUPPRIMER AVEC SUCCES ", "info", JOptionPane.INFORMATION_MESSAGE);
    
    }                    
    

}
