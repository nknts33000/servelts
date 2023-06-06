package askhsh2;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpAsAdmin extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		SecureRandom random = new SecureRandom();
		byte bytes[]=new byte[20];
		random.nextBytes(bytes);
		if(req.getParameter("password").equals(req.getParameter("password2")))
		{
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				
				Statement statement=null;
				String salt=random.toString();
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","nikontounis");
				String query="Insert Into admins (username,n_ame,surname,password,salary,salt) Values('"+req.getParameter("username")+"','"+req.getParameter("name")+"','"
				+req.getParameter("surname")+"','"+login.HashMD5(req.getParameter("password"), salt)+"',1000,'"+salt+"');";
				statement=con.createStatement();
				statement.executeUpdate(query);
				System.out.println(query);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
		else
		{
			System.out.println("kodikos lathos !!!");
		}
	}

}
