package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.signupbo.signupbo;

/**
 * Servlet implementation class AllRegisteredUser
 */
@WebServlet("/AllRegisteredUser")
public class AllRegisteredUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllRegisteredUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String id=request.getParameter("id");
		pw.print("<table border='1px solid black' width='100%'>");
		pw.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\">");
		
		pw.print("<tr> <th>Id</th>  <th>Name</th>  <th>Email</th>  <th>Phone</th>  <th>Password</th> <th>Update</th> <th>Delete</th> </tr> ");
		
		    List<signupbo> list = Dao.getAllRegisteredUser(id);
		
		for(signupbo sb:list)
		{
			pw.print("<tr><td>"+sb.getId()+"</td><td>"+sb.getName()+"</td> <td>"+sb.getEmail()+"</td> <td>"+sb.getPhone()+"</td> <td>"+sb.getPassword()+"</td> <td><a href='EditServlet?id="+sb.getId()+"'> edit </a> </td> <td><a href='DeleteController?id="+sb.getId()+"'>delete </a></td> </tr>");
			
		}
		pw.print("</table>");
		
	}

	

}
