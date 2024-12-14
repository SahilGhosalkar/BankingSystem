package Testers;

import App.RedFlag;
import App.*;


public class FlagTester {
    public static void main(String[] args) {

        Flag flag = new RedFlag("Doesnt want to show me off", -20);
        System.out.println(flag.toString());
    }
}
