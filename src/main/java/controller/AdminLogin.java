package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Admin;
@WebServlet("/adminlogin") 
public class AdminLogin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String mail=req.getParameter("email");
		String password=req.getParameter("password");
		Dao dao=new Dao();
		
		try 
		{
			Admin admin=dao.findByEmail(mail);
			if(admin!=null)
			{
				if(admin.getAdminpassword().equals(password))
				{
					req.setAttribute("movies", dao.getAllMovies());
					RequestDispatcher rd1=req.getRequestDispatcher("ahome.jsp");
					rd1.include(req, resp);
				}
				else
				{
					req.setAttribute("message","password is wrong");
					RequestDispatcher rd2=req.getRequestDispatcher("alogin.jsp");
					rd2.include(req, resp);
				}
			}	
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch( SQLException e)
		{
			req.setAttribute("message", "email is wrong");
			RequestDispatcher rd=req.getRequestDispatcher("alogin.jsp");
			rd.include(req, resp);
		}
	}
}
