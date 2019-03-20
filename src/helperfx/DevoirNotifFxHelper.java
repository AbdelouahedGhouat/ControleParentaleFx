package helperfx;

import bean.NotifDevoir;
import java.util.Date;

import java.util.List;

import javafx.scene.control.TableView;
import util.DateUtil;

public class DevoirNotifFxHelper extends AbstractFxHelper<NotifDevoir> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Etudiant  Matiere ", "notedevoir"),
            new AbstractFxHelperItem("Description ", "description"),
            new AbstractFxHelperItem("Date Lecture de devoir ", "dateLecture")};
    }

    public DevoirNotifFxHelper(TableView<NotifDevoir> table, List<NotifDevoir> list) {
        super(titres, table, list);
    }

    public DevoirNotifFxHelper(TableView<NotifDevoir> table) {
        super(titres, table);
    }
}
