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




}
