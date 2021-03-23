package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PstInsertTest {

	public static void main(String[] args) {
		String query = "INSERT INTO STUDENT VALUES(?,?,?,?)";
		Scanner sc = null;
		int count = 0;
		Connection con = null;
		PreparedStatement ps = null;
		int sno = 0;
		String name = null;
		String add = null;
		float avg = 0.0f;
		ResultSet rs = null;
		int result=0;
		try {
			sc = new Scanner(System.in);
			System.out.println("Enter Student count::");
			if (sc != null)
				count = sc.nextInt();
			// Register JDBC object
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "manager");
			if (con != null)
				ps = con.prepareStatement(query);
			// read multiple input from end user
			if (sc != null && ps != null) {
				for (int i = 1; i < count; i++) {
					System.out.println("Enter" + i + "Student details");
					System.out.println("Enter student number::");
					sno = sc.nextInt();
					System.out.println("Enter Studet name::");
					name = sc.next();
					System.out.println("Enter Studet Address::");
					add = sc.next();
					System.out.println("Enter Studet avg::");
					avg = sc.nextFloat();
					// set the input values read from end user to query params
					ps.setInt(1, sno);
					ps.setString(2, name);
					ps.setString(3, add);
					ps.setFloat(4, avg);
					// execute the query
					result= ps.executeUpdate();
					// process the result
					if (result==0)
						System.out.println(i + "Student values are not inserted");
					else
						System.out.println(i + "studentn values are inserted");

		         }//for

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close jdbc object
			try {
				if (rs != null)
					rs.close();

			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();

			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (con != null)
					con.close();

			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (sc != null)
					sc.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		} // finally
	}// main
}// class
