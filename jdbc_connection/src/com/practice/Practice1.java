package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
// Inserting the Data into a DataBase............ 
public class Practice1 {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/employee";
		String uname = "root";
		String pwd = "root";

		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, uname, pwd);
			
			stmt = con.createStatement();
			
			String query = "insert into emp (`eId`,`eName`,`eGender`,`eNumber`) values (6,'Tarak','M',8837472765)";
			stmt.execute(query);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
