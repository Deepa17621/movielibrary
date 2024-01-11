package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao;
import dto.Movie;
@MultipartConfig(maxFileSize = 5*1024*1024)
@WebServlet("/updatemovie")
public class UpdateMovie extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double price=Double.parseDouble(req.getParameter("price"));
		double rating=Double.parseDouble(req.getParameter("rating"));
		String genre=req.getParameter("genre");
		String lang=req.getParameter("language");
		Part part=req.getPart("image");
		
		Movie m=new Movie();
		m.setMovieid(id);
		m.setMovivename(name);
		m.setMovieprice(price);
		m.setMovierating(rating);
		m.setMoviegenre(genre);
		m.setMovielang(lang);
		
		Dao dao=new Dao();
		
		try {
		
		if(part.getSize() > 0)
		{
			m.setMovieimage(part.getInputStream().readAllBytes());
			
			dao.updateMovie(m);
			
			req.setAttribute("movies", dao.getAllMovies());
			RequestDispatcher rd1=req.getRequestDispatcher("ahome.jsp");
			rd1.include(req, resp);
			
				
		}
		else 
		{
			Movie mm=dao.getPreviousMovie(id);
			
			m.setMovieimage(mm.getMovieimage());
			
			dao.updateMovie(m);
			req.setAttribute("movies", dao.getAllMovies());
			RequestDispatcher rd1=req.getRequestDispatcher("ahome.jsp");
			rd1.include(req, resp);
		
			
		}
		
					
	}catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}}

