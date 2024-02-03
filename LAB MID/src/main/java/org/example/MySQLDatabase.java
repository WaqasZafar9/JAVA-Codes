package org.example;

import java.sql.*;

public class MySQLDatabase {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/labmid";
        String user = "root";
        String password = "Codebro9801";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {


            stmt.executeUpdate("INSERT INTO LMS(name, ID) VALUES ('WAQAS', '38606')");
            System.out.println("Data inserted successfully.");


            ResultSet resultSet = stmt.executeQuery("SELECT * FROM LMS");
            while (resultSet.next()) {
                System.out.println("name: " + resultSet.getString("name") +
                        ", ID: " + resultSet.getString("ID"));
            }


            stmt.executeUpdate("UPDATE LMS SET name = 'ALYAN' WHERE ID = '38603'");
            System.out.println("Data updated successfully.");


            stmt.executeUpdate("DELETE FROM LMS WHERE name = 'ALYAN'");
            System.out.println("Data deleted successfully.");

            ResultSet updatedResultSet = stmt.executeQuery("SELECT * FROM LMS");
            while (updatedResultSet.next()) {
                System.out.println("name: " + updatedResultSet.getString("name") +
                        ", ID: " + updatedResultSet.getString("ID"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
