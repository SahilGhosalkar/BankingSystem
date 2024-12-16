package App;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * The main application class for the Love Hospital simulation.
 * Provides a menu-driven interface for users to interact with their relationship status and flags.
 */
public class App {
    private Scanner scan = new Scanner(System.in); // Scanner for user input
    private RelationshipBar bar = new RelationshipBar(); // Relationship status tracker
    private FlagIndex index = new FlagIndex(); // Flag database for relationship flags
    private int flagIndex = 0; // Index for tracking flag additions
    private User user; // The user in the relationship
    private Person person = new Person(); // The person the user is in a relationship with
    private Relationship relationship; // The relationship between the user and the person

    /**
     * Displays the main menu and allows the user to interact with their relationship.
     * The menu offers options to update the relationship, see the current status, end the relationship, or exit.
     *
     * @throws FileNotFoundException if the flags database file is not found
     * @throws InvocationTargetException if there is an exception thrown during method invocation
     * @throws NoSuchMethodException if a method is not found
     * @throws InstantiationException if an exception occurs during object instantiation
     * @throws IllegalAccessException if there is illegal access to a method or constructor
     */
    public void showMenu() throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        boolean running = true; // Flag to control the menu loop
        index.importFlagsFromFile("src/App/FlagDatabase.txt"); // Import flag data from file

        System.out.println("Welcome to Love Hospital");
        System.out.println("Please enter some details about yourself");

        // Collect user details
        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.print("Age: ");
        int age = scan.nextInt();
        System.out.print("Gender: ");
        String gender = scan.next();
        System.out.print("Eye Color: ");
        String eyeColor = scan.next();
        System.out.print("Height (centimeters): ");
        int height = scan.nextInt();

        // Create a new user and relationship objects
        user = new User(name, eyeColor, age, gender, height);
        relationship = new Relationship(user, person, false, index);

        // Main menu loop
        while (running) {
            System.out.println("What would you like to do today?");
            System.out.println("1. Update Relationship");
            System.out.println("2. See Status");
            System.out.println("3. End Relationship");
            System.out.println("4. Exit");

            int choice = scan.nextInt();
            scan.nextLine(); // Consume the remaining newline character

            // Handle user choices
            switch (choice) {
                case 1:
                    updateRelationship(scan); // Update relationship flags
                    break;
                case 2:
                    System.out.println(bar.toString()); // Show relationship status
                    System.out.println(index.toString()); // Show flag index
                    checkForBreakUp(); // Check if breakup should be considered
                    break;
                case 3:
                    System.out.println("Broken up");
                    relationship.setPast(true); // Set relationship as past
                    break;
                case 4:
                    running = false; // Exit the loop
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Provides the user with options to update their relationship.
     * Users can either search for flags by keywords or add a new flag to the relationship.
     *
     * @param scan the scanner object to capture user input
     */
    private void updateRelationship(Scanner scan) {
        System.out.println("\nUpdate Relationship Options:");
        System.out.println("1. Search Flags by Keyword");
        System.out.println("2. Add Flag");

        int choice = scan.nextInt();
        scan.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                // Search flags by keywords
                System.out.println("Enter keywords: ");
                String keywords = scan.nextLine();
                System.out.println(index.searchFlags(keywords)); // Display search results
                break;
            case 2:
                // Add a new flag to the relationship
                System.out.print("What color is the flag: ");
                String color = scan.nextLine();
                System.out.println();

                System.out.print("What is the description: ");
                String description = scan.nextLine();
                System.out.println();

                System.out.println("What is the magnitude of the flag: ");
                int magnitude = scan.nextInt();
                System.out.println();

                // Add the flag based on the color
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
     * Checks the current relationship status and prompts the user to consider breaking up if the status is low.
     * If the relationship health is below a certain threshold, the user is asked if they want to end the relationship.
     */
    private void checkForBreakUp() {
        int threshold = 20; // Threshold for breakup consideration

        // If the current relationship status is below the threshold, prompt for breakup
        if (bar.getCurrentStatus() < threshold) {
            System.out.println("Your relationship status is quite low. Would you like to break up? (yes/no)");
            String answer = scan.nextLine().trim().toLowerCase();
            if (answer.equals("yes")) {
                String breakUpText = relationship.breakUpText(); // Generate breakup text
                System.out.println("\nSending the following breakup text:\n");
                System.out.println(breakUpText);
                relationship.updateStatus(); // Update relationship status to ended
            } else {
                System.out.println("Understood. You do you I suppose...");
            }
        }
    }

    /**
     * The main entry point of the application. Starts the application and shows the menu.
     *
     * @param args command-line arguments
     * @throws FileNotFoundException if the flags database file is not found
     * @throws InvocationTargetException if there is an exception thrown during method invocation
     * @throws NoSuchMethodException if a method is not found
     * @throws InstantiationException if an exception occurs during object instantiation
     * @throws IllegalAccessException if there is illegal access to a method or constructor
     */
    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        App theThing = new App();
        theThing.showMenu(); // Launch the menu
    }
}
