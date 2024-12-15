package App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FlagIndex {
    private Map<Integer, Flag> flagMap;
    private String[] flagColors = new String[] {"green", "red"}; // supported flag colors

    public FlagIndex() {
        //map to store the ID-Flag pairs
        flagMap = new TreeMap<>();
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
    public boolean importFlagsFromFile(String directory) throws FileNotFoundException {
        int oldLength = flagMap.size();
        File db  = new File("src/App/FlagDatabase.txt");
        Scanner scannie = new Scanner(db);

        scannie.nextLine();
        String[] rawLineData;



        return flagMap.size() > oldLength;
    }
}
