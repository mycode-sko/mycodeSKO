//SelectTest6.java
package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectTest6 {
	public static void main(String[] args) {
		Scanner sc = null;
		int num = 0;
		Connection con = null;
		Statement st = null;
		String query = null;
		ResultSet rs = null;

		try {
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter rank::");
				num = sc.nextInt();
			}
			// Establish connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "manager");
			// Create Statement object
			if (con != null)
				st = con.createStatement();
			// prepare query
			// SELECT*FROM(SELECT ENAME,SAL,DENSE_RANK() OVER(ORDER BY SAL DESC)R FROM
			// EMP)WHERE R=&N;
			query = "SELECT*FROM(SELECT ENAME,SAL,DENSE_RANK() OVER(ORDER BY SAL DESC)R FROM EMP)WHERE R=" + num;
			// send and execute sql query to database s/w
			if (st != null)
				rs = st.executeQuery(query);
			// process the result set
			if (rs.next()) {
				System.out.println("Employee having " + num + "th Highest salary is::");
				System.out.println(rs.getString(1) + "  " + rs.getDouble(2) + "  " + rs.getInt(3));
			} else
				System.out.println("records not found");

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
		} // finally

	}// main
}// class
