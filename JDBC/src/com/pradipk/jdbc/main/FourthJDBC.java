package com.pradipk.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FourthJDBC {
	static Connection connection;
	static Statement statement;
	static int resultset;
	static String driverpath = "com.mysql.cj.jdbc.Driver";
	static String dbpath = "jdbc:mysql://localhost:3306/pradudb";
	static String user = "root";
	static String password = "root";
	static String query = "INSERT INTO EMP VALUES (4,'Ganesh','Manager',1,'2022-02-01',2837,123, 40)";

	public static void main(String[] args) {

		try {

			Class.forName(driverpath);
			connection = DriverManager.getConnection(dbpath, user, password);
			statement = connection.createStatement();
			resultset = statement.executeUpdate(query);
			while (resultset != 0) {
				System.out.println("query Ok " + resultset + " rows affected");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("driver not found :");
		} catch (SQLException e) {
			System.out.println("databse not found : ");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("Connection not closed");
				}
			}
		}

	}

}
