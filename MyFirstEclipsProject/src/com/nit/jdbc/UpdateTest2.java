package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest2 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		String query = null;
		int count = 0;

		try {
			// Establish Connection with db s/w
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "manager");
			// create statement object
			if (con != null)
				st = con.createStatement();
			// prepare query
			// UPDATE EMP SET SAL=SAL-COMM WHERE COMM IS NOT NULL;

			// send and Execute sql query to db s/w
			if (st != null)
				count = st.executeUpdate("UPDATE EMP SET SAL=SAL-COMM WHERE COMM IS NOT NULL");
			if (count == 0)
				System.out.println("Table is not updated");
			else
				System.out.println("table updated succesfully");

		} catch (SQLException se) {
			se.printStackTrace();
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
		} // finaly
	}// main

}// class
