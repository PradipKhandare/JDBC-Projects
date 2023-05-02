package com.practice.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_3 {

	static Connection conn;
	static Statement st;
	static ResultSet result;
	static String drivepath = "com.mysql.cj.jdbc.Driver";
	static String dbpath = "jdbc:mysql://localhost:3306/pradudb";
	static String username = "root";
	static String password = "root";
	static String query = "select ename from emp where mgr = 2";

	public static void main(String[] args) {

		try {
			Class.forName(drivepath);
			conn = DriverManager.getConnection(dbpath, username, password);
			st = conn.createStatement();
			result = st.executeQuery(query);
			while (result.next()) {
				System.out.println(result.getString(1));
			}

			if (conn != null) {
				conn.close();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
			System.out.println("Db not found");
		}

	}

}
