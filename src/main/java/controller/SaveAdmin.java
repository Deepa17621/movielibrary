package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.Admin;
@WebServlet("/adminsignup")
public class SaveAdmin extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int id=Integer.parseInt(req.getParameter("aid"));
		String name=req.getParameter("aname");
		long contact=Long.parseLong(req.getParameter("acontact"));
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		
		Admin a=new Admin();
		a.setAdminid(id);
		a.setAdminname(name);
		a.setAdmincontact(contact);
		a.setAdminmail(mail);
		a.setAdminpassword(password);
		
		Dao dao=new Dao();
		try
		{
			int result=dao.saveAdmin(a);
			if(result>0)
			{
				RequestDispatcher rd=req.getRequestDispatcher("alogin.jsp");
				rd.include(req, resp);
			}
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("asignup.jsp");
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
