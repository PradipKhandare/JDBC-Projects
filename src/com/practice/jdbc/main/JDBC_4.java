package com.practice.jdbc.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_4 {
	static Connection conn;
	static Statement st;
	static ResultSet rs;
	static String user = "root";
	static String password = "root";
	static String driverpath = "com.mysql.cj.jdbc.Driver";
	static String dbpath = "jdbc:mysql://localhost:3306/pradudb";
	static String query = "select mgr from emp where deptno = 20";

	public static void main(String[] args) {
		try {

			Class.forName(driverpath);
			conn = DriverManager.getConnection(dbpath, user, password);
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getInt(1));
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

			} catch (SQLException e) {
				System.out.println("Driver not found");
			}
		}

	}

}
