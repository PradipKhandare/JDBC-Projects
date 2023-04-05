package com.pradipk.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FifthJDBC {

	static Connection conn;
	static Statement st;
	static ResultSet res;
	static String driverpath = "com.mysql.cj.jdbc.Driver";
	static String dbpath = "jdbc:mysql://localhost:3306/pradudb";
	static String user = "root";
	static String password = "root";
	static String query = "SELECT ENAME FROM EMP WHERE DEPTNO = 20";

	public static void main(String[] args) {
		try {
			Class.forName(driverpath);
			conn = DriverManager.getConnection(dbpath, user, password);
			st = conn.createStatement();
			res = st.executeQuery(query);
			while (res.next()) {
				System.out.println(res.getString(1));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("driver not found");
		} catch (SQLException e) {
			System.out.println("Database not found");
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("connection not closed");
			}
		}

	}

}
