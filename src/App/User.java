package App;

import java.util.ArrayList;

/**
 * Represents a user who can have multiple relationships.
 * Inherits basic personal attributes from the Person class and maintains a history of relationships.
 */
public class User extends Person {

    /**
     * A list of all relationships the user has been involved in.
     */
    private ArrayList<Relationship> relationships;

    /**
     * Default constructor for the User class.
     * Initializes an empty relationship history and calls the default constructor of Person.
     */
    public User() {
        super();
        relationships = new ArrayList<>();
    }

    /**
     * Parameterized constructor for the User class.
     *
     * @param name        The name of the user.
     * @param eyeColor    The eye color of the user.
     * @param heightInches The height of the user in inches.
     * @param gender      The gender of the user.
     * @param age         The age of the user.
     */
    public User(String name, String eyeColor, int heightInches, String gender, int age) {
        super(name, eyeColor, heightInches, gender, age);
        relationships = new ArrayList<>();
    }

    /**
     * Adds a new relationship to the user's relationship history.
     *
     * @param relationship The new Relationship object to add.
     * @return The index of the added relationship in the history.
     */
    public int addRelationship(Relationship relationship) {
        relationships.add(relationship);
        return relationships.size() - 1;
    }

    /**
     * Retrieves a shallow copy of the user's relationship history.
     *
     * @return A cloned ArrayList containing the user's relationships.
     */
    public ArrayList<Relationship> getRelationships() {
        return (ArrayList<Relationship>) relationships.clone();
    }

    /**
     * Retrieves the number of relationships the user has been involved in.
     *
     * @return The total number of relationships.
     */
    public int getNumRelationships() {
        return relationships.size();
    }

    /**
     * Retrieves a specific relationship from the user's history based on its index.
     *
     * @param index The index of the desired relationship.
     * @return The Relationship object at the specified index.
     * @throws IndexOutOfBoundsException if the index is invalid.
     */
    public Relationship getRelationship(int index) {
        return relationships.get(index);
    }

    /**
     * Generates a summary of the user's relationship history.
     *
     * @return A formatted string listing the user's relationships in order.
     */
    public String relationHistoryToString() {
        StringBuilder retString = new StringBuilder();
        for (int i = 0; i < relationships.size(); i++) {
            retString.append("\n   ").append(i).append(": ").append(relationships.get(i).toStringShort());
        }
        return retString.toString();
    }

    /**
     * Provides a detailed description of the user, including personal information and relationship history.
     *
     * @return A string representation of the user's full profile.
     */
    public String toStringFull() {
        return "Basic information: \n" + super.toString() + "\nRelationship History: " + relationHistoryToString();
    }
}
