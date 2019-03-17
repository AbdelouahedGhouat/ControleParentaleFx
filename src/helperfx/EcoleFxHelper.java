package helperfx;

import bean.EcolePrive;

import java.util.List;

import javafx.scene.control.TableView;

public class EcoleFxHelper extends AbstractFxHelper<EcolePrive> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
             new AbstractFxHelperItem("Ecole", "nom")};
    }

    public EcoleFxHelper(TableView<EcolePrive> table, List<EcolePrive> list) {
        super(titres, table, list);
    }

    public EcoleFxHelper(TableView<EcolePrive> table) {
        super(titres, table);
    }

}
