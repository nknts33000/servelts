package askhsh2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class update extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res)
	
	{
		String str="";
		String str2="";
		if(req.getParameter("updt").equals("username"))str="username";
		else if(req.getParameter("updt").equals("name"))str="n_ame";
		else if(req.getParameter("updt").equals("surname"))str="surname";
		else if(req.getParameter("updt").equals("password"))str="password";
		String table_to_update="";
		if(GlobalVariables.current_user_property.equals("admin"))
			{
			table_to_update="admins";
			str2=GlobalVariables.current_admin.username;
			}
		else if(GlobalVariables.current_user_property.equals("seller"))
			{
			table_to_update="sellers";
			str2=GlobalVariables.current_seller.username;
			}
		else if(GlobalVariables.current_user_property.equals("client"))
			{
			table_to_update="clients";	
			str2=GlobalVariables.current_client.username;
			}
			
		{
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {
				
				Statement statement=null;
				System.out.println(req.getParameter("newdata"));
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","nikontounis");
				String query="update "+table_to_update+" set "+str+" ='"+req.getParameter("newdata")+"' where username='"+str2+"' ;";
				System.out.println(query);
				statement=con.createStatement();
				statement.executeUpdate(query);
				System.out.println(query);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}
	}

}
