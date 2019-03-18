package helperfx;

import bean.NotifEvent;


import java.util.List;

import javafx.scene.control.TableView;

public class NotifEventFxHelper extends AbstractFxHelper<NotifEvent> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
           new AbstractFxHelperItem("Nom", "nom"),
            new AbstractFxHelperItem("Type", "type"),
            new AbstractFxHelperItem("Date", "date")};
    }

    public NotifEventFxHelper(TableView<NotifEvent> table, List<NotifEvent> list) {
        super(titres , table, list);
    }

    public NotifEventFxHelper(TableView<NotifEvent> table) {
        super(titres, table);
    }

}
