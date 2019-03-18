/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperfx;

import bean.NoteDevoir;
import java.util.List;
import javafx.scene.control.TableView;

/**
 *
 * @author abdou
 */
public class NoteDevoirFxHelper extends AbstractFxHelper<NoteDevoir> {
     private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            
             new AbstractFxHelperItem("Nom d'étudiant  ", "etudient"),
             new AbstractFxHelperItem("Note de Devoir selectionné ", "note")
               };
            
    }

    public NoteDevoirFxHelper( TableView<NoteDevoir> table, List<NoteDevoir> list) {
        super(titres, table, list);
    }
     public NoteDevoirFxHelper(AbstractFxHelperItem[] abstractHelperItem, TableView<NoteDevoir> table) {
        super(titres, table);
    }

    public NoteDevoirFxHelper( TableView<NoteDevoir> table) {
        super(titres, table);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (list != null && rowIndex < list.size()) {
            NoteDevoir noteDevoir = list.get(rowIndex);
            if(columnIndex==1){
                return noteDevoir.getNote();
            }
            if(columnIndex==0){
                return noteDevoir.getEtudient().getNom()+" "+noteDevoir.getEtudient().getPrenom();
            }
            
             else {
                return super.getValueAt(rowIndex, columnIndex);
            }
        }
        return "";
    }
}
