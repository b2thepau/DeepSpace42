package org.kodejava.example.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteRecordExample {
    public static void main(String[] args) throws Exception {
        // This is our connection url to MySQL database, where jdbc is the prefix
        // for all jdbc connection. The mysql sub telling that we are using MySQL
        // database. Localhost is where our database is reside and sampledb is 
        // our database name.
        String url = "jdbc:mysql://localhost/sampledb";

        // To connect to a database we will need a user and password for the 
        // database server to allow us to manipulate its databse.
        String username = "root";
        String password = "";

        Connection connection = null;
        try {
            // Load the jdbc driver class
            Class.forName("com.mysql.jdbc.Driver");
            // Then we ask a connection from the DriverManager by passing the 
            // connection URL and the password.
            connection = DriverManager.getConnection(url, username, password);

            // To delete records from tables we create an SQL delete command.
            // The question mark that we used in the where clause will be the
            // holder of value that will be assigned by PreparedStatement class.
            String sql = "DELETE FROM users WHERE user_id = ?";
            int userId = 2;

            // Create a statement object. We use PreparedStatement here.
            PreparedStatement statement = connection.prepareStatement(sql);

            // Pass a value of a userId that will tell the database which
            // records in the database to be deleted. Remember that when
            // using a statement object the indext parameter is start from
            // 1 not 0 as in the Java array data type index.
            statement.setInt(1, userId);

            // Tell the statement to execute the command. The executeUpdate()
            // method for a delete command returns number of records deleted
            // as the command executed in the database. If no records was
            // deleted it will simply return 0
            int rows = statement.executeUpdate();

            System.out.println(rows + " record(s) deleted.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
