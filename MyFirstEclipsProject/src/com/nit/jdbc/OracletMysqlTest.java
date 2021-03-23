package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracletMysqlTest {
	private static final String SELECT_STUDENT_QUERY = "SELECT SID,SNAME,SADD,SAVG FROM STUDENT";
	private static final String INSERT_STUDENT_QUERY = "INSERT INTO STUDENT VALUES(?,?,?,?)";

	public static void main(String[] args) {

		Connection oracon = null;
		Connection mysqlcon = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int resVal = 0;
		try {
			// register jdbc driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish the connection
			oracon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "manager");
			mysqlcon = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sakila", "root", "root");
			// Create statement object
			if (oracon != null)
				st = oracon.createStatement();
			if (mysqlcon != null)
				ps = mysqlcon.prepareStatement(INSERT_STUDENT_QUERY);
			// send and execute query to the database s/w
			if (st != null)
				rs = st.executeQuery(SELECT_STUDENT_QUERY);
			while (rs.next()) {
				ps.setInt(1, rs.getInt(1));
				ps.setString(2, rs.getString(2));
				ps.setString(3, rs.getString(3));
				ps.setFloat(4, rs.getFloat(4));
				ps.executeUpdate();
				resVal++;
			}
			System.out.println(resVal+" records inserted");

		} catch (SQLException se) {
			se.printStackTrace();
	}
		catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc object
			try {
				if(rs!=null)
					rs.close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(st!=null)
					st.close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(mysqlcon!=null)
					mysqlcon.close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(oracon!=null)
					oracon.close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			
		}//finally
	}//main
}//class
