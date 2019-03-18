package helperfx;

import bean.NotifDevoir;
import java.util.List;

import javafx.scene.control.TableView;

public class DevoirNotifFxHelper extends AbstractFxHelper<NotifDevoir> {

    private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            new AbstractFxHelperItem("Matiere", "notedevoir.devoir.matiere"),
            new AbstractFxHelperItem("Date", "date")
        };
    }

    public DevoirNotifFxHelper(TableView<NotifDevoir> table, List<NotifDevoir> list) {
        super(titres, table, list);
    }

    public DevoirNotifFxHelper(TableView<NotifDevoir> table) {
        super(titres, table);
    }

}
