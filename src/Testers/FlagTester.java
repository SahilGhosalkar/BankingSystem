package Testers;

import App.RedFlag;
import App.*;


public class FlagTester {
    public static void main(String[] args) {

        Flag redFlag = new RedFlag("Doesnt want to show me off", -20);
        System.out.println(redFlag);

        Flag redFlag2 = new RedFlag("stupid");
        System.out.println(redFlag2);


        Flag greenFlag = new GreenFlag("funny", 20);
        System.out.println(greenFlag);

        Flag greenFlag2 = new GreenFlag("cool");
        System.out.println(greenFlag2);

    }
}
