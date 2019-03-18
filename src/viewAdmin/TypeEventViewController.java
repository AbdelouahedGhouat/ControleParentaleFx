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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    TypeEventFxHelper typeEventHelper ;

     private void initHelper() {
         typeEvents= typeEventService.findAll();
        typeEventHelper = new TypeEventFxHelper(tab, typeEvents);
        typeEventHelper.setList(typeEvents);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();
    }
    
    

 


   

}
