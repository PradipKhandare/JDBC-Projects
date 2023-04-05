package com.pradipk.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThirdJDBC {

	static Connection connection;
	static Statement statement;
	static ResultSet resultset;
	static String driverPath = "com.mysql.cj.jdbc.Driver";
	static String dbPath = "jdbc:mysql://localhost:3306/pradudb";
	static String user = "root";
	static String password = "root";
	static String query = "select * from emp";

	public static void main(String[] args) {
		// code standardization:
		try {

			Class.forName(driverPath);
			connection = DriverManager.getConnection(dbPath, user, password);
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			while (resultset.next()) {
				System.out.println(resultset.getInt(1) + " " + resultset.getString(2) + " " + resultset.getString(3)
						+ " " + resultset.getInt(4) + " " + resultset.getDate(5) + " " + resultset.getInt(6) + " "
						+ resultset.getInt(7) + " " + resultset.getInt(8));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
		} catch (SQLException e) {
			System.out.println("Database Not Found");
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println("can not closed database");
				}
			}

		}

	}

}
