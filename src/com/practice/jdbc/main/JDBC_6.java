package com.practice.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_6 {

	static Connection conn;
	static Statement st;
	static int result;
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String db = "jdbc:mysql://localhost:3306/pradudb";
	static String username = "root";
	static String password = "root";
	static String query = "INSERT INTO emp VALUES(5, 'tukaram', 'engineer', 3, '2020-01-01', 2345, 26, 50)";

	public static void main(String[] args) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(db, username, password);
			st = conn.createStatement();
			result = st.executeUpdate(query);

			if (result != 0) {
				System.out.println("Query ok " + result + " rows affected");
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		} catch (SQLException e) {
			System.out.println("Database not connected");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {
				System.out.println("Connection not closed");
			}
		}

	}

}
