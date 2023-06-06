package askhsh2;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchClient extends HttpServlet{
	
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
		 String query = "Select * from clients Where username='"+req.getParameter("uname")+"';";
		 System.out.println(query);
		 statement = (Statement) con.createStatement();
		 ResultSet rs =  statement.executeQuery(query);
		 PrintWriter pr = res.getWriter();
		 if(rs.next())
		 {	 
			 String page="<form action='dltclient'> <h3 name='username'>Username :"+rs.getString(1) +"</h3><h3>Name   : "+rs.getString(2)+"</h3><h3>Surname  :"+rs.getString(3)
					 +"</h3><h3>AFM  :"+rs.getString(4)
					 +"</h3><h3>Phone number  :"+rs.getString(5)
					 +"</h3><input type='submit' value='delete'> </form><form action='setdebt'><input type='submit' value='set debt'></form>";
			 GlobalVariables.clienttodelete=rs.getString(1);
			 pr.println(page);
		 }
		 else
		 {	
			 String page="<h2> client : "+req.getParameter("uname")+"  not found ! </h2>";
			 pr.println(page);
		 }
		 
	 }catch(Exception e)
	 {
		 System.out.println("exceptionnnnn :  "+e.toString());
	 }
 }

}
