package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Dao;



/**
 * Servlet implementation class logincontroller
 */
@WebServlet("/logincontroller")
public class logincontroller extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
    **/
    public logincontroller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	    String email=request.getParameter("email");
	    String password=request.getParameter("password");
	    
	   if( Dao.login(email, password))
	   {
		   pw.print("<script> alert('login successfully') </script>");
		  // RequestDispatcher rd=request.getRequestDispatcher("index.html");
		   //rd.include(request, response);
		   HttpSession session=request.getSession();
			session.setAttribute("email", email);
			
			pw.print("<a href='HomeController'>HomeController</a>");
		   		   
	   }
	   else
	   {
		   pw.print("<script> alert('try again') </script>");
		   RequestDispatcher rd=request.getRequestDispatcher("login.html");
		   rd.include(request, response); 
	   }
	    
	    
				
	}
	
}