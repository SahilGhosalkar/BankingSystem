import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class RelationshipBar {
    private int currentStatus;
    private Queue<Flag> flagHistory; // queue because for printing, FIFO--first in, first out;; for earliest --> latest succession

    /***
     * Default constructor for class. Initalizes relationship health to 50.
     */
    public RelationshipBar() {
        this(50);
    }

    /***
     * Non-default constructor for RelationshipBar class.
     * @param initialStatus initial relationship health. Can be a high value if you're off to a good start or
     *                      not if relationship is from rocky beginnings.
     */
    public RelationshipBar(int initialStatus) {
        currentStatus = initialStatus;
        flagHistory = new LinkedList<>();
    }

    /**
     * Updates relationship health according to actions from the relationship.
     * @param coloredFlag the flag/action commited by the partner. Can be green (positive), red (negative), or anything in between
     */
    public void addFlagImpact(Flag coloredFlag) {
        flagHistory.add(coloredFlag);
        currentStatus += coloredFlag.getMagnitude();
    }

    /**
     * Generates visual representation of relationship status.
     * @return String containing console-style visual/graphic updating string status.
     */
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

    /**
     * Generates a list of all the past flags, in order of when they were added.
     * @return String list representation of all flags
     */
    public String pastFlagsToString() {
//        String retString = "";
//        Iterator iterator = flagHistory.iterator();

        return flagHistory.toString();
    }

    /***
     * Overall toString method to give status update + show flags impacting event
     * @return
     */
    public String toString() {
        return statusToString() + "\n\nFlag history: " + pastFlagsToString();
    }





}
