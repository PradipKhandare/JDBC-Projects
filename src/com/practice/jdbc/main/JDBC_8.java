package com.practice.jdbc.main;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC_8 {

	static Connection conn;
	static Statement st;
	static ResultSet rs;
	static String driverpath = "com.mysql.cj.jdbc.Driver";
	static String query = "SELECT mgr FROM emp WHERE comm = 10";
	static FileReader fileReader;
	static Properties properties = new Properties();

	public static void main(String[] args) {
		try {
			Class.forName(driverpath);
			fileReader = new FileReader("E:\\HTML\\JDBC_Projects\\resources\\db-info.properties");
			properties.load(fileReader);

			conn = DriverManager.getConnection(properties.getProperty("dbpath"), properties);
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.println("MGR is " + rs.getInt(1));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e2) {
				System.out.println("Connection is not closed");
			}
		}

	}

}
