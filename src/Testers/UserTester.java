//package Testers;
//
//import App.*;
//
//public class UserTester {
//    public static void main(String[] args) {
//        User alice = new User("dude1", "blue", 65, "female", 30);
//        Person bob = new Person("dude2", "green", 70, "male", 32);
//        Person jefff = new Person("jeff", "purple", 70, "male", 32);
//
//
//        Relationship relationship = new Relationship(alice, bob, false);
//
//        alice.addRelationship(relationship);
//
//        Flag redFlagBday = new RedFlag("forgot birthday", -10);
//        Flag greenFlagFlowers = new GreenFlag("bought flowers", 15);
//
//        relationship.addFlagToRelationship(redFlagBday);
//        relationship.addFlagToRelationship(greenFlagFlowers);
//
//
//
//        Relationship newRelationship = new Relationship(alice, jefff, false);
//
//        alice.addRelationship(newRelationship);
//
//        newRelationship.addFlagToRelationship(redFlagBday);
//        newRelationship.addFlagToRelationship(greenFlagFlowers);
//
//
//
//        System.out.println(alice.toStringFull());
//
//    }
//}
