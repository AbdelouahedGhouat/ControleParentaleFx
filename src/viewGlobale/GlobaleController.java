/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewGlobale;

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
 *
 * @author abdou
 */
public class GlobaleController implements Initializable {

    @FXML
    private Button admin;
    @FXML
    private Button parent;

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Admin(ActionEvent event) {
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
    private void Patentt(ActionEvent event) {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ConnectionParent.fxml"));
                javafx.scene.Parent root1 = (javafx.scene.Parent) fxmlLoader.load();
                Stage nextStage = new Stage();
                nextStage.setScene(new Scene(root1));
                nextStage.show();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

   
}
