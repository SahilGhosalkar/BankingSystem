package App;

import App.Flag;

public class RedFlag extends Flag {

    // Constructor for App.RedFlag
    public RedFlag(String description, int mag) {
        // Call parent class constructor with "Red" as the color
        super("Red", description, mag);
    }

    public RedFlag(String description) {
        // Call parent class constructor with "Red" as the color
        super("Red", description, -10);
    }

}
