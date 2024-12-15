package Testers;

import App.Flag;
import App.FlagIndex;
import App.RedFlag;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FlagIndexTester {
    public static void main(String[] args) {
        //creates flagIndex
        FlagIndex index = new FlagIndex();

        //create flag
        Flag flag1 = new RedFlag("Doesnt want to show me off", -20);

        //add flag to index
        index.addFlag(1, flag1);

        //get and print flag from index if exists
        System.out.println("Get Flag with ID 1:");
        Flag retrievedFlag = index.getFlag(1);
        if (retrievedFlag != null) {
            System.out.println(retrievedFlag);
        } else {
            System.out.println("No Flag found with ID 1");
        }

        //print all flags in index
        System.out.println("\nAll Flags in the index:");
        Map<Integer, Flag> allFlags = index.getAllFlags();
        for (Entry<Integer, Flag> entry : allFlags.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("raw query search: " + index.searchFlags("show me off").toString());

        ArrayList<String> colorFilters = new ArrayList<>();
        colorFilters.add("green");
        System.out.println("query search with green-flag filter: " + index.searchFlags("show me off", colorFilters).toString());

        colorFilters.remove(0);
        colorFilters.add("red");
        System.out.println("query search with red-flag filter: " + index.searchFlags("show me off", colorFilters).toString());

        colorFilters.add("green");
        System.out.println("query search with red AND green flag filters: " + index.searchFlags("show me off", colorFilters).toString());




        //remove a flag
        System.out.println("\nRemoving Flag with ID 1...");
        boolean removed = index.removeFlag(1);
        System.out.println("Flag with ID 1 removed: " + removed);

    }
}