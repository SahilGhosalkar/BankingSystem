package Testers;

import App.Flag;
import App.FlagIndex;
import App.RedFlag;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class FlagIndexTester {
    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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




        //remove a flag
        System.out.println("\nRemoving Flag with ID 1...");
        boolean removed = index.removeFlag(1);
        System.out.println("Flag with ID 1 removed: " + removed);

        //NEW TEST FOR NEW FLAGINDEX TOSTRING METHOD
        System.out.println("\nTesting FlagIndex toString():");
        System.out.println(index.toString());


        index.importFlagsFromFile("src/App/FlagDatabase.txt");
        System.out.println("\n[UPDATED WITH IMPORT] All Flags in the index:");
        Map<Integer, Flag> allFlags2 = index.getAllFlags();
        for (Entry<Integer, Flag> entry : allFlags.entrySet()) {
            System.out.println("ID: " + entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("SHOW ME OFF TEST CASES");
        String q1 = "ghosts me";
        // searching test cases
        System.out.println("just a query search: " + index.searchFlags(q1).toString());

        ArrayList<String> colorFilters = new ArrayList<>();
        colorFilters.add("green");
        System.out.println("query search with green-flag filter: " + index.searchFlags(q1, colorFilters).toString());

        colorFilters.remove(0);
        colorFilters.add("red");
        System.out.println("query search with red-flag filter: " + index.searchFlags(q1, colorFilters).toString());

        colorFilters.add("green");
        System.out.println("query search with red AND green flag filters: " + index.searchFlags(q1, colorFilters).toString());

        // hmm okay this test case works fine but the first one doesn't its probably the language of the query + filler words
        System.out.println("\nFLOWER TEST CASES");
        // searching test cases
        System.out.println("just a query search: " + index.searchFlags("flowers").toString());

        ArrayList<String> colorFilters2 = new ArrayList<>();
        colorFilters2.add("green");
        System.out.println("query search with green-flag filter: " + index.searchFlags("flowers", colorFilters).toString());

        colorFilters2.remove(0);
        colorFilters2.add("red");
        System.out.println("query search with red-flag filter: " + index.searchFlags("flowers", colorFilters).toString());

        colorFilters2.add("green");
        System.out.println("query search with red AND green flag filters: " + index.searchFlags("flowers", colorFilters).toString());



    }
}