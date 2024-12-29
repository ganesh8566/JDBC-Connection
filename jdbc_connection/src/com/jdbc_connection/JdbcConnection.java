package com.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnection {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employee";
		String username = "root";
		String pwd = "root";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded Sucessfully");

			Connection con = DriverManager.getConnection(url, username, pwd);
			System.out.println("Connection Sucessfully");

			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,0);
			String query = "select * from emp";

			ResultSet res = stmt.executeQuery(query);
			System.out.println("Query Executed");

			ResultSetMetaData metaData = res.getMetaData();

			for (int i = 1; i < metaData.getColumnCount(); i++) {
				System.out.println(metaData.getColumnName(i) + " "+ metaData.getColumnTypeName(i));
			}
			res.absolute(4);
			System.out.println(res.getInt(1)+ " "+ res.getString(2)+" "+ res.getString(3) + " "+ res.getLong(4));

			while (res.next()) {
				System.out.println(
						res.getInt(1) + " " + res.getString(2) + " " + res.getString(3) + " " + res.getLong(4));
			}

		} catch (ClassNotFoundException e) {
			System.out.println("Driver Not loaded");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
