package helperfx;

import bean.NotifDevoir;
import java.util.Date;

import java.util.List;

import javafx.scene.control.TableView;
import util.DateUtil;

public class NotifDevoirFxHelper extends AbstractFxHelper<NotifDevoir> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
           new AbstractFxHelperItem("Etudiant----Matiere----Date", "notedevoir")}; 
    }

    public NotifDevoirFxHelper(TableView<NotifDevoir> table, List<NotifDevoir> list) {
        super(titres, table, list);
    }

    public NotifDevoirFxHelper(TableView<NotifDevoir> table) {
        super(titres, table);
    }
    

}
