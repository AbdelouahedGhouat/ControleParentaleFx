package helperfx;

import bean.NotifDevoir;
import bean.NotifEvent;
import java.util.Date;

import java.util.List;

import javafx.scene.control.TableView;
import util.DateUtil;

public class EventNotifFxHelper extends AbstractFxHelper<NotifEvent> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
              new AbstractFxHelperItem("Nom d'etudiant ", "etudiant"),
             new AbstractFxHelperItem("Description ", "description"), 
             new AbstractFxHelperItem("Date Lecture d'Evenements ", "dateLecture")  };
    }

    public EventNotifFxHelper(TableView<NotifEvent> table, List<NotifEvent> list) {
        super(titres, table, list);
    }

    public EventNotifFxHelper(TableView<NotifEvent> table) {
        super(titres, table);
    }
    
//    @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        if (list != null && rowIndex < list.size()) {
//            NotifDevoir notifDevoir = list.get(rowIndex);
//            if (columnIndex == 0) {
//                return notifDevoir.getNotedevoir().getDevoir().getMatiere().getNom();
//            }
//            if (columnIndex == 1) {
//                Date date = notifDevoir.getNotedevoir().getDevoir().getDate();
//                if (date!= null) {
//                    return DateUtil.formateDate("dd/MM/yyyy HH:mm", date);
//                }
//            } else {
//                return super.getValueAt(rowIndex, columnIndex);
//            }
//        }
//        return "";
//    }

}
