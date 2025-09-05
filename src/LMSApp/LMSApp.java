/**
 * Author: Felix Guevara
 * Course: [CEN-3024C-13950]
 * Date: September 4, 2025,
 * Class: LMSApp.java
 *
 * This is the main class of the Library Management System program.
 * It provides a console-based interface for users to interact with the system.
 * Users can add, remove, display, and load patrons from a file.
 * The program demonstrates basic file I/O, object-oriented design, and input validation.
 */

package LMSApp;
import java.util.Scanner;

public class LMSApp {
    /**
     * Create an instance of LibraryManager object to manage patrons
     */
    private static LibraryManager manager = new LibraryManager();
    /**
     * the Scanner instance for reading user input from the console
     */
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Method: main
     * Purpose: Entry point of the program. Starts the menu loop.
     * Arguments: String[] args - command-line arguments (not used)
     * Return: void
     */
    public static void main(String[] args) {
        /* Start the application by showing the menu */
        showMenu();
    }

    /**
     * Method: showMenu
     * Purpose: Displays the main menu and handles user input in a loop.
     * Arguments: None
     * Return: void
     */
    public static void showMenu() {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Patron");
            System.out.println("2. Remove Patron");
            System.out.println("3. Display Patrons");
            System.out.println("4. Load Patrons from File");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            handleUserInput(choice);
        }
    }

    /**
     * Method: handleUserInput
     * Purpose: Executes the appropriate action based on user menu selection.
     * Arguments: String choice - the user's selected menu option
     * Return: void
     */
    public static void handleUserInput(String choice) {
        switch (choice) {
            case "1":
                /* Add a new patro */
                Patron patron = getPatronFromInput();
                manager.addPatron(patron);
                break;
            case "2":
                /* Remove a patron by ID */
                System.out.print("Enter Patron ID to remove: ");
                String id = scanner.nextLine();
                manager.removePatron(id);
                break;
            case "3":
                /* Display all patrons */
                manager.displayPatrons();
                break;
            case "4":
                /* Load patrons from a file */
                System.out.print("Enter file path: ");
                String path = scanner.nextLine();
                manager.loadFromFile(path);
                break;
            case "5":
                /* Exit the application */
                System.out.println("Exiting system.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    /**
     * Method: getPatronFromInput
     * Purpose: Collects patron details from user input and creates a Patron object.
     * Arguments: None
     * Return: Patron - a new Patron object with user-provided data
     */
    public static Patron getPatronFromInput() {
        System.out.print("Enter 7-digit ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Overdue Fine (0 - 250): ");
        double fine = Double.parseDouble(scanner.nextLine());

        return new Patron(id, name, address, fine);
    }
}