package com.practice.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_5 {

	static Connection conn;
	static Statement st;
	static int resultInt;
	static String username = "root";
	static String password = "root";
	static String dbpath = "jdbc:Mysql://localhost:3306/pradudb	";
	static String driverpath = "com.mysql.cj.jdbc.Driver";
	static String query = "INSERT INTO dept VALUES(50, 'HR', 'INDIA')";

	public static void main(String[] args) {

		try {
			Class.forName(driverpath);
			conn = DriverManager.getConnection(dbpath, username, password);
			st = conn.createStatement();
			resultInt = st.executeUpdate(query);
			if (resultInt != 0) {
				System.out.println("query, Ok " + resultInt + " rows affected");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
			System.out.println("Database not found");
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
