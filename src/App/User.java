package App;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class User extends Person {

    private ArrayList<Relationship> relationships; // maintains relationship history
    public User() {
        super();
        relationships = new ArrayList<>();
    }

    public User(String name, String eyeColor, int heightInches, String gender, int age) {
        super(name, eyeColor, heightInches, gender, age);
        relationships = new ArrayList<>();
    }

    /***
     * Adds relationship to list of all relationship history of User
     * @param relationship Relationship object of next relationship
     * @return location in ArrayList aka the relationship # (like "my 5TH relationship")
     */
    public int addRelationship(Relationship relationship) {
        relationships.add(relationship);
        return relationships.size() -1;
    }

    /***
     * Returns list of relationship history if User wants to access relationship Objects
     * @return new object reference to new version but with the same Relationship objects...i think
     */
    public ArrayList<Relationship> getRelationships() {
        return (ArrayList<Relationship>) relationships.clone();
    }

    /***
     * Computes number of past and present relationships based on size of Relationship Histroy array
     * @return number of relatioships
     */
    public int getNumRelationships() {
        return relationships.size();
    }

    /***
     * Gets the object reference for a specific Relationship
     * @param index index in which to retrieve the relationship of
     * @return object reference to Relationship
     */
    public Relationship getRelationship(int index) {
        return relationships.get(index);
    }

    public String relationHistoryToString() {
        String retString = "";
        for (int i = 0; i < relationships.size(); i ++) {
            retString += "\n   " + i + ": " +  relationships.get(i).toStringShort() ;
        }
        return retString;
    }

    public String toStringFull() {
        return "Basic information: \n" + super.toString() + "\nRelationship History: " + relationHistoryToString();
    }






}
