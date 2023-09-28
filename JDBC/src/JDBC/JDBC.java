package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/University";
        String uname = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try {
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement statement = con.createStatement();

            // CREATE
            /*
            String insertQuery = "INSERT INTO engineeringstudents (Stuent_ID, Department, First_Name, Last_Name, PassOutYear, UniversityRank) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = con.prepareStatement(insertQuery);
            insertStatement.setInt(1, 10204); // Assuming "Stuent_ID" is an integer field
            insertStatement.setString(2, "CSE"); // Assuming "Department" is a string field
            insertStatement.setString(3, "lahcen"); // Assuming "First_Name" is a string field
            insertStatement.setString(4, "kormod"); // Assuming "Last_Name" is a string field
            insertStatement.setInt(5, 2024); // Assuming "Pass
            insertStatement.setInt(6, 1274); // Assuming "Pass
            insertStatement.executeUpdate();
			*/
            // READ
            String selectQuery = "SELECT * FROM engineeringstudents";
            ResultSet result = statement.executeQuery(selectQuery);
            while (result.next()) {
                String UniversityData = "";
                for (int i = 1;   i <= 6; i++) {
                    UniversityData += result.getString(i) + ":";
                }
                System.out.println(UniversityData);
            }

            // UPDATE
            /*
            String updateQuery = "UPDATE engineeringstudents SET Last_Name = ? WHERE Stuent_ID = ?";
          //  " UPDATE `engineeringstudents` SET `Last_Name` = 'ADao' WHERE `engineeringstudents`.`Stuent_ID` = 10203\r\n"
        
            PreparedStatement updateStatement = con.prepareStatement(updateQuery);
            updateStatement.setString(1, "Adaoumoum");
            updateStatement.setInt(2, 10203);
            updateStatement.executeUpdate();
            */

            // DELETE
            
            String deleteQuery = "DELETE FROM engineeringstudents WHERE Stuent_ID = ?";
            PreparedStatement deleteStatement = con.prepareStatement(deleteQuery);
            deleteStatement.setInt(1, 10203);
            deleteStatement.executeUpdate();
            

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
