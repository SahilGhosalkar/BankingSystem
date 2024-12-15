package App;

import java.lang.reflect.Array;
import java.util.*;

public class FlagIndex {
    private Map<Integer, Flag> flagMap;

    ArrayList<String> fillerWords = new ArrayList<String>(List.of("the and a to me you".split(" ")));

    private Map<Integer, String[]> flagTokenizedMap; // stores flag descriptions for ease of searching


    public FlagIndex() {
        //map to store the ID-Flag pairs
        flagMap = new TreeMap<>();

        flagTokenizedMap = new TreeMap<>();

    }


    //Adds a Flag to the index with ID
    public void addFlag(int id, Flag flag) {
        flagMap.put(id, flag);

        String[] splitRaw = flag.getDescription().split(" ");
        String[] tokenizedDescription = new String[splitRaw.length];

        for (int i = 0; i < splitRaw.length; i++) {
            if (!fillerWords.contains(splitRaw[i])) {
                tokenizedDescription[i] = splitRaw[i];
            }
        }
        flagTokenizedMap.put(id, processTextInput(flag.getDescription()));


    }

     //Removes the Flag associated with the given ID.
    public boolean removeFlag(int id) {
        return flagMap.remove(id) != null && flagTokenizedMap.remove(id) != null;
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
     * Helper method for searching. Reduces an input string into its keywords
     * @param textWithFillers original string, potentially containing filler words
     * @return String array that contains only keywords. Array length is number of words in original string.
     * Spots of non-keywords are denoted by null
     */
    private String[] processTextInput(String textWithFillers) {

        String[] splitRaw = textWithFillers.toLowerCase().split(" ");
        String[] tokenizedDescription = new String[splitRaw.length];

        for (int i = 0; i < splitRaw.length; i++) {
            if (!fillerWords.contains(splitRaw[i])) {
                tokenizedDescription[i] = splitRaw[i];
            }
        }

        return tokenizedDescription;
    }

    /***
     * Helper method. Searches through provided scope of FlagIndex for flags whose descriptions have a word in common with the
     * keywords from the search query
     * @param potentialIDS Set of Flag IDS to perform search through
     * @param query String containing space-seperated keywords to search flags for. Filler words will be processed + removed
     * @return Set of all Flag IDS from scope that match search query
     */
    private TreeSet<Integer> searchFlagsFromSet(Set<Integer> potentialIDS, String query) {
        TreeSet<Integer> flagIDS = new TreeSet<>();

        ArrayList<String> keyWords = new ArrayList<>(Arrays.asList(processTextInput(query))); // converts to ArrayList
        for (Integer key : potentialIDS) {
            String[] splitFlagWords = flagTokenizedMap.get(key); // gets keywords for a Flag ID

            // loops through all viable words in the description of the Flag
            for (String flagWord : splitFlagWords) {
                // adds the Flag ID to returned Set if one of the keywords match, then stops searching through word
                if (keyWords.contains(flagWord)) {
                    flagIDS.add(key);
                    break;
                }
            }
        }
        return flagIDS;
    }



    /***
     * Searches through FlagIndex for flags that match a specific search query.
     * @param query String containing space-seperated keywords to search flags for. Filler words will be processed + removed
     * @return Set of all Flag IDS that match search query
     */
    public TreeSet<Integer> searchFlags(String query) {
        // returns Flag IDS that match the query from all Flag list
        return searchFlagsFromSet(flagTokenizedMap.keySet(), query);

    }


    //oooh another todo is tostring for regualr


    /***
     * Searches through FlagIndex for flags of specific colors that match a specific search query.
     * @param query String containing space-seperated keywords to search flags for. Filler words will be processed + removed
     * @param colorFilters Array of Flag colors to limit Flag results to
     * @return Set of all Flag IDS that match search query and adhere to filter
     */
    public TreeSet<Integer> searchFlags(String query, ArrayList<String> colorFilters) {
        TreeSet<Integer> potentialIDS = new TreeSet<>();
        for (int i = 0; i < colorFilters.size(); i++) {
            colorFilters.set(i, colorFilters.get(i).toLowerCase());
        }
        // searches through all flags and adds the ones that match the color filters specified by user
        for (Integer ID : flagMap.keySet()) {
            if (colorFilters.contains(flagMap.get(ID).getColor())) {
                potentialIDS.add(ID);
            }
        }
        // returns flag IDS that are in potential IDS and match the query
        return searchFlagsFromSet(potentialIDS, query);
    }
}
