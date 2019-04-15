
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
        String result = "";
        result += whoozit;
        for(String w : whatzits) {
            result += w;
        }
        return result;
    }
}
