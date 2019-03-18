/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperfx;

import bean.Evenement;
import java.util.Date;
import java.util.List;
import javafx.scene.control.TableView;
import util.DateUtil;

/**
 *
 * @author abdou
 */
public class EventFxHelper extends AbstractFxHelper<Evenement>{
    private static AbstractFxHelperItem[] titres;

    static {
        titres = new AbstractFxHelperItem[]{
            
             new AbstractFxHelperItem("Nom d'evenement ", "nom"),
             new AbstractFxHelperItem("Type d'evenements ", "type"), 
             new AbstractFxHelperItem("Date d'Evenements ", "date")  };
            
    }

    public EventFxHelper( TableView<Evenement> table, List<Evenement> list) {
        super(titres, table, list);
    }
    

    public EventFxHelper(TableView<Evenement> table ) {
        super(titres, table);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (list != null && rowIndex < list.size()) {
            Evenement evenement = list.get(rowIndex);
            if(columnIndex==1){
                return evenement.getTypeEvent().getType();
            }
            if (columnIndex == 2) {
                Date date = evenement.getDate();
                if (date!= null) {
                    return DateUtil.formateDate("dd/MM/yyyy HH:mm", date);
                }
            } else {
                return super.getValueAt(rowIndex, columnIndex);
            }
        }
        return "";
    }
    
}
