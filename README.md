# Library Management System (LMS)

## 📘 Project Overview

The Library Management System (LMS) is a console-based Java application developed by Felix Guevara. It allows library staff to manage patron records efficiently by providing features such as adding, removing, displaying, searching, and loading patrons from a file. The system enforces input constraints and provides error handling to ensure data integrity.

## Features

- Add new patrons with validation
- Remove patrons by ID
- Display all patrons
- Load patrons from a formatted text file
- Search patrons by ID, name, or fine range
- Input validation and error handling
- Console-based user interface

## Technologies Used

- Java SE 17+
- IntelliJ IDEA 2025
- Standard Java libraries (java.util, java.io)

## Setup Instructions

1. Open IntelliJ IDEA 2025.
2. Create a new Java project or import the existing source files:
   - `Patron.java`
   - `LibraryManager.java`
   - `LMSApp.java`
3. Ensure Java SDK 17 or later is configured.
4. Place any patron data files (e.g., `patrons.txt`) in the project directory.
5. Run `LMSApp.java` to launch the application.

##  Usage

- Follow the on-screen menu to add, remove, display, or search patrons.
- Use the "Load Patrons from File" option to bulk import patrons from a file.
- Input constraints:
  - Patron ID must be exactly 7 digits.
  - Overdue fine must be between 0 and 250.

## 👤 Author

**Felix Guevara**  
Date: September 4, 2025  
Course: [Your Course Name]

---

