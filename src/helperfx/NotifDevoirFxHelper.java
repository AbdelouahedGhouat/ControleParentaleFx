package helperfx;

import bean.NotifDevoir;
import java.util.Date;

import java.util.List;

import javafx.scene.control.TableView;
import util.DateUtil;

public class NotifDevoirFxHelper extends AbstractFxHelper<NotifDevoir> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
           new AbstractFxHelperItem("Matiere", "notedevoir.devoir.matiere"),
            new AbstractFxHelperItem("Date", "date")}; 
    }

    public NotifDevoirFxHelper(TableView<NotifDevoir> table, List<NotifDevoir> list) {
        super(titres, table, list);
    }

    public NotifDevoirFxHelper(TableView<NotifDevoir> table) {
        super(titres, table);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (list != null && rowIndex < list.size()) {
            NotifDevoir notifDevoir = list.get(rowIndex);
            if (columnIndex == 0) {
                return notifDevoir.getNotedevoir().getDevoir().getMatiere().getNom();
            }
            if (columnIndex == 1) {
                Date date = notifDevoir.getNotedevoir().getDevoir().getDate();
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
