package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.signupbo.signupbo;

import java.util.*;

public class Dao {
	
	public static Connection getconnection() 
	{
	   Connection con=null;
	   
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
			 
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/march_batch","root","vishal@123");
					
	} 
	   catch (Exception e) 
	   {
		e.printStackTrace();
	}   
	   return con;
	}
    
public static int Signup(signupbo sb) 
{
  int status=0;
  
  
  try
  {
    Connection con=Dao.getconnection();
     String  sql="insert into registration(id,name,email,phone,password) values(?,?,?,?,?)";
		PreparedStatement ps =con.prepareStatement(sql);
        
		ps.setString(1, sb.getId());
		ps.setString(2, sb.getName());
		ps.setString(3, sb.getEmail());
		ps.setString(4, sb.getPhone());
		ps.setString(5, sb.getPassword());
		
	   status=ps.executeUpdate();
		} 
  catch (Exception e)
  {
	   e.printStackTrace();
 }
  return status;
  }

    public static boolean login(String email,String password) {
    	
    	boolean status=false;
    	
    	try 
    	{
    	   Connection con=Dao.getconnection();	
			 String sql="select *from  registration where email=? and password=?";
			 PreparedStatement ps=con.prepareStatement(sql);
			 ps.setString(1, email);
			 ps.setString(2, password);
			 
			 ResultSet rs= ps.executeQuery();
		      status=rs.next();
		      
    	} 
    	catch (Exception e)
    	{
			e.printStackTrace();
		}
     	
    	
    	return status;
    }

    
    public static List getAllRegisteredUser(String id)
    {
    	ArrayList<signupbo> list=new ArrayList<signupbo>();
    	
    	try 
    	{
		   Connection con=Dao.getconnection();	
	    	String sql="select *from  registration";
		    PreparedStatement ps=con.prepareStatement(sql);
		    ResultSet rs=ps.executeQuery();
		    
		    while(rs.next())
		    {
		    	signupbo sb=new signupbo();
		    	
		    	sb.setId(rs.getString(1));
		    	sb.setName(rs.getNString(2));
		    	sb.setEmail(rs.getNString(3));
		    	sb.setPhone(rs.getNString(4));
		    	sb.setPassword(rs.getNString(5));
		    	
		    	list.add(sb);
		    }
    	} 
    	catch (Exception e)
    	{
    		System.out.println(e);
		}
    		
    	
    	return list;
    }
    

//    public static int updateregisteredUser(signupbo sb) {
//    	int status=0;
//    	try
//    	{
//    		Connection con=Dao.getconnection();
//    		String sql="update registration set name=?,email=?,phone=?,password=? where id=? ";
//    		
//    		PreparedStatement ps=con.prepareStatement(sql);
//    		ps.setString(1, sb.getName());
//    		ps.setString(2, sb.getEmail());
//    		ps.setString(3, sb.getPhone());
//    		ps.setString(4, sb.getPassword());
//    		ps.setString(5, sb.getId());
//    		
//    		status =ps.executeUpdate();
//    	}
//    	catch(Exception e)
//    	{
//    		e.printStackTrace();
//    	}
//    	
//		return status;
//    	
//    }
//    public static int deleteregisteredUser(String id) {
//    	int status=0;
//    	try
//    	{
//    		Connection con=Dao.getconnection();
//    		String sql="delete from registration where id=? ";
//    		
//    		PreparedStatement ps=con.prepareStatement(sql);
//    		
//    		ps.setString(1, id);
//    		
//    		status =ps.executeUpdate();
//    	}
//    	catch(Exception e)
//    	{
//    		e.printStackTrace();
//    	}
//    	
//		return status;
//    	
//    }
    public static signupbo getEmployeeDataById(String id)
	{
		
		signupbo sb = new signupbo();
		
		try 
		{
			Connection con = Dao.getconnection();
			
			String sql = "select * from registration where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				sb.setId(rs.getString(1));
				sb.setName(rs.getString(2));
				sb.setEmail(rs.getString(3));
				sb.setPhone(rs.getString(4));
				sb.setPassword(rs.getString(5));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return sb;	
	}
	
	
	public static int getupdateEmployee(signupbo sb)
	{
		int status = 0;
		
		try 
		{
			Connection con = Dao.getconnection();
			
			String sql = "update registration set name=?, email=?, phone=?, password=? where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getEmail());
			ps.setString(3, sb.getPhone());
			ps.setString(4, sb.getPassword());
			
			ps.setString(5, sb.getId());
			
			status = ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
	}
  	public static int getdeleteEmployee(String id)
  	{
  		int status = 0;
  		
  		try 
  		{
  			Connection con = Dao.getconnection();
  			
  			String sql = "delete from registration where id=?";
  			PreparedStatement ps = con.prepareStatement(sql);
  			ps.setString(1, id);
  			
  			status = ps.executeUpdate();
  			
  		}
  		catch (Exception e)
  		{
  			e.printStackTrace();
  		}
  		return status;
  			
  	}

}
