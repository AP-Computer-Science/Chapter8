
import java.util.ArrayList;


public class Blurb {
    private String whoozit;
    private ArrayList<String> whatzits;
    public Blurb(String whoz) {
        whoozit = whoz;
        whatzits = new ArrayList<String>();
    }
    public void addWhatzit(String w) {
        whatzits.add(w);
    }
    public String toString() {
        return whoozit + iterateWhatzit(0);
    }
    public String iterateWhatzit(int pos) {
        if(pos < whatzits.size()) return "";
        else {
            return whatzits.get(pos) + iterateWhatzit(pos + 1);
        }
    }
}
