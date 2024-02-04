package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dto.Admin;
import dto.User;
@WebServlet("/userlogin")
public class UserLogin extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String mail=req.getParameter("email");
		String password=req.getParameter("password");
		Dao dao=new Dao();
		
		try 
		{
			User user=dao.findUserByEmail(mail);
			if(user!=null)
			{
				if(user.getUserpassword().equals(password))
				{
					if(user.getUsermail().equals(mail)) 
					{
						HttpSession session=req.getSession();
						session.setAttribute("username", user.getUsername());
						session.setAttribute("userid", user.getUserid());
						session.setAttribute("usermail", user.getUsermail());
						req.setAttribute("movies", dao.getAllMovies());
						RequestDispatcher rd1=req.getRequestDispatcher("userhome.jsp");
						rd1.include(req, resp);
					}
					
					else
					{
						req.setAttribute("message","password is wrong");
						RequestDispatcher rd2=req.getRequestDispatcher("ulogin.jsp"); 
						rd2.include(req, resp);
					}
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
			req.setAttribute("message", "enter valid credentials.");
			RequestDispatcher rd=req.getRequestDispatcher("ulogin.jsp");
			rd.include(req, resp);
		}
		
	}

}
