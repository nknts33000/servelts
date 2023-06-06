package askhsh2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.security.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Addclient extends HttpServlet{
	Random random = new Random();
	byte bytes[]= new byte[20];
	 
	public void service(HttpServletRequest req, HttpServletResponse res)
	{	
		random.nextBytes(bytes);
		String salt=random.toString();
	Seller.AddClient(req.getParameter("username"), req.getParameter("name"), req.getParameter("surname"), req.getParameter("pnumber"), req.getParameter("afm2"), login.HashMD5(req.getParameter("password"), salt),salt);
	/*	
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
			Statement statement=null;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","123otinanai");
			String query="Insert Into Clients Values('"+req.getParameter("username")+"','"+req.getParameter("name")+"','"+req.getParameter("surname")
					+"','"+req.getParameter("afm2")+"','"+req.getParameter("pnumber")+"',0,1,'"+req.getParameter("password")+"');";
			statement=con.createStatement();
			statement.executeUpdate(query);
			System.out.println(query);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

}
