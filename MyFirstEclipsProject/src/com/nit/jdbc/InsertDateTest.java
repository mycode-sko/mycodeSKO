package com.nit.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertDateTest {
	private static final String INSERT_DATE_QUERY = "INSERT INTO PERSON_DATE_TAB VALUES(?,?,?,?,?)";

	public static void main(String[] args) {
		Scanner sc = null;
		int no = 0;
		String name = null;
		String dob = null, doj = null, dom = null;
		SimpleDateFormat sdf1 = null,sdf2=null;
		java.util.Date udob = null, udoj = null;
		java.sql.Date sqdob = null, sqdoj = null, sqdom = null;
		long ms = 0, ms1 = 0;
		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		boolean flag = false;
		try {
			// read inputs from end user
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter person id::");
				no = sc.nextInt();
				System.out.println("Enter person name::");
				name = sc.next();
				System.out.println("Enter DOB(dd-MM-yyyy)::");
				dob = sc.next();
				System.out.println("Enter DOJ(MM-dd-yyyy)::");
				doj = sc.next();
				System.out.println("Enter DOM(yyyy-MM-dd)::");
				dom = sc.next();
			}
			// converting string date values to util date values
			sdf1 = new SimpleDateFormat("dd-MM-yyyy");
			if (sdf1 != null) 
				udob = sdf1.parse(dob);
			sdf2=new SimpleDateFormat("MM-dd-yyyy");
			if(sdf2!=null)
				udoj = sdf2.parse(doj);
			
			// converting java.util.date object to java.sql.date format
			if (udob != null) {
				ms = udob.getTime();
				sqdob = new java.sql.Date(ms);
			}
			if (udoj != null) {
				ms1 = udoj.getTime();
				sqdoj = new java.sql.Date(ms1);
			}
			// for DOM
			sqdom = java.sql.Date.valueOf(dom);
			// register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "manager");
			// create prepared Statement
			if (con != null)
				ps = con.prepareStatement(INSERT_DATE_QUERY);
			// set value to the Query param
			if (ps != null) {
				ps.setInt(1, no);
				ps.setString(2, name);
				ps.setDate(3, sqdob);
				ps.setDate(4, sqdoj);
				ps.setDate(5, sqdom);
			}
			// execute query
			if (ps != null)
				count=ps.executeUpdate();
			// process the result;
			if (count == 0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close jdbc objects
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
					ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally

	}// main

}// class
