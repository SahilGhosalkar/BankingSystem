package App;

/**
 * Represents a Person with various attributes such as name, eye color,
 * height, gender, and age. Provides methods to get and set these attributes.
 */
public class Person {
    private String name;
    private String eyeColor;
    private int heightInches;
    private String gender;
    private int age;

    /**
     * Constructs a Person with the specified attributes.
     *
     * @param name         The name of the person.
     * @param eyeColor     The eye color of the person.
     * @param heightInches The height of the person in inches.
     * @param gender       The gender of the person.
     * @param age          The age of the person.
     */
    public Person(String name, String eyeColor, int heightInches, String gender, int age) {
        this.name = name;
        this.eyeColor = eyeColor;
        this.heightInches = heightInches;
        this.gender = gender;
        this.age = age;
    }

    /**
     * Constructs a Person with default placeholder values.
     */
    public Person() {
        this.name = "NO_NAME_SAVED";
        this.eyeColor = "NO_EYE_COLOR_SAVED";
        this.heightInches = -1;
        this.gender = "NO_GENDER_SAVED";
        this.age = -1;
    }

    /**
     * Gets the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name The new name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the eye color of the person.
     *
     * @return The eye color of the person.
     */
    public String getEyeColor() {
        return eyeColor;
    }

    /**
     * Sets the eye color of the person.
     *
     * @param eyeColor The new eye color of the person.
     */
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Gets the height of the person in inches.
     *
     * @return The height of the person in inches.
     */
    public int getHeightInches() {
        return heightInches;
    }

    /**
     * Sets the height of the person in inches.
     *
     * @param heightInches The new height of the person in inches.
     */
    public void setHeightInches(int heightInches) {
        this.heightInches = heightInches;
    }

    /**
     * Gets the gender of the person.
     *
     * @return The gender of the person.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the person.
     *
     * @param gender The new gender of the person.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the person.
     *
     * @param age The new age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns a string representation of the person, summarizing their attributes.
     *
     * @return A formatted string describing the person.
     */
    @Override
    public String toString() {
        return name + " is " + age + " years old and has " + eyeColor + " eyes, is "
                + heightInches + " inches tall, and is a " + gender;
    }
}
