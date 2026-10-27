package SuperMarketTask;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Supermarket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double grandTotal = 0;

        // FILE HANDLING: Create a separate file for every bill
        File billFile = null;

        try {
            // Creates a unique bill file in the current working directory
            billFile = File.createTempFile("Bill_", ".txt", new File("."));

            System.out.println("New bill file created successfully!");
            System.out.println("File Name: " + billFile.getName());

            // Write the shopping session header
            try (PrintWriter writer = new PrintWriter(
                    new FileWriter(billFile))) {

                writer.println("================================");
                writer.println("     NEW SHOPPING SESSION");
                writer.println("================================");

            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
            sc.close();
            return;
        }

        String[] categories = {
            "Vegetables", "Fruits", "Dairy Products", "Snacks"
        };

        String[][] items = {
            {"Carrot", "Potato", "Tomato", "Onion", "Beans"},
            {"Apple", "Banana", "Orange", "Grapes", "Mango"},
            {"Milk", "Curd", "Butter", "Cheese", "Paneer"},
            {"Biscuit", "Chips", "Chocolate", "Cake", "Juice"}
        };

        double[][] prices = {
            {60, 40, 30, 50, 70},
            {180, 60, 80, 100, 120},
            {30, 40, 55, 100, 90},
            {20, 20, 40, 50, 30}
        };

        String[] units = {"kg", "kg", "unit", "unit"};

        System.out.println("================================");
        System.out.println("  WELCOME TO SUPER MARKET");
        System.out.println("================================");

        while (true) {

            System.out.println("\n------ MAIN MENU ------");

            for (int i = 0; i < categories.length; i++) {
                System.out.println((i + 1) + ". " + categories[i]);
            }

            System.out.println("5. Exit");
            System.out.print("Choose a category: ");

            int category = sc.nextInt();

            if (category == 5) {
                break;
            }

            if (category < 1 || category > 4) {
                System.out.println("Invalid category! Try again.");
                continue;
            }

            int index = category - 1;

            while (true) {

                System.out.println("\n--- " + categories[index] + " ---");

                for (int i = 0; i < 5; i++) {
                    System.out.println((i + 1) + ". "
                            + items[index][i] + " - Rs."
                            + prices[index][i] + " per " + units[index]);
                }

                System.out.println("6. Back to Main Menu");
                System.out.print("Choose an item: ");

                int choice = sc.nextInt();

                if (choice == 6) {
                    break;
                }

                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid item! Try again.");
                    continue;
                }

                int itemIndex = choice - 1;

                System.out.print("Enter quantity in "
                        + units[index] + ": ");

                double quantity = sc.nextDouble();

                if (quantity <= 0) {
                    System.out.println("Invalid quantity!");
                    continue;
                }

                // Calculate item amount
                double amount = prices[index][itemIndex] * quantity;

                // Update grand total
                grandTotal = grandTotal + amount;

                System.out.println("\nItem: "
                        + items[index][itemIndex]);

                System.out.println("Price: Rs."
                        + prices[index][itemIndex]);

                System.out.println("Quantity: " + quantity
                        + " " + units[index]);

                System.out.printf("Item Total: Rs.%.2f%n", amount);

                System.out.printf("Current Bill: Rs.%.2f%n",
                        grandTotal);

                // FILE HANDLING: Save the purchased item
                try (PrintWriter writer = new PrintWriter(
                        new FileWriter(billFile, true))) {

                    writer.println();
                    writer.println("Item: "
                            + items[index][itemIndex]);

                    writer.println("Category: "
                            + categories[index]);

                    writer.println("Price: Rs."
                            + prices[index][itemIndex]);

                    writer.println("Quantity: " + quantity
                            + " " + units[index]);

                    writer.printf("Item Total: Rs.%.2f%n", amount);

                    writer.printf("Current Bill: Rs.%.2f%n",
                            grandTotal);

                    writer.println("--------------------------------");

                    System.out.println("Item saved to file successfully!");

                } catch (IOException e) {
                    System.out.println("Error saving item: "
                            + e.getMessage());
                }

                System.out.println("\nAdd another item from "
                        + categories[index] + "?");

                System.out.println("1. Yes");
                System.out.println("2. No, go to Main Menu");

                System.out.print("Enter choice: ");

                int again = sc.nextInt();

                if (again != 1) {
                    break;
                }
            }
        }

        // Display final bill
        System.out.println("\n================================");
        System.out.println("       SUPERMARKET BILL");
        System.out.println("================================");

        System.out.printf("Grand Total: Rs.%.2f%n", grandTotal);

        System.out.println("Thank you for shopping!");

        System.out.println("================================");

        // FILE HANDLING: Save the final bill to the same file
        try (PrintWriter writer = new PrintWriter(
                new FileWriter(billFile, true))) {

            writer.println();
            writer.println("================================");
            writer.println("       SUPERMARKET BILL");
            writer.println("================================");

            writer.printf("Grand Total: Rs.%.2f%n", grandTotal);

            writer.println("Thank you for shopping!");

            writer.println("================================");
            writer.println("Shopping session completed.");

            System.out.println("Final bill saved successfully!");
            System.out.println("File Name: " + billFile.getName());
            System.out.println("File Location: "
                    + billFile.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Error saving final bill: "
                    + e.getMessage());
        }

        sc.close();
    }
}
