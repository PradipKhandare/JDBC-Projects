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

public class JDBC_7 {

	static Connection conn;
	static Statement st;
	static ResultSet rs;
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String query = "SELECT ENAME FROM emp";
	static Properties properties = new Properties();

	public static void main(String[] args) {

		try {
			Class.forName(driver);
			FileReader fileReader = new FileReader("E:\\HTML\\JDBC_Projects\\resources" + "\\db-info.properties");
			properties.load(fileReader);
			conn = DriverManager.getConnection(properties.getProperty("dbpath"), properties);
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not connected");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("Connection not closed");
			}
		}
	}

}
