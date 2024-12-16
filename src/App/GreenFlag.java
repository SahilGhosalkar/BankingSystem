package App;

/**
 * Represents a GreenFlag, which is a specific type of Flag.
 * This class extends the {@link Flag} class and provides constructors
 * to create GreenFlag instances with a description and magnitude.
 */
public class GreenFlag extends Flag {

    /**
     * Constructs a GreenFlag with the specified description and magnitude.
     *
     * @param description A brief description of the GreenFlag.
     * @param mag         The magnitude associated with the GreenFlag.
     */
    public GreenFlag(String description, int mag) {
        // Call parent class constructor with "Green" as the color
        super("Green", description, mag);
    }

    /**
     * Constructs a GreenFlag with the specified description and a default magnitude of 10.
     *
     * @param description A brief description of the GreenFlag.
     */
    public GreenFlag(String description) {
        // Call parent class constructor with "Green" as the color and a default magnitude
        super("Green", description, 10);
    }

}
