package App;

public class Relationship {
    private User person1;
    private Person person2;
    private boolean isPast;
    private RelationshipBar relationshipBar;
    private FlagIndex index;
    /**
     * Constructs a new Relationship between the two specified people, and sets whether
     * the relationship is current or past.
     *
     * @param p1 first Person in the relationship.
     * @param p2 second Person in the relationship.
     * @param isPast true if this relationship is from the past, false if it is ongoing.
     */

    public Relationship(User p1, Person p2, boolean isPast, FlagIndex index) {
        this.person1 = p1;
        this.person2 = p2;
        this.isPast = isPast;
        this.relationshipBar = new RelationshipBar();
        this.index = index;
    }

    public void setPast(boolean past) {
        isPast = past;
    }

    /**
     * Adds a Flag event to the relationship, which affects the RelationshipBar status
     *
     * @param flag the Flag to be added, representing an event or action impacting the relationship.
     */
    public void addFlagToRelationship(Flag flag) {
        relationshipBar.addFlagImpact(flag);
    }

    /**
     * Summarizes the green and red flags in the relationship.
     * output format:
     * "Although you did: [list of green flags], you ultimately SUCK because [list of red flags]"
     *
     * If there are no green flags, the list for green flags will be empty.
     * If there are no red flags, the list for red flags will be empty.
     *
     * @return A summary string of all green and red flags.
     */
    public String breakUpText() {
        // Temporary storage for green and red flags' descriptions
        StringBuilder greenFlagsList = new StringBuilder();
        StringBuilder redFlagsList = new StringBuilder();

        // Iterate over all flags in the relationship bar
        for (Flag f : index.getAllFlags().values()) {
            //check for color of flag to sort
            if (f instanceof GreenFlag) {
                if (greenFlagsList.length() > 0) {
                    greenFlagsList.append(", ");
                }
                greenFlagsList.append(f.getDescription());
            } else if (f instanceof RedFlag) {
                if (redFlagsList.length() > 0) {
                    redFlagsList.append(", ");
                }
                redFlagsList.append(f.getDescription());
            }
        }

        String greenPart = greenFlagsList.length() > 0 ? greenFlagsList.toString() : "nothing good";
        String redPart = redFlagsList.length() > 0 ? redFlagsList.toString() : "nothing bad";

        return "Although you did: " + greenPart + ", you ultimately SUCK because " + redPart + " so we are OVER";
    }

    /**
     * Returns a string representation of the relationship, including:
     * status (current or past)
     * names and details of both persons
     * RelationshipBar status and Flag history
     *
     * @return formatted string describing the relationship and its current state
     */
    @Override
    public String toString() {
        String status;
        if (isPast) {
            status = "Past Relationship";
        } else {
            status = "Current Relationship";
        }

        String relationshipInfo = status + " between " + person1.getName() + " and " + person2.getName() + "\n\n";
        relationshipInfo += "Person 1: " + person1.toString() + "\n";
        relationshipInfo += "Person 2: " + person2.toString() + "\n\n";
        relationshipInfo += "Relationship Status:\n";
        relationshipInfo += relationshipBar.toString();

        return relationshipInfo;
    }
}