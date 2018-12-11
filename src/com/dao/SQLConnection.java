package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

    private static final String servername = "localhost";
    private static final int port = 3306;
    private static final String user = "root";
    private static final String pass = "";
    private static final String db = "ssd";
    private static final String connectionString = "jdbc:mysql://" + servername + ":" + port + "/" + db;
    
    public Connection provide() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(connectionString, user, pass);

        } 
        catch (SQLException | ClassNotFoundException e) {
            throw new SQLConnectionException(e);
        }
    }
    
    public class SQLConnectionException extends RuntimeException {
    	SQLConnectionException(Exception e) {super(e);}
    }
}