package App;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a relationship health tracker with a current status and a history of flags
 * impacting the relationship. Flags can have positive or negative impacts.
 */
public class RelationshipBar {

    /**
     * The current status of the relationship, ranging from 0 to 100.
     */
    private int currentStatus;

    /**
     * A queue holding the history of flags affecting the relationship, in order of addition.
     */
    private Queue<Flag> flagHistory; // Queue to maintain FIFO order for flags

    /**
     * Default constructor for the RelationshipBar class.
     * Initializes the relationship health to 50.
     */
    public RelationshipBar() {
        this(50);
    }

    /**
     * Non-default constructor for the RelationshipBar class.
     *
     * @param initialStatus The initial relationship health. Can be high for a positive start
     *                      or low for a rocky beginning.
     */
    public RelationshipBar(int initialStatus) {
        currentStatus = initialStatus;
        flagHistory = new LinkedList<>();
    }

    /**
     * Gets the current status of the relationship.
     *
     * @return The current relationship health.
     */
    public int getCurrentStatus() {
        return currentStatus;
    }

    /**
     * Updates the relationship health based on an action (flag) from the partner.
     *
     * @param coloredFlag The flag/action committed by the partner. It can have a positive (green),
     *                    negative (red), or neutral impact.
     */
    public void addFlagImpact(Flag coloredFlag) {
        flagHistory.add(coloredFlag);
        currentStatus += coloredFlag.getImpact();
    }

    /**
     * Generates a visual representation of the current relationship status.
     *
     * @return A string containing a console-style graphic of the relationship status.
     */
    public String statusToString() {
        StringBuilder retString = new StringBuilder("Current Status: ");
        int numBars = currentStatus / 5;
        for (int i = 0; i < numBars; i++) {
            retString.append("[] ");
        }
        for (int i = numBars; i < 20; i++) {
            retString.append("__ ");
        }
        retString.append("(").append(currentStatus).append("/100");

        return retString.toString();
    }

    /**
     * Generates a formatted list of all past flags in the order they were added.
     *
     * @return A string representation of the flag history queue. If no flags exist, returns
     *         "[No flags yet]".
     */
    public String pastFlagsToString() {
        if (flagHistory.isEmpty()) {
            return "[No flags yet]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Iterator<Flag> iterator = flagHistory.iterator();
        while (iterator.hasNext()) {
            Flag f = iterator.next();
            sb.append(f.toString());
            if (iterator.hasNext()) {
                sb.append("; ");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Combines the visual relationship status and the flag history into a single string.
     *
     * @return A string containing the current relationship status and flag history.
     */
    @Override
    public String toString() {
        return statusToString() + "\n\nFlag history: " + pastFlagsToString();
    }
}
