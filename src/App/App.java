package App;
import java.util.*;

public class App {

public void showMenu() {
    Scanner scan = new Scanner(System.in);
    boolean running = true;

    while (running) {
        System.out.println("\nHello! Welcome to Love Hospital!");
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
                //seeStatus();
                break;
            case 3:
                //endRelationship();
                break;
            case 4:
                running = false;
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    scan.close();
}

    private void updateRelationship(Scanner scan) {
        System.out.println("\nUpdate Relationship Options:");
        System.out.println("1. Search Flags by Keyword");
        System.out.println("2. Update with Flag ID");

        int choice = scan.nextInt();
        scan.nextLine(); // Consume newline

        switch (choice) {
            case 1:

                //searchFlags
                break;
            case 2:
                //update
            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }



    public static void main(String[] args) {
        App theThing = new App();
        Scanner scan = new Scanner(System.in);

       theThing.showMenu();



    }
}
