
public class BlurbGenerator {
    public String generateWhoozit(int count, boolean startFlag) {
        if(count == 0) return "";
        else if(startFlag) return "x" + generateWhoozit(count, false);
        else {
            return generateYs() + generateWhoozit(count - 1, false);
        }
    }
    public String generateWhatzit(int count, boolean startFlag, String whoozit) {
        if(count == 0) return "";
        else if(startFlag) {
            String randLetter = ((int)(Math.random() * 2) == 1) ? "z" : "d";
            return "q" + randLetter + generateWhatzit(count, false, whoozit);
        }
        else {
            return whoozit + generateWhatzit(count - 1, false, whoozit);
        }
    }
    public Blurb generateRandomBlurb() {
        String whoozit = generateWhoozit((int)(Math.random() * 5) + 1, true);
        Blurb b = new Blurb(whoozit);
        b.addWhatzit(generateWhatzit(2, true, whoozit));
        return b;
    }
    private String generateYs() {
        return "y";
    }
    
}
