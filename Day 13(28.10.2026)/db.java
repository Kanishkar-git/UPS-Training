package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class db {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/demo";
        String username = "root";
        String password = "kanishkar123456";

        String createTable = "CREATE TABLE IF NOT EXISTS students ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "name VARCHAR(100) NOT NULL, "
                + "department VARCHAR(50), "
                + "age INT"
                + ")";

        String insertData = "INSERT INTO students (name, department, age) "
                + "VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(
                    url, username, password);
             Statement stmt = con.createStatement()) {

            System.out.println("MySQL Connected Successfully!");

            
            stmt.executeUpdate(createTable);

            System.out.println("Table created successfully!");

           
            try (PreparedStatement ps = con.prepareStatement(insertData)) {

                ps.setString(1, "Kanishkar");
                ps.setString(2, "CSE");
                ps.setInt(3, 20);

                int rows = ps.executeUpdate();

                System.out.println(rows + " record inserted successfully!");
            }

       
            String selectData = "SELECT * FROM students";

            try (ResultSet rs = stmt.executeQuery(selectData)) {

                System.out.println("\nStudent Records:");
                System.out.println("--------------------------------");

                while (rs.next()) {

                    System.out.println("ID: " + rs.getInt("id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Department: "
                            + rs.getString("department"));
                    System.out.println("Age: " + rs.getInt("age"));

                    System.out.println("--------------------------------");
                }
            }

        } catch (SQLException e) {

            System.out.println("Database Operation Failed!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}
