//SelectTest4.java
package com.nit.jdbc;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.IOException;

class SelectTest4 
{
	public static void main(String[] args) 
	{
		Scanner sc     =null;
		Connection con =null;
		Statement st   =null; 
		String query   =null;
		ResultSet rs   =null;
        boolean flag   =false;



		try
		{
			//reading input from end user
			
			sc=new Scanner(System.in);
			if(sc!=null)
			System.out.println("Enter Department Number::");
			int dptno=sc.nextInt();	
            //register Jdbc Driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establish Connection with db s/w
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","manager");
			//create Statement object
			if(con!=null)
            st=con.createStatement();
			//prepeare Querry
			//SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE DEPTNO=20;
			query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE DEPTNO="+dptno;
			System.out.println(query);
			//send and execute sql query to the db s/w
			if(st!=null)
            rs=st.executeQuery(query);
			//process the result
			if(rs!=null)
            while (rs.next()){
            flag=true;
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getFloat(4));
            }//while
			if(flag)
				System.out.println("Records found and displayed");
			else
				System.out.println("Records not Found");
		}//try
		catch (SQLException se)
		{//known exception
			se.printStackTrace();
		}
		catch (ClassNotFoundException cnf)
		{//known exception
			cnf.printStackTrace();
		}
		catch (Exception e)
		{//Unknown exception
			e.printStackTrace();
		}
		finally{
			//close objects
			try
			{
				if(rs!=null)
				rs.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(st!=null)
				st.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(con!=null)
				con.close();
			}
			catch (SQLException se)
			{
				se.printStackTrace();
			}
			try
			{
				if(sc!=null)
				sc.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}//main
}//class
//javac -d . SelectTest4.java
//java com.nt.jdbc.SelectTest4
