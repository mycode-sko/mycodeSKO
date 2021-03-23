//DeleteTest1.java
package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteTest1 {
	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		int Sno = 0;
		int Eno=0;
		int result = 0;
		String query=null;
		
		//Version 1.0
		//Date 01 Mar 2020
		

		try {
			// read input
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter Start Student id::");
				Sno = sc.nextInt();
				System.out.println("Enter End Student id::");
				Eno = sc.nextInt();
			}

			// Establish the connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "manager");
			// create statement
			if (con != null)
				st = con.createStatement();
			//prepare querry
			query ="DELETE FROM STUDENT WHERE SID BETWEEN "+Sno+" AND "+Eno;
			System.out.println(query);
			// Send and execute query to the DB s/w
			if (st != null)
				result = st.executeUpdate(query);
			// process the result
			if (result == 0)
				System.out.println("no records found to Delete");
			else
				System.out.println(result +" no. of records are found and Deleted");

		} // try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close jdbc object
			try {
				if (st != null)
					st.close();
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
		}
	}// main
}// class
