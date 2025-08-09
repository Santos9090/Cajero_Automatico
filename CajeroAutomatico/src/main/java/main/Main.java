package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
	
	static Connection conn;
	
	
	public static void main(String[] args) throws SQLException {
		try {
			conn = DriverManager.getConnection("", "sa", "");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
