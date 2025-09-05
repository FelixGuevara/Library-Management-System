/**
 * Author: Felix Guevara
 * Course: [CEN-3024C-13950]
 * Date: September 4, 2025,
 * Class: LibraryManager.java
 *
 * This class manages a collection of Patron objects. It provides functionality
 * to add, remove, display, and load patrons from a file. It validation
 * methods for patron ID and overdue fines. This class serves as the core logic
 * handler for the Library Management System.
 */

package LMSApp;
import java.io.*;
import java.util.*;

public class LibraryManager {
    /**
     * Stores patrons using their ID as the key for quick lookup
     */
    private Map<String, Patron> patronList = new HashMap<>();

    /**
     * Method: addPatron
     * Purpose: Adds a new patron to the system after validating ID and fine.
     * Arguments: Patron patron - the patron object to be added
     * Return: boolean - true if added successfully, false otherwise
     */
    public boolean addPatron(Patron patron) {
        if (!isValidID(patron.getId()) || !isValidFine(patron.getOverdueFine())) {
            return false;
        }
        if (patronList.containsKey(patron.getId())) {
            System.out.println("Error: Duplicate ID.");
            return false;
        }
        patronList.put(patron.getId(), patron);
        System.out.println("Patron added successfully.");
        return true;
    }

    /**
     * Method: removePatron
     * Purpose: Removes a patron from the system using their ID.
     * Arguments: String id - the ID of the patron to be removed
     * Return: boolean - true if removed successfully, false if not found
     */
    public boolean removePatron(String id) {
        if (patronList.remove(id) != null) {
            System.out.println("Patron removed successfully.");
            return true;
        } else {
            System.out.println("Error: Patron not found.");
            return false;
        }
    }

    /**
     * Method: displayPatrons
     * Purpose: Displays all patrons currently stored in the system.
     * Arguments: None
     * Return: void
     */
    public void displayPatrons() {
        if (patronList.isEmpty()) {
            System.out.println("No patrons to display.");
        } else {
            patronList.values().forEach(System.out::println);
        }
    }

    /**
     * Method: loadFromFile
     * Purpose: Loads patron data from a file. Each line must follow the format: ID - Name - Address - Fine
     * Arguments: String path - the file path to load patron data from
     * Return: void
     */
    public void loadFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                if (parts.length != 4) {
                    System.out.println("Error: Invalid format.");
                    continue;
                }
                /* Extract and clean data */
                String id = parts[0].trim();
                String name = parts[1].trim();
                String address = parts[2].trim();
                double fine = Double.parseDouble(parts[3].trim());

                /* Create and add patron */
                Patron patron = new Patron(id, name, address, fine);
                addPatron(patron);
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    /**
     * Method: isValidID
     * Purpose: Validates that the ID is exactly 7 digits.
     * Arguments: String id - the ID to validate
     * Return: boolean - true if valid, false otherwise
     */
    public boolean isValidID(String id) {
        return id.matches("\\d{7}");
    }

    /**
     * Method: isValidFine
     * Purpose: Validates that the overdue fine is within the allowed range (0 to 250).
     * Arguments: double fine - the fine amount to validate
     * Return: boolean - true if valid, false otherwise
     */
    public boolean isValidFine(double fine) {
        return fine >= 0 && fine <= 250;
    }
}
