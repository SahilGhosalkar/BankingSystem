abstract class Flag {
    private String color;
    private String description;

    private int magnitude;

    // Constructor to initialize color and description
    public Flag(String color, String description) {
        this.color = color;
        this.description = description;
        magnitude = 5;
    }

    // Getter for color
    public String getColor() {
        return color;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // toString method to display color and description
    @Override
    public String toString() {
        return "Color: " + color + "; \nDescription: " + description;
    }
}

