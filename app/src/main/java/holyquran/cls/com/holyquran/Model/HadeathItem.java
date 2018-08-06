package holyquran.cls.com.holyquran.Model;

import java.util.ArrayList;

/**
 * Created by CLS on 8/6/2018.
 */

public class HadeathItem {
    ArrayList<String> allLines;

    public ArrayList<String> getAllLines() {
        return allLines;
    }

    public void setAllLines(ArrayList<String> allLines) {
        this.allLines = allLines;
    }

    public HadeathItem(){
        allLines=new ArrayList<>();
    }
}
