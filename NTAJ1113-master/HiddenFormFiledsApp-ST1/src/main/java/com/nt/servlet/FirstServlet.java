package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/furl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw=null;
	   String name=null,addrs=null,ms=null;
		//get PrintWriter 
	   pw=res.getWriter();
	   //set response content type
	   res.setContentType("text/html");
	   //read form1/req1 data
	   name=req.getParameter("pname");
	   addrs=req.getParameter("paddrs");
	   ms=req.getParameter("ms");
	   if(ms==null)
		    ms="single";
	   
	   // Generate form2 dynamically based on marital status
	   if(ms.equalsIgnoreCase("married")) {
		   pw.println("<h1 style='color:blue;text-align:'center'> Married life details</h1>");
		   pw.println("<form action='surl'  method='post'>");
		   pw.println("<table bgcolor='cyan' border='1' align='center'>");
		   pw.println("<tr><td>spouse name::</td><td> <input type='text' name='f2t1'></td> </tr>");
		   pw.println("<tr><td>no.of kids::</td><td> <input type='text' name='f2t2'></td></tr>");
		   pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
		    pw.println("<tr><td colspan='2'><input type='hidden' name='hname' value='"+name+"'><input type='hidden' name='haddrs' value='"+addrs+"'><input type='hidden' name='hms' value='"+ms+"'> </td></tr>");
		   pw.println("</table>");
		   pw.println("</form>");
		  
	   }
	   else {
		   pw.println("<h1 style='color:blue;text-align:'center'> Bachelor life details</h1>");
		   pw.println("<form action='surl'  method='post'>");
		   pw.println("<table bgcolor='cyan' border='1' align='center'>");
		   pw.println("<tr><td>when do u want to marray::</td><td> <input type='text' name='f2t1'></td> </tr>");
		   pw.println("<tr><td>why do u want to marry::</td><td> <input type='text' name='f2t2'></td></tr>");
		   pw.println("<tr><td colspan='2'><input type='submit' value='submit'></td></tr>");
		    pw.println("<tr><td colspan='2'><input type='hidden' name='hname' value='"+name+"'><input type='hidden' name='haddrs' value='"+addrs+"'><input type='hidden' name='hms' value='"+ms+"'> </td></tr>");
			  pw.println("</table>");
		   pw.println("</form>");
	   }
	   
	   //close the stream
	   pw.close();
	   
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
