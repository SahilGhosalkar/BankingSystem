package App;

public abstract class Flag{
    private String color;
    private String description;

    private int impact;

    // Constructor to initialize color and description
    public Flag(String color, String description, int imp) {
        this.color = color.toLowerCase();
        this.description = description;
        this.impact = imp;
    }

    public Flag(){
        color = "white";
        description = "N/A";
        impact = 0;
    }

    public int getImpact() {
        return impact;
    }

    public void setImpact(int imp) {
        impact = imp;
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
        // Simplified single-line format
        return "Color: " + color + ", Description: " + description + ", Impact: " + impact;
    }

}