package App;

import App.Flag;

/**
 * Represents a RedFlag, which is a specific type of Flag.
 * This class extends the {@link Flag} class and provides constructors
 * to create RedFlag instances with a description and magnitude.
 */
public class RedFlag extends Flag {

    /**
     * Constructs a RedFlag with the specified description and magnitude.
     *
     * @param description A brief description of the RedFlag.
     * @param mag         The magnitude associated with the RedFlag.
     */
    public RedFlag(String description, int mag) {
        // Call parent class constructor with "Red" as the color
        super("Red", description, mag);
    }

    /**
     * Constructs a RedFlag with the specified description and a default magnitude of -10.
     *
     * @param description A brief description of the RedFlag.
     */
    public RedFlag(String description) {
        // Call parent class constructor with "Red" as the color and a default magnitude
        super("Red", description, -10);
    }

}
