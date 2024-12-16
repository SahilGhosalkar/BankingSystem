package Testers;

import App.*;

public class PersonTester {
    public static void main(String[] args){
        Person person1 = new Person("Zoya", "Blue", 65, "Gremlin", 30);
        System.out.println(person1);

        User user = new User("Zoya", "Blue", 65, "Gremlin", 30);
        System.out.println(user);
    }
}
