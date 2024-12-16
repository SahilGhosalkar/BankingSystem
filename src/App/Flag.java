package App;

/**
 * Abstract class representing a flag in a relationship.
 * A flag can be a "red flag" or a "green flag", each with a color, description, and impact value.
 * This class is extended by more specific flag types such as `GreenFlag` and `RedFlag`.
 */
public abstract class Flag {
    private String color; // The color of the flag (e.g., red, green, etc.)
    private String description; // The description of the flag
    private int impact; // The impact of the flag on the relationship

    /**
     * Constructor to initialize a flag with a specific color, description, and impact.
     *
     * @param color the color of the flag (e.g., "red", "green")
     * @param description a short description of the flag's significance
     * @param imp the impact value of the flag; positive for positive flags (e.g., green), negative for negative flags (e.g., red)
     */
    public Flag(String color, String description, int imp) {
        this.color = color.toLowerCase(); // Convert color to lowercase to standardize input
        this.description = description;
        this.impact = imp;
    }

    /**
     * Default constructor that initializes the flag with default values.
     * The default flag is white, with no description, and an impact of 0.
     */
    public Flag() {
        color = "white";
        description = "N/A";
        impact = 0;
    }

    /**
     * Gets the impact value of the flag.
     *
     * @return the impact of the flag, which can affect the relationship's health
     */
    public int getImpact() {
        return impact;
    }

    /**
     * Sets the impact value of the flag.
     *
     * @param imp the new impact value to set
     */
    public void setImpact(int imp) {
        this.impact = imp;
    }

    /**
     * Gets the color of the flag.
     *
     * @return the color of the flag
     */
    public String getColor() {
        return color;
    }

    /**
     * Gets the description of the flag.
     *
     * @return the description of the flag
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns a string representation of the flag, including its color, description, and impact.
     *
     * @return a string representation of the flag
     */
    @Override
    public String toString() {
        // Simplified single-line format for displaying the flag's properties
        return "Color: " + color + ", Description: " + description + ", Impact: " + impact;
    }
}
