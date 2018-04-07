package database;

import java.sql.*;

public class DBConnection {
	private static Connection c = null;
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String CONNECTION = "jdbc:mysql://localhost/Projects?useSSL=false";
	
	
	
	public static Connection getConnection() throws SQLException {
		if (c == null)
			c = DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
		return c;
	}

}
