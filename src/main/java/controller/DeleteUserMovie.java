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

@WebServlet("/deletemoviemovie")
public class DeleteUserMovie extends HttpServlet
{
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			Dao dao = new Dao();
			
			HttpSession session = req.getSession();
			
			int movieid = Integer.parseInt(req.getParameter("id"));
			
			
			try {
								
					dao.deleteUserMovie(movieid);
					req.setAttribute("movies", dao.getAllMovies());
					RequestDispatcher rd1=req.getRequestDispatcher("userhome.jsp");
					rd1.include(req, resp);
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
		
		}
}
