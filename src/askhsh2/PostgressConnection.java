package askhsh2;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostgressConnection extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		try
		{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","nikontounis");
			System.out.println("connect succesful");
		}
		catch(Exception e)
		{
			
			System.out.println(e);
		}
	}
	

}
