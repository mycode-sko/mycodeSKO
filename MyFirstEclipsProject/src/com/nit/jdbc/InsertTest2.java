package com.nit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest2 {

	public static void main(String[] args) {
		Scanner sc=null;
		int eno=0;
		String name=null;
		String job=null;		
		Float sal=0.0f;
		Connection con=null;
		Statement st=null;
		String query=null;
		int count=0;
		try {
			sc= new Scanner(System.in);
			if (sc!=null) {
				System.out.println("Enter Employee number::");
				eno=sc.nextInt();
				System.out.println("Enter Emplyee name::");
				name=sc.next().toUpperCase();
				System.out.println("Enter Employee job::");
				job=sc.next().toUpperCase();
				System.out.println("Enter Emlpoyee sal::");
				sal=sc.nextFloat();
			//convert input as required for sql query
				name="'"+name+"'";
				job="'"+job+"'";
			}
			//Establish Connection with db s/w
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "manager");
			//create statement object
			if(con!=null)
			st=con.createStatement();
			//prepere query
			//insert into emp(empno,ename,job,sal) values(103,'vijay','salesman',1400);
			query="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES("+eno+","+name+","+job+","+sal+")";
			System.out.println(query);
			//send and execute query to the db s/w
			if(st!=null)
			count=st.executeUpdate(query);	
			//process result
			if(count==1)
				System.out.println(count+ " record inserted");
					
		}//try
		catch (SQLException se) {
			System.out.println("no records inserted");
			if(se.getErrorCode()==1)
				System.out.println("employee with this empid is already irserted");
			else if(se.getErrorCode()==12899)
				System.out.println("value too large for column");
			else 
				System.out.println("unknown db problem");
		     se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//close jdbc object
			try {
				if(st!=null)
					st.close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
				
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if(sc!=null)
					sc.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//finally

	}//main

}//class
