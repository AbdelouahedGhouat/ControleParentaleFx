package helperfx;



import bean.Etudiant;
import java.util.List;

import javafx.scene.control.TableView;

public class EtudiantFxHelper extends AbstractFxHelper<Etudiant> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
             new AbstractFxHelperItem("Nom", "nom"),
            new AbstractFxHelperItem("Prénom", "prenom"),
            new AbstractFxHelperItem("Classe Actuelle ", "classe"),
            new AbstractFxHelperItem("Parent", "parent")
        };
            
    }

    public EtudiantFxHelper(TableView<Etudiant> table, List<Etudiant> list) {
        super(titres, table, list);
    }

    public EtudiantFxHelper(TableView<Etudiant> table) {
        super(titres, table);
    }

}
