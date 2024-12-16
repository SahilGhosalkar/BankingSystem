package App;

public class Relationship {
    private Person person1;
    private Person person2;
    private boolean isPast;
    private RelationshipBar relationshipBar;
    /**
     * Constructs a new Relationship between the two specified people, and sets whether
     * the relationship is current or past.
     *
     * @param p1 first Person in the relationship.
     * @param p2 second Person in the relationship.
     * @param isPast true if this relationship is from the past, false if it is ongoing.
     */
    public Relationship(Person p1, Person p2, boolean isPast) {
        this.person1 = p1;
        this.person2 = p2;
        this.isPast = isPast;
        this.relationshipBar = new RelationshipBar();
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
