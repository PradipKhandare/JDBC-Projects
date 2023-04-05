package com.pradipk.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SecondJDBC {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pradudb", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM EMP");

			while (result.next()) {
				System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getString(3) + " "
						+ result.getInt(4) + " " + result.getDate(5) + " " + result.getInt(6) + " " + result.getInt(7)
						+ " " + result.getInt(8));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("driver not found");
		} catch (SQLException e) {
			System.out.println("database not found");
		}

	}

}
