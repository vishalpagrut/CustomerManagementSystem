package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.signupbo.signupbo;

/**
 * Servlet implementation class regcontroller
 */
@WebServlet("/regcontroller")
	public class regcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter obj=response.getWriter();

		String id = request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String password=request.getParameter("password");
	
		signupbo sb=new signupbo();
		
		sb.setId(id);
		sb.setName(name);
		sb.setEmail(email);
	    sb.setPhone(phone);
	    sb.setPassword(password);
	    
	   int status=Dao.Signup(sb);
	   
	   if(status>0)	
	   {
		   obj.print("Data has been successfully insert");
		  // pw.print("<a href='HomeController'>HomeController</a>");
	   }
	   else {
		   obj.print("something went wrong !");
 
	   }
	    
	    
		
		
	}

}