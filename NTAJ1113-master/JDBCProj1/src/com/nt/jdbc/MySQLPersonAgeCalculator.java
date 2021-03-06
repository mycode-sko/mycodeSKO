package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MySQLPersonAgeCalculator {
 private static final String  AGE_CALC_QUERY="SELECT TIMESTAMPDIFF(DAY,DOB,CURDATE())/365 FROM PERSON_DATE_TAB WHERE PID=?";
	public static void main(String[] args) {
		Scanner sc=null;
		int pid=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("enter PErson id::");
				pid=sc.nextInt();
			}
			//register JDBC driver s/w
			Class.forName("com.mysql.cj.jdbc.Driver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:mysql:///NTAJ1113DB1","root","root");
			//create PreparedStatement object
			if(con!=null)
				ps=con.prepareStatement(AGE_CALC_QUERY);
			//set query param values
			if(ps!=null) 
			   ps.setInt(1,pid);
			//execute SQL query in DB s/w
			if(ps!=null)
			 rs=ps.executeQuery();
			//process the Resultset obj
			if(rs!=null) {
				if(rs.next()) {
					System.out.println("Age ::"+rs.getFloat(1));
				}
				else {
					System.out.println("Record not found");
				}
			}//if
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}//finally
	}//main
}//class
