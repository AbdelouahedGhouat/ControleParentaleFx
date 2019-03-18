/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewAdmin;


import bean.Devoir;
import bean.NotifDevoir;
import helperfx.DevoirNotifFxHelper;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import service.NotifDevoirService;
import util.Session;



/**
 *
 * @author abdou
 */
public class DevoirNotifViewController implements Initializable {

    private TableView<NotifDevoir> tab;
    @FXML
    private Button retour;


    Devoir d = (Devoir) Session.getAttribut("devoir");
    NotifDevoirService notifDevoirService = new NotifDevoirService();
    List<NotifDevoir> notifDevoirs ;
    DevoirNotifFxHelper devoirNotifFxHelper;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initHelper();
    }

     public void initHelper(){
//        notifDevoirs = notifDevoirService.findByDevoir(d.getId());
//        devoirNotifFxHelper = new DevoirNotifFxHelper(tab, notifDevoirs);
    }
    @FXML
    private void Retour(ActionEvent event) {
        
    }

 


   

}
