abstract class Flag {
    private String color;
    private String description;

    private int magnitude;

    // Constructor to initialize color and description
    public Flag(String color, String description, int mag) {
        this.color = color;
        this.description = description;
        this.magnitude = mag;
    }

    public Flag(){
        color = "white";
        description = "N/A";
        magnitude = 0;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(int mag) {
        magnitude = mag;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    // toString method to display color and description
    @Override
    public String toString() {
        return "Color: " + color + "; \nDescription: " + description;
    }
}

