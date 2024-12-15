package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class FlagIndex {
    private Map<Integer, Flag> flagMap;
    private TreeMap<String, Class> flagColors = new TreeMap<>();

    public FlagIndex() {
        //map to store the ID-Flag pairs
        flagMap = new TreeMap<>();
        flagColors.put("green", GreenFlag.class);
        flagColors.put("red", RedFlag.class);
    }


    //Adds a Flag to the index with ID
    public void addFlag(int id, Flag flag) {
        flagMap.put(id, flag);
    }

     //Removes the Flag associated with the given ID.
    public boolean removeFlag(int id) {
        return flagMap.remove(id) != null;
    }

    //Retrieves the Flag associated with the given ID.
    public Flag getFlag(int id) {
        return flagMap.get(id);
    }

    //Returns a read-only view of all Flags stored
    public Map<Integer, Flag> getAllFlags() {
        return Collections.unmodifiableMap(flagMap);
    }

    /***
     * Imports flags stored in a database and assigns them IDS
     * @param directory the file path where the database file is located, should be a .txt file
     * @return True if the import made any changes to the flagMap, False if not
     */
    public boolean importFlagsFromFile(String directory) throws FileNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        int oldLength = flagMap.size();
        File db  = new File(directory);
        Scanner scannie = new Scanner(db);
        scannie.nextLine(); // parses formatting guidelines line

        // declaring variables to be used in loop
        String[] rawLineData;
        Flag coloredFlag;

        while (scannie.hasNextLine()) {
            rawLineData = scannie.nextLine().toLowerCase().split(",");

            String color = rawLineData[0];
            // selects the right constructor based on the Flag color
            // loops through all different colors currently in FlagIndex
            for (String key : flagColors.keySet()) {
                // once algorithm finds database color in the Map, gets the constructor for that Flag
                if (key.equals(color)) {
                    // creates a new instance of that coloredFlag object (but treats it like a generic Flag)
                    coloredFlag = (Flag) flagColors.get(key).
                            getDeclaredConstructor(String.class, int.class).
                            newInstance(rawLineData[2], // creates object of ColoredFlag class
                                    Integer.parseInt(rawLineData[1])); // converts string to integer
                    // adds this new Flag to the FlagMap
                    addFlag(flagMap.size(), coloredFlag); // TODO replace this with a non-ID creating addFlag call
                    // stops searching
                    break;

                }
            }
        }

        return flagMap.size() > oldLength;
    }
}
