package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String URL = "jdbc:mysql://localhost:3306/crudj2e"; 
    private static final String USER = "root";
    private static final String PASSWORD = "MdialloC19@"; 

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erreur de chargement du driver JDBC", e);
        }
    }


    public static Connection getConnection() throws SQLException {
    	System.out.println("ok");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
   

}