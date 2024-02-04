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
@WebServlet("/payment")
public class Payment extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double amount=Double.parseDouble(req.getParameter("amount"));
		HttpSession session=req.getSession();
		Dao dao=new Dao();
		try 
		{
			Movie m=dao.findMovieById((int) session.getAttribute("movieid"));
			User u=dao.findUserByEmail((String) session.getAttribute("usermail"));
			if (m.getMovieprice()==amount)
			{
				dao.saveUserMovie(u.getUserid(), u.getUsername(), m.getMovieid(), m.getMovivename());
				req.setAttribute("movies", dao.getAllMovies());
				RequestDispatcher rs=req.getRequestDispatcher("userhome.jsp");
				rs.include(req, resp);
			}
			else 
			{
				RequestDispatcher rs=req.getRequestDispatcher("payment.jsp");
				rs.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
