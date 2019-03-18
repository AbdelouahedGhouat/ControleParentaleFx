package helperfx;

import bean.Devoir;
import java.util.List;

import javafx.scene.control.TableView;

public class DevoirFxHelper extends AbstractFxHelper<Devoir> {

    private static AbstractFxHelperItem[] titres;

    static {

        titres = new AbstractFxHelperItem[]{
             new AbstractFxHelperItem("Date des devoirs ", "date") };
    }

    public DevoirFxHelper(TableView<Devoir> table, List<Devoir> list) {
        super(titres, table, list);
    }

    public DevoirFxHelper(TableView<Devoir> table) {
        super(titres, table);
    }
//     @Override
//    public Object getValueAt(int rowIndex, int columnIndex) {
//        if (list != null && rowIndex < list.size()) {
//            Devoir devoir = list.get(rowIndex);
//            
//            if (columnIndex == 0) {
//                Date date = devoir.getDate();
//                if (date!= null) {
//                    return DateUtil.formateDate("dd/MM/yyyy HH:mm", date);
//                }
//            } else {
//                return super.getValueAt(rowIndex, columnIndex);
//            }
//        }
//        return "";
//    }
//    

}
