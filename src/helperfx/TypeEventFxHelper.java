package helperfx;

import bean.TypeEvent;

import java.util.List;

import javafx.scene.control.TableView;

public class TypeEventFxHelper extends AbstractFxHelper<TypeEvent> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{   
            new AbstractFxHelperItem("Type d'événement ", "type")
        };
    }

    public TypeEventFxHelper(TableView<TypeEvent> table, List<TypeEvent> list) {
        super(titres, table, list);
    }

    public TypeEventFxHelper(TableView<TypeEvent> table) {
        super(titres, table);
    }

}
