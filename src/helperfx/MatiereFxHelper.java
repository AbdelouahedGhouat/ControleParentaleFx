/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperfx;

import bean.Matiere;
import java.util.List;
import javafx.scene.control.TableView;

/**
 *
 * @author abdou
 */
public class MatiereFxHelper extends AbstractFxHelper<Matiere> {
    
     private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            
            new AbstractFxHelperItem("Nom de la Matiere", "nom")};
            
    }

    public MatiereFxHelper( TableView<Matiere> table, List<Matiere> list) {
        super(titres, table, list);
    }
     

    public MatiereFxHelper( TableView<Matiere> table) {
        super(titres, table);
    }
    
    
}
