package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;
import com.signupbo.signupbo;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String id = request.getParameter("id");
		
		signupbo sb = Dao.getEmployeeDataById(id);
		
		pw.print("<link rel=\"stylesheet\" href=\"css\\style.css\">");
		
		pw.print("<form action='UpdateController' method='post'>");
		
		pw.print("<h1>Form</h1>");
		
		pw.print("<table>");
		
		pw.print("<tr><td>Id: <input type='text' name='id' value='"+sb.getId()+"'/></td></tr>");
		pw.print("<tr><td>Name: </td> <td> <input type='text' name='name' value='"+sb.getName()+"'/></td></tr>");
		pw.print("<tr><td>Email: </td> <td> <input type='text' name='email' value='"+sb.getEmail()+"'/></td></tr>");
		pw.print("<tr><td>Phone: </td> <td> <input type='text' name='phone' value='"+sb.getPhone()+"'/></td></tr>");
		pw.print("<tr><td>Password: </td> <td> <input type='text' name='password' value='"+sb.getPassword()+"'/></td></tr>");
		
		//pw.print("<br>");
		pw.print("<tr> <td> <input type='submit' value='Update' class='btn'/></td></tr>");
		
		pw.print("</table>");
		
		pw.print("</form>");
	}

	

}
