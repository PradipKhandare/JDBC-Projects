package com.practice.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_1 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pradudb", "root", "root");
			Statement st = conn.createStatement();
			ResultSet result = st.executeQuery("SELECT * FROM EMP");

			while (result.next()) {
				System.out.println(result.getInt(1) + " | " + result.getString(2) + " | " + result.getString(3) + " | "
						+ result.getInt(4) + " | " + result.getDate(5) + " | " + result.getInt(6) + " | "
						+ result.getInt(7) + " | " + result.getInt(8));
			}

			if (conn != null) {
				conn.close();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
			System.out.println("data not found");
		}

	}

}
