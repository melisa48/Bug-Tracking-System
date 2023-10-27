import java.util.ArrayList;
import java.util.Scanner;

class Bug {
    private int id;
    private String description;
    private boolean isOpen;

    public Bug(int id, String description) {
        this.id = id;
        this.description = description;
        this.isOpen = true;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void closeBug() {
        isOpen = false;
    }

    @Override
    public String toString() {
        return "Bug ID: " + id + ", Description: " + description + ", Status: " + (isOpen ? "Open" : "Closed");
    }
}

class BugTracker {
    private ArrayList<Bug> bugs;
    private int bugIdCounter;

    public BugTracker() {
        bugs = new ArrayList<>();
        bugIdCounter = 1;
    }

    public void addBug(String description) {
        Bug bug = new Bug(bugIdCounter++, description);
        bugs.add(bug);
    }

    public void viewBugs() {
        if (bugs.isEmpty()) {
            System.out.println("No bugs to display.");
        } else {
            for (Bug bug : bugs) {
                System.out.println(bug);
            }
        }
    }

    public void closeBug(int bugId) {
        for (Bug bug : bugs) {
            if (bug.getId() == bugId && bug.isOpen()) {
                bug.closeBug();
                System.out.println("Bug " + bugId + " closed.");
                return;
            }
        }
        System.out.println("Bug " + bugId + " not found or already closed.");
    }
}

public class Main {
    public static void main(String[] args) {
        BugTracker bugTracker = new BugTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Bug Tracking System =====");
            System.out.println("1. Add Bug");
            System.out.println("2. View Bugs");
            System.out.println("3. Close Bug");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter bug description: ");
                    String description = scanner.nextLine();
                    bugTracker.addBug(description);
                    break;
                case 2:
                    bugTracker.viewBugs();
                    break;
                case 3:
                    System.out.print("Enter bug ID to close: ");
                    int bugId = scanner.nextInt();
                    bugTracker.closeBug(bugId);
                    break;
                case 4:
                    System.out.println("Exiting Bug Tracking System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
