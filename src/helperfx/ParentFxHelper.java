package helperfx;

import bean.Parent;

import java.util.List;

import javafx.scene.control.TableView;

public class ParentFxHelper extends AbstractFxHelper<Parent> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
               new AbstractFxHelperItem("CIN", "cin"),
            new AbstractFxHelperItem("Password", "password"),
            new AbstractFxHelperItem("Nom", "nom"),
            new AbstractFxHelperItem("Prénom", "prenom"),
            new AbstractFxHelperItem("Tel", "tel")
        };
            
    }

    public ParentFxHelper(TableView<Parent> table, List<Parent> list) {
        super(titres, table, list);
    }

    public ParentFxHelper(TableView<Parent> table) {
        super(titres, table);
    }

}
