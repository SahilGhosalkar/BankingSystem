import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class RelationshipBar {
    private int currentStatus;
    private Queue<Flag> flagHistory;

    public RelationshipBar() {
        currentStatus = 50;
    }
    public RelationshipBar(int initialStatus) {
        currentStatus = initialStatus;
        flagHistory = new LinkedList<>();
    }

    public void addFlagImpact(Flag coloredFlag) {
        flagHistory.add(coloredFlag);
        currentStatus += coloredFlag.getMagnitude();
    }

    public String statusToString() {
        String retString = "Current Status: ";
        int numBars = currentStatus / 5;
        for (int i = 0; i < numBars; i++) {
            retString += "[] ";
        }
        for (int i = numBars; i < 20; i++) {
            retString += "__ ";
        }
        retString += "(" + +currentStatus + "/100 ";

        return retString;
    }
    public String pastFlagsToString() {
//        String retString = "";
//        Iterator iterator = flagHistory.iterator();

        return flagHistory.toString();
    }

    public String toString() {
        return statusToString() + "\n\nFlag history: " + pastFlagsToString();
    }





}
