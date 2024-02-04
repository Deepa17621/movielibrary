package dao;

import java.io.FileNotFoundException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

import dto.Admin;
import dto.Movie;
import dto.User;



public class Dao
{
	public Connection getConnection() throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movielibrary", "root", "root");
		return conn;
	}
	public int saveAdmin(Admin a) throws SQLException, ClassNotFoundException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into admin values(?,?,?,?, ?)");
		
		pst.setInt(1, a.getAdminid());
		pst.setString(2,a.getAdminname());
		pst.setLong(3, a.getAdmincontact());
		pst.setString(4, a.getAdminmail());
		pst.setString(5, a.getAdminpassword());
		
		return pst.executeUpdate();
		
	}
	
	public Admin findByEmail(String email) throws ClassNotFoundException, SQLException
	{
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("select * from admin where amail=?");
			
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			Admin a=new Admin();
				rs.next();
				a.setAdminid(rs.getInt(1));
				a.setAdminname(rs.getString(2));
				a.setAdmincontact(rs.getLong(3));
				a.setAdminmail(rs.getString(4));
				a.setAdminpassword(rs.getString(5));
			
			return a;
	
	}
	
	public int saveMovie(Movie m) throws SQLException, ClassNotFoundException 
	{
		Connection con =getConnection();
		PreparedStatement pst=con.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
		
		pst.setInt(1, m.getMovieid());
		pst.setString(2, m.getMovivename());
		pst.setDouble(3, m.getMovieprice());
		pst.setDouble(4, m.getMovierating());
		pst.setString(5, m.getMoviegenre());
		pst.setString(6, m.getMovielang());
		//In Movie object image file datatype is byte[] ----we have to convert byte[] to blob
		//because in database image file's datatype is Blob
		//to convert byte[] to blod ......blob(java.sql) interface used here.
		Blob blob=new SerialBlob(m.getMovieimage());
		pst.setBlob(7, blob);
		return pst.executeUpdate();
	}
	public List<Movie> getAllMovies() throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from movie");
		ResultSet rs=pst.executeQuery();
		List<Movie> movies=new ArrayList<Movie>();
		
		while(rs.next())
		{
			Movie m=new Movie();
			m.setMovieid(rs.getInt(1));
			m.setMovivename(rs.getString(2));
			m.setMovieprice(rs.getDouble(3));
			m.setMovierating(rs.getDouble(4));
			m.setMoviegenre(rs.getString(5));
			m.setMovielang(rs.getString(6));
			Blob b=rs.getBlob(7);
			byte[] img=b.getBytes(1, (int)b.length());
			m.setMovieimage(img);
			
			movies.add(m);
		}
		return movies;
		
	}
	public int deleteMovies(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("delete from movie where id=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}
	public Movie findMovieById(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from movie where id=?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		Movie m=new Movie();
		rs.next();
			m.setMovieid(rs.getInt(1));
			m.setMovivename(rs.getString(2));
			m.setMovieprice(rs.getDouble(3));
			m.setMovierating(rs.getDouble(4));
			m.setMoviegenre(rs.getString(5));
			m.setMovielang(rs.getString(6));
			Blob b=rs.getBlob(7);
			byte[] img=b.getBytes(1, (int)b.length());
			m.setMovieimage(img);
		return m;
	}
	public int updateMovie(Movie m) throws ClassNotFoundException, SQLException
	{
		Connection con =getConnection();
		PreparedStatement pst=con.prepareStatement("update movie set name=?, price=?, rating=?, genre=?, language=?, image=? where id=?");
		pst.setString(1, m.getMovivename());
		pst.setDouble(2, m.getMovieprice());
		pst.setDouble(3, m.getMovierating());
		pst.setString(4, m.getMoviegenre());
		pst.setString(5, m.getMovielang());
		//In Movie object image file datatype is byte[] ----we have to convert byte[] to blob
		//because in database image file's datatype is Blob
		//to convert byte[] to blod ......blob(java.sql) interface used here.
		Blob blob=new SerialBlob(m.getMovieimage());
		pst.setBlob(6, blob);
		pst.setInt(7, m.getMovieid());
		return pst.executeUpdate();
	}
	public Movie getPreviousMovie(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from movie where id=?");
		
		pst.setInt(1, id);
		Movie mm=new Movie();
		ResultSet rs=pst.executeQuery();
		rs.next();
		Blob b=rs.getBlob(7);
		byte[] img=b.getBytes(1, (int)b.length());
		mm.setMovieimage(img);
		return mm;
		
	}
	public int saveUser(User u) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into user values(?,?,?,?, ?)");
		
		pst.setInt(1, u.getUserid());
		pst.setString(2,u.getUsername());
		pst.setLong(3, u.getUsercontact());
		pst.setString(4, u.getUsermail());
		pst.setString(5, u.getUserpassword());
		
		return pst.executeUpdate();
	}
	public User findUserByEmail(String email) throws ClassNotFoundException, SQLException
	{
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("select * from user where uMail=?");
			
			pst.setString(1, email);
			ResultSet rs=pst.executeQuery();
			User u=new User();
				rs.next();
				u.setUserid(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setUsercontact(rs.getLong(3));
				u.setUsermail(rs.getString(4));
				u.setUserpassword(rs.getString(5));
			
			return u;
	
	}
	public void saveUserMovie(int uid, String uname, int mid, String mname ) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement umPst=conn.prepareStatement("insert into user_movie values(?,?,?,?)");
		umPst.setInt(1, uid);
		umPst.setString(2, uname);
		umPst.setInt(3, mid);
		umPst.setString(4, mname);
		umPst.executeUpdate();
		
	}
	
	public List<Movie> getAllUserMovies(int uid) throws ClassNotFoundException, SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from movie inner join user_movie where user_movie.uid=? "
				+ "and movie.id = user_movie.mid");
		pst.setInt(1, uid);
		ResultSet rs=pst.executeQuery();
		List<Movie> movies=new ArrayList<Movie>();
		
		while(rs.next())
		{
			Movie m=new Movie();
			m.setMovieid(rs.getInt(1));
			m.setMovivename(rs.getString(2));
			Blob b=rs.getBlob(7);
			byte[] img=b.getBytes(1, (int)b.length());
			m.setMovieimage(img);
			
			movies.add(m);
		}
		return movies;		
	}
	
	public int deleteUserMovie(int movieid ) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement umPst=conn.prepareStatement("delete from user_movie where mid = ? ");
		
		umPst.setInt(1, movieid );
		
		return umPst.executeUpdate();
		
		
	}
	
}
