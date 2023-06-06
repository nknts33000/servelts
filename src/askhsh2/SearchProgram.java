package askhsh2;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchProgram extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	 try
	 {
		 Statement statement=null;
		 Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","nikontounis");
		 String query = "Select * from programs Where program_name='"+req.getParameter("programname")+"';";
		 System.out.println(query);
		 statement = (Statement) con.createStatement();
		 ResultSet rs =  statement.executeQuery(query);
		 PrintWriter pr = res.getWriter();
		 if(rs.next())
		 {	 
			 String page="<form action='dltprogram'> <h3 >Program name :"+rs.getString(5) +"</h3><h3>Minutes   : "+rs.getInt(4)+"</h3><h3>Cost per month  :"+rs.getFloat(2)
					 +"</h3><h3>Cost per minute  :"+rs.getFloat(3)
					 +"</h3><input type='submit' value='delete'> </form>";
			 GlobalVariables.sellertodelete=rs.getString(4);
			 pr.println(page);
			 GlobalVariables.programtodelete=rs.getString(5);

		 }
		 else
		 {	
			 String page="<h2> program : "+req.getParameter("uname")+"  not found ! </h2>";
			 pr.println(page);
		 }
		 
	 }catch(Exception e)
	 {
		 System.out.println("exceptionnnnn :  "+e.toString());
	 }
	}

}
