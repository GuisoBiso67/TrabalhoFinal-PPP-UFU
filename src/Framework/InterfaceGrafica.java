package Framework;

import java.util.ArrayList;
import java.util.List;

public class InterfaceGrafica {
    public String getTextQuestion(Question q){
        return q.getStatement();
    }
    public List<String> getTextItems(Question q){
        List<String> list = new ArrayList<String>();
        for(Item i : q.getItems()){
            list.add(i.getText());
        }
        return list;
    }


}
