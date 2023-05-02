package com.practice.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_2 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pradudb", "root", "root");
			Statement st = conn.createStatement();
			ResultSet resultset = st.executeQuery("select empno from emp where empno = 1");
			while (resultset.next()) {
				System.out.println(resultset.getInt(1));
			}
			if (conn != null) {
				conn.close();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("driver not found");
		} catch (SQLException e) {
			System.out.println("Database not found");
		}

	}

}
