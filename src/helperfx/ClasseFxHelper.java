package helperfx;

import bean.Classe;

import java.util.List;

import javafx.scene.control.TableView;

public class ClasseFxHelper extends AbstractFxHelper<Classe> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
             new AbstractFxHelperItem("Classe", "nom")};
    }

    public ClasseFxHelper(TableView<Classe> table, List<Classe> list) {
        super(titres, table, list);
    }

    public ClasseFxHelper(TableView<Classe> table) {
        super(titres, table);
    }

}
