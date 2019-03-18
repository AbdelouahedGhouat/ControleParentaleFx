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
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    MatiereFxHelper matiereHelper;
    List<Matiere> matieres;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         initEcoles();
        initHelper();
        initComboClasse();
    }
    public void initEcoles() {
        ecolePrives = ecolePriveService.findAll();
        for (EcolePrive e : ecolePrives) {
           // classe.addItem(e.getNom());
        }
    }

    public void initHelper() {
        matiereHelper = new MatiereFxHelper(tab);
    }

    public void setHelperList(Long id) {
        matieres = matiereService.findByClasse(id);
        matiereHelper.setList(matieres);
    }

    public void initComboClasse() {
//        classe.addItemListener((ie) -> {
//            String item = (String) ie.getItem();
//            for (Classe c : classes) {
//                if (item.equals(c.getNom())) {
//                    setHelperList(c.getId());
//                }
//            }
//        });
    }
}
