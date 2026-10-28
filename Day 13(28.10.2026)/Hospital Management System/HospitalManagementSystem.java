package jdbc;

import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {

    // Database connection details
    static final String URL =
            "jdbc:mysql://localhost:3306/hospital_db";

    static final String USERNAME = "root";
    static final String PASSWORD = "kanishkar123456";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = DriverManager.getConnection(
                URL, USERNAME, PASSWORD)) {

            System.out.println("================================");
            System.out.println("   HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("================================");

            // Create table automatically
            createTable(con);

            
            int choice = 0;

            do {
                System.out.println("\n----- MAIN MENU -----");
                System.out.println("1. Add Patient");
                System.out.println("2. View All Patients");
                System.out.println("3. Update Patient");
                System.out.println("4. Delete Patient");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");

                try {
                    choice = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                    choice = 0;
                    continue;
                }

                try {
                    switch (choice) {

                        case 1:
                            addPatient(con, sc);
                            break;

                        case 2:
                            viewPatients(con);
                            break;

                        case 3:
                            updatePatient(con, sc);
                            break;

                        case 4:
                            deletePatient(con, sc);
                            break;

                        case 5:
                            System.out.println(
                                    "Thank you for using the system!"
                            );
                            break;

                        default:
                            System.out.println(
                                    "Invalid choice! Select 1 to 5."
                            );
                    }
                } catch (NumberFormatException e) {
                    System.out.println(
                            "Invalid input! Please enter numbers correctly."
                    );
                } catch (SQLException e) {
                    System.out.println(
                            "Database operation failed: " + e.getMessage()
                    );
                }

            } while (choice != 5);

        } catch (SQLException e) {
            System.out.println(
                    "Database connection error: " + e.getMessage()
            );
        }

        sc.close();
    }

    // Create the patients table
    public static void createTable(Connection con)
            throws SQLException {

        String sql = """
                CREATE TABLE IF NOT EXISTS patients (
                    id INT PRIMARY KEY,
                    name VARCHAR(100) NOT NULL,
                    age INT,
                    gender VARCHAR(10),
                    disease VARCHAR(100),
                    phone VARCHAR(15)
                )
                """;

        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
        }
    }

    // CREATE: Add a patient
    public static void addPatient(Connection con, Scanner sc)
            throws SQLException {

        System.out.println("\n--- ADD PATIENT ---");

        System.out.print("Enter Patient ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(sc.nextLine().trim());

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine().trim();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine().trim();

        String sql = """
                INSERT INTO patients
                (id, name, age, gender, disease, phone)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, gender);
            ps.setString(5, disease);
            ps.setString(6, phone);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient added successfully!");
            }
        }
    }

    // READ: View all patients
    public static void viewPatients(Connection con)
            throws SQLException {

        System.out.println("\n--- PATIENT DETAILS ---");

        String sql = "SELECT * FROM patients ORDER BY id";

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("---------------------------");
                System.out.println("Patient ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Disease: " + rs.getString("disease"));
                System.out.println("Phone: " + rs.getString("phone"));
            }

            if (!found) {
                System.out.println("No patient records found.");
            }
        }
    }

 
 // UPDATE: Update only the selected patient detail
 public static void updatePatient(Connection con, Scanner sc)
         throws SQLException {

     System.out.println("\n--- UPDATE PATIENT ---");

     System.out.print("Enter Patient ID to update: ");
     int id = Integer.parseInt(sc.nextLine().trim());

     // Check whether the patient exists
     String checkSql = "SELECT * FROM patients WHERE id = ?";

     try (PreparedStatement checkPs = con.prepareStatement(checkSql)) {

         checkPs.setInt(1, id);

         try (ResultSet rs = checkPs.executeQuery()) {

             if (!rs.next()) {
                 System.out.println("Patient ID not found.");
                 return;
             }

             System.out.println("\nPatient Found!");
             System.out.println("1. Update Name");
             System.out.println("2. Update Age");
             System.out.println("3. Update Gender");
             System.out.println("4. Update Disease");
             System.out.println("5. Update Phone Number");

             System.out.print("What do you want to update? ");
             int choice = Integer.parseInt(sc.nextLine().trim());

             String sql = "";
             String columnName = "";

             switch (choice) {

                 case 1:
                     sql = "UPDATE patients SET name = ? WHERE id = ?";
                     columnName = "Name";
                     break;

                 case 2:
                     sql = "UPDATE patients SET age = ? WHERE id = ?";
                     columnName = "Age";
                     break;

                 case 3:
                     sql = "UPDATE patients SET gender = ? WHERE id = ?";
                     columnName = "Gender";
                     break;

                 case 4:
                     sql = "UPDATE patients SET disease = ? WHERE id = ?";
                     columnName = "Disease";
                     break;

                 case 5:
                     sql = "UPDATE patients SET phone = ? WHERE id = ?";
                     columnName = "Phone Number";
                     break;

                 default:
                     System.out.println("Invalid choice! Select 1 to 5.");
                     return;
             }

             System.out.print("Enter new " + columnName + ": ");
             String newValue = sc.nextLine().trim();

             try (PreparedStatement ps = con.prepareStatement(sql)) {

                 // Age must be stored as an integer
                 if (choice == 2) {
                     ps.setInt(1, Integer.parseInt(newValue));
                 } else {
                     ps.setString(1, newValue);
                 }

                 ps.setInt(2, id);

                 int rows = ps.executeUpdate();

                 if (rows > 0) {
                     System.out.println(
                             columnName + " updated successfully!"
                     );
                 } else {
                     System.out.println("Update failed.");
                 }
             }
         }
     }
 }
 

    // DELETE: Delete a patient
    public static void deletePatient(Connection con, Scanner sc)
            throws SQLException {

        System.out.println("\n--- DELETE PATIENT ---");

        System.out.print("Enter Patient ID to delete: ");
        int id = Integer.parseInt(sc.nextLine().trim());

        String sql = "DELETE FROM patients WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Patient deleted successfully!");
            } else {
                System.out.println("Patient ID not found.");
            }
        }
    }
}
