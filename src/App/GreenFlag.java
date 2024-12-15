package App;

import App.Flag;

public class GreenFlag extends Flag {

    // Constructor for App.RedFlag
    public GreenFlag(String description, int mag) {
        // Call parent class constructor with "Red" as the color
        super("Green", description, mag);
    }

    public GreenFlag(String description) {
        // Call parent class constructor with "Red" as the color
        super("Green", description, 10);
    }

}
