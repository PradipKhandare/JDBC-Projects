package com.pradipk.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJDBC {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pradudb", "root", "root");
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT JOB FROM EMP WHERE DEPTNO = 20");
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not Found");
		} catch (SQLException e) {
			System.out.println("database not found");
		}
	}

}
