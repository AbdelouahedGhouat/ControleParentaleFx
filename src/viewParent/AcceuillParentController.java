/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewParent;

import bean.Etudiant;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;


/**
 *
 * @author abdou
 */
public class AcceuillParentController implements Initializable {

    @FXML
    private TableView<?> tabD;
    @FXML
    private Button deconnecter;
    @FXML
    private ComboBox<Etudiant> etudiant;
    @FXML
    private TableView<?> tabE;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

   
  

   
}
