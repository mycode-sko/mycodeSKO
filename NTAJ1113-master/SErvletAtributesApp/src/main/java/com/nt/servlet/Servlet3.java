package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s3url")
public class Servlet3 extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher rd=null;
        PrintWriter pw=null;
        HttpSession ses=null;
        ServletContext sc=null;
		
        //read and display req attribute values
        pw=res.getWriter();
        //set response content type
        res.setContentType("text/html");
        //read and display req attrtibue values
        pw.println("<b> req attribute(attr1)  (servlet3) value ::"+req.getAttribute("attr1")+"</b>");
        //read and display ses attrtibue values
        ses=req.getSession();
        pw.println("<br><b>(Servlet3) ses attribute(attr2) value ::"+ses.getAttribute("attr2")+"</b>");
		
      //read and display sc attrtibue values
        sc=getServletContext();
        pw.println("<br><b>(Servlet3) sc attribute(attr3) value ::"+sc.getAttribute("attr3")+"</b>");
        
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
