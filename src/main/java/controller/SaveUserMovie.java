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
import dto.Movie;
import dto.User;

@WebServlet("/saveusermovie")
public class SaveUserMovie extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		Dao dao=new Dao();
		HttpSession session=req.getSession();
		String username  = (String) session.getAttribute("username");
		
		
		try 
		{
			if(username != null) {
				
			
			
			Movie m=dao.findMovieById(id);
			
			String mail=(String) session.getAttribute("usermail");
			User u=dao.findUserByEmail(mail);
	
			session.setAttribute("movieprice", m.getMovieprice());
			session.setAttribute("movieid", m.getMovieid());
			RequestDispatcher rs=req.getRequestDispatcher("payment.jsp");
			rs.include(req, resp);
			
			}
			else
			{	req.setAttribute("mes", "Access Denied");
				RequestDispatcher rs=req.getRequestDispatcher("ulogin.jsp");
				rs.include(req, resp);
				
			}
			
		} 
		catch (ClassNotFoundException | SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

