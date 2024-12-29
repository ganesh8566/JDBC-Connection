package com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
// Insert the Data from  the Console................
public class Practice2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			String query = "insert into emp values(?,?,?,?)";
			PreparedStatement pstw = con.prepareStatement(query);

			System.out.println("Enter Employee Id:");
			int id = sc.nextInt();
			System.out.println("Enter Employee Name:");
			String name = sc.next();
			System.out.println("Enter Employee Gender:");
			String gender = sc.next();
			System.out.println("Enter Employee Number:");
			Long number = sc.nextLong();

			pstw.setInt(1, id);
			pstw.setString(2, name);
			pstw.setString(3, gender);
			pstw.setLong(4, number);
			
			pstw.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
