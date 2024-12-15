package App;

import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class FlagIndex {
    private Map<Integer, Flag> flagMap;

    public FlagIndex() {
        //map to store the ID-Flag pairs
        flagMap = new HashMap<>();
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
}
