package Testers;

import App.*;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class RelationshipTester {
    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        FlagIndex index = new FlagIndex();
        index.importFlagsFromFile("src/App/FlagDatabase.txt");

        User alice = new User("dude1", "blue", 65, "female", 30);
        Person bob = new Person("dude2", "green", 70, "male", 32);

        Relationship relationship = new Relationship(alice, bob, false, index);

        Flag redFlagBday = new RedFlag("forgot birthday", -10);
        Flag greenFlagFlowers = new GreenFlag("bought flowers", 15);

        relationship.addFlagToRelationship(redFlagBday);
        relationship.addFlagToRelationship(greenFlagFlowers);

        System.out.println(relationship);
        System.out.println(relationship.breakUpText());
    }
}