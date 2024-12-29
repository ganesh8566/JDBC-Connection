package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/employee";
		String uname = "root";
		String pwd = "root";

		Connection con = null;
		Statement stmt = null;
		ResultSet res = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");

			con = DriverManager.getConnection(url, uname, pwd);
			System.out.println("Connection Established");

			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 0);
			System.out.println("Statement Created");
			String query = "select * from emp";

			res = stmt.executeQuery(query);
			System.out.println("Query Executed");
			System.out.println("----------------------");

			
			ResultSetMetaData resMd = res.getMetaData();
			
			for (int i = 1; i < resMd.getColumnCount(); i++) {
				System.out.println(resMd.getColumnName(i) + " "+ resMd.getColumnTypeName(i));
			}
			System.out.println("----------------------");

			while (res.next()) {
				System.out.println(
						res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getLong(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				res.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
