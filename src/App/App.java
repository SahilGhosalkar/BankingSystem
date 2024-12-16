package App;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class App {
    private Scanner scan = new Scanner(System.in);
    private RelationshipBar bar = new RelationshipBar();
    private FlagIndex index = new FlagIndex();
    private int flagIndex = 0;

public void showMenu() throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

    boolean running = true;
    index.importFlagsFromFile("src/App/FlagDatabase.txt");

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
                System.out.println(bar.toString());
                System.out.println(index.toString());
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

                if(color.toLowerCase().equals("green")){
                    index.addFlag(flagIndex, new GreenFlag(description, magnitude));
                    bar.addFlagImpact(new GreenFlag(description, magnitude));
                }
                if(color.toLowerCase().equals("red")){
                    index.addFlag(flagIndex, new RedFlag(description, -magnitude));
                    bar.addFlagImpact(new RedFlag(description, -magnitude));
                }
                else{
                    System.out.println("huh");
                    break;
                }

                flagIndex++;
                System.out.println("Flag added");
                break;

            default:
                System.out.println("Invalid choice. Returning to main menu.");
        }
    }



    public static void main(String[] args) throws FileNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        App theThing = new App();
        Scanner scan = new Scanner(System.in);

       theThing.showMenu();



    }
}
