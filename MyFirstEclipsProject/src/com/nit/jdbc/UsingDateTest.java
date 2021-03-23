package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsingDateTest {
	private static final String CAL_AGE_QUERY = "SELECT PID,PNAME,(SYSDATE-DOB)/365 AS AGE FROM PERSON_DATE_TAB WHERE PID=?";

//select pid,pname,round((sysdate-dob)/365) as age from person_date_tab where pid=101;
	public static void main(String[] args) {
		Scanner sc = null;
		int no = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// read input from end user
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter Person id::");
				no = sc.nextInt();
			}
			// register jdbc driver class object
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "manager");
			// CREATE PREPARAED statement
			if (con != null)
				ps = con.prepareStatement(CAL_AGE_QUERY);
			// set values to the quary param
			if (ps != null)
				ps.setInt(1, no);
			// Execute query
			if (ps != null)
				rs = ps.executeQuery();
			// process the resultset
			if (rs.next()) {
				System.out.println("AGE OF THE PERSON HAVING PID:-"+no+" IS::");
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getFloat(3));
			}
			else
				System.out.println("records not found");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close jdbc objs
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
