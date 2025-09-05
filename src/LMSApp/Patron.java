/**
 * Author: Felix Guevara
 * Course: [CEN-3024C-13950]
 * Date: September 4, 2025,
 * Class: Patron.java
 *
 * This class represents a library patron. It stores personal information such as
 * ID, name, address, and overdue fine. It provides accessor and mutator methods
 * for each field. This class is used by the LibraryManager to manage patron records.
 */

package LMSApp;

public class Patron {

    /* Unique 7-digit ID for the patron */
    private String id;

    /* Patron's full name */
    private String name;

    /* Patron's residential address */
    private String address;

    /* Amount of overdue fine owed by the patron */
    private double overdueFine;

    /**
     * Method: Patron (Constructor)
     * Purpose: Initializes a new Patron object with provided details.
     * Arguments: String id, String name, String address, double overdueFine
     * Return: None
     */
    public Patron(String id, String name, String address, double overdueFine) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.overdueFine = overdueFine;
    }

    /* Getters */
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getOverdueFine() {
        return overdueFine;
    }

    /* Setters */
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOverdueFine(double overdueFine) {
        this.overdueFine = overdueFine;
    }

    /** Method: toString
     * Purpose: Returns a formatted string representation of the patron.
     * Arguments: None
     * Return: String
     */
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Address: %s | Fine: $%.2f", id, name, address, overdueFine);
    }
}


