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
import dto.User;
@WebServlet("/usersignup")
public class UserSignUp extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long contact=Long.parseLong(req.getParameter("contact"));
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		
		User u=new User();
		u.setUserid(id);
		u.setUsername(name);
		u.setUsercontact(contact);
		u.setUsermail(mail);
		u.setUserpassword(password);
		
		Dao dao=new Dao();
		try
		{
			int result=dao.saveUser(u);
			if(result>0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("ulogin.jsp");
				rd.include(req, resp);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("usignup.jsp");
				rd.include(req, resp);
			}
			
		} 
		
		catch (ClassNotFoundException | SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
