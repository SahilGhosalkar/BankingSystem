package App;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class App {
    private Scanner scan = new Scanner(System.in);
    private RelationshipBar bar = new RelationshipBar();
    private FlagIndex index = new FlagIndex();
    private int flagIndex = 0;
    private User user;
    private Person person = new Person();
    private Relationship relationship;

    public void showMenu() throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        boolean running = true;
        index.importFlagsFromFile("src/App/FlagDatabase.txt");


        System.out.println("Welcome to Love Hopital");
        System.out.println("Please enter some details about yourself");
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Age: ");
        int age = scan.nextInt();
        System.out.print("Gender: ");
        String gender = scan.next();
        System.out.print("Eye Color: ");
        String eyeColor = scan.next();
        System.out.print("Height: ");
        int height = scan.nextInt();
        user = new User(name, eyeColor, age, gender, height);
        relationship = new Relationship(user, person, false, index);

        while (running) {
            System.out.println("What would you like to do today?");
            System.out.println("1. Update Relationship");
            System.out.println("2. See Status");
            System.out.println("3. End Relationship");
            System.out.println("4. Exit");

            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    updateRelationship(scan);
                    break;
                case 2:
                    System.out.println(bar.toString());
                    System.out.println(index.toString());
                    checkForBreakUp();
                    break;
                case 3:
                    System.out.println("Broken up");
                    relationship.setPast(true);
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    private void updateRelationship(Scanner scan) {
        System.out.println("\nUpdate Relationship Options:");
        System.out.println("1. Search Flags by Keyword");
        System.out.println("2. Add Flag");

        int choice = scan.nextInt();
        scan.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("Enter keywords: ");
                String keywords = scan.nextLine();
                System.out.println(index.searchFlags(keywords));
                break;
            case 2:
                System.out.print("What color is the flag: ");
                String color = scan.nextLine();
                System.out.println();

                System.out.print("What is the description: ");
                String description = scan.nextLine();
                System.out.println();

                System.out.println("What is the magnitude of the flag: ");
                int magnitude = scan.nextInt();
                System.out.println();

                if (color.toLowerCase().equals("green")) {
                    index.addFlag(flagIndex, new GreenFlag(description, magnitude));
                    relationship.addFlagToRelationship(new RedFlag(description, -magnitude));
                    bar.addFlagImpact(new GreenFlag(description, magnitude));
                    flagIndex++;
                    System.out.println("Flag added");
                } else if (color.toLowerCase().equals("red")) {
                    index.addFlag(flagIndex, new RedFlag(description, -magnitude));
                    relationship.addFlagToRelationship(new RedFlag(description, -magnitude));
                    bar.addFlagImpact(new RedFlag(description, -magnitude));
                    flagIndex++;
                    System.out.println("Flag added");
                } else {
                    System.out.println("Invalid flag color. Returning to menu.");
                }
                break;

            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }

    /**
     * Checks the relationship's current status. If it's below a certain threshold,
     * prompts the user to consider ending the relationship.
     */
    private void checkForBreakUp() {
        //if relationship health less than 20 will prompt for breakup
        int threshold = 20;
        if (bar.getCurrentStatus() < threshold) {
            System.out.println("Your relationship status is quite low. Would you like to break up? (yes/no)");
            String answer = scan.nextLine().trim().toLowerCase();
            if (answer.equals("yes")) {
                String breakUpText = relationship.breakUpText(); // TODO need to update in the loop the "current relationship editting'
                System.out.println("\nSending the following breakup text:\n");
                System.out.println(breakUpText);
                relationship.updateStatus();

            } else {
                System.out.println("Understood. You do you I suppose...");
            }
        }
    }



    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        App theThing = new App();
        theThing.showMenu();
    }
}
