/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ibnub
 */
public class DatabaseConnection {
    
    private static Connection connection;

    public static Connection getDatabaseConnection() throws SQLException, ClassNotFoundException {
        if (connection == null) {
            Class.forName("com.mysql.jdbc.Driver");
            String dbName = "jdbc:mysql://localhost/arle_db";
            String dbUser = "root";
            String dbPassword = "";
                 
            connection = DriverManager.getConnection(dbName, dbUser, dbPassword);
        }
        return connection;
    }
    
}
