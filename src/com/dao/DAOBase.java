package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOBase implements AutoCloseable{
	
	protected Connection connection;
	
	public DAOBase() {
		SQLConnection sqlC = new SQLConnection();
		this.connection = sqlC.provide();
	}
	

	@Override
	public synchronized void close() throws SQLException {
		if(connection != null) {
			connection.close();
			connection = null;
		}
		
	}
    protected Connection getConnection() {

        return connection;

    }

}
