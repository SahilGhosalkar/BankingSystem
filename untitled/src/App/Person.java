package App;

public class Person {
    private String name;
    private String eyeColor;
    private int heightInches;
    private String gender;
    private int age;

    // Constructor to initialize the fields
    public Person(String name, String eyeColor, int heightInches, String gender, int age) {
        this.name = name;
        this.eyeColor = eyeColor;
        this.heightInches = heightInches;
        this.gender = gender;
        this.age = age;
    }

    public Person() {
        this.name = "NO_NAME_SAVED";
        this.eyeColor = "NO_EYE_COLOR_SAVED";
        this.heightInches = -1;
        this.gender = "NO_GENDER_SAVED";
        this.age = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public int getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(int heightInches) {
        this.heightInches = heightInches;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return name + " is " + age + " years old with, " + eyeColor + " eyes, is " + heightInches + " inches tall, and is a " + gender;
    }


}
