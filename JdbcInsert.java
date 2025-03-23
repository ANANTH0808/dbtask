package task11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsert {
    public static void main(String[] args) {
    	 // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/EmployeeeDB"; // Change if necessary
        String user = "root"; // Your MySQL username
        String password = "root"; // Your MySQL password

        // SQL Insert Query
        String query = "INSERT INTO Employee (empcode, empname, empage, esalary) VALUES (?, ?, ?, ?)";

        // Employee data (Corrected: Now using String for empname)
        Object[][] employees = {
            {101, "Jenny", 25, 10000},
            {102, "Jacky", 30, 20000},
            {103, "Joe", 20, 40000},
            {104, "John", 40, 80000},
            {105, "Shameer", 25, 90000}
        };

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to MySQL database!");

            // Prepare Statement
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Insert Data
            for (Object[] emp : employees) {
                pstmt.setInt(1, (int) emp[0]);      
                pstmt.setString(2, (String) emp[1]); 
                pstmt.setInt(3, (int) emp[2]);      
                pstmt.setInt(4, (int) emp[3]);            
                pstmt.executeUpdate();
            }

            System.out.println("Data inserted successfully!");

            // Close resources
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}