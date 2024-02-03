package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static String getData(String str1, String str2, String str3, String str4, String str5, String str6) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment2", "root", "Codebro9801");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM emp");

            String query1 = "INSERT INTO `assignment2`.`emp`" +
                    " (`EMPID`, `ENAME`, `JOB`, `MGR`, `COMM`, `SAL`)" +
                    " VALUES('" + str1 + "','" + str2 + "','" + str3 + "','" + str4 + "','" + str5 + "','" + str6 + "' )";

            statement.executeUpdate(query1); // record added.

            resultSet = statement.executeQuery("SELECT * FROM emp"); // Re-executing the query.

            while (resultSet.next()) {
                // Process the ResultSet data here.
                System.out.println("EMPID: " + resultSet.getString("EMPID") +
                        ", ENAME: " + resultSet.getString("ENAME") +
                        ", JOB: " + resultSet.getString("JOB") +
                        ", MGR: " + resultSet.getString("MGR") +

                        ", SAL: " + resultSet.getString("SAL") +
                        ", COMM: " + resultSet.getString("COMM"));
            }

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str1;
    }
}
