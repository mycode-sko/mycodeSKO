package com.nit.jdbc;
import java.sql.*;

public class ConnTest
{
	public static void main(String[]args)throws Exception {
		//Register Oracle Thin Driver with DriverManger service

	     //Create driver class object
		 //oracle.jdbc.driver.OracleDriver driver= new oracle.jdbc.driver.OracleDriver();
		 
		 //register with DriverManager service
		 //DriverManager.registerDriver (driver);
		String url="jdbc:mysql://127.0.0.1:3306/sakila";

		 //load jdbc driver class      
		 //Class.forName("com.mysql.cj.jdbc.Driver");//optional

		 //Establish the connection with Db s/ws
		 Connection con= DriverManager.getConnection(url,"root","root");
			 if(con!=null)
			 System.out.println("JDBC Connection is  Established");
			 else
			 System.out.println("JDBC Connection is not Established");
			 
	}//main	 


}//class