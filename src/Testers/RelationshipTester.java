package Testers;

import App.*;

public class RelationshipTester {
    public static void main(String[] args) {

        Person alice = new user("dude1", "blue", 65, "female", 30);
        Person bob = new Person("dude2", "green", 70, "male", 32);

        Relationship relationship = new Relationship(alice, bob, false);

        Flag redFlagBday = new RedFlag("forgot birthday", -10);
        Flag greenFlagFlowers = new GreenFlag("bought flowers", 15);

        relationship.addFlagToRelationship(redFlagBday);
        relationship.addFlagToRelationship(greenFlagFlowers);

        System.out.println(relationship);
    }
}