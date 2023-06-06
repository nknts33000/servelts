package askhsh2;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

;/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 String property="";
		 HttpSession ses=request.getSession();
		 try {
			Class.forName("org.postgresql.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/webapp","postgres","nikontounis");
			Statement statement=(Statement) con.createStatement();
			try {
			String query1= "Select * from admins";// Where username='"+username+"' and password='"+password+"'";
			String query2= "Select * from sellers";// Where username='"+username+"' and password='"+password+"'";
			String query3= "Select * from clients";// Where username='"+username+"' and password='"+password+"'";
			statement=(Statement) con.createStatement();
			ResultSet rs1=statement.executeQuery(query1);
			boolean found=false;
			while(rs1.next()){
			if(rs1.getString(1).equals(username)&&rs1.getString(4).equals(HashMD5(password,rs1.getString(6)))) {
				found=true;
				//String name= rs1.getString(2) ;
				//String surname= rs1.getString(3) ;
				//PrintWriter out=response.getWriter();
				//out.println("<h2>"+username+"</h2>");
				RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
				request.setAttribute("1stlabel", "Username : "+rs1.getString(1));
				rd.forward(request,response);
				ses.setAttribute("username", username);
				ses.setAttribute("property", "Admin");
				break;
			}
			
			
			}
			rs1.close();
			ResultSet rs2=statement.executeQuery(query2);
			while(rs2.next())
			{	
				if(rs2.getString("username").equals(username)&&rs2.getString("password").equals(HashMD5(password,rs2.getString("salt")))) {
				response.sendRedirect("http://localhost:8080/askhsh2/Seller.html");
				found=true;
				ses.setAttribute("username", username);
				ses.setAttribute("property", "Seller");
				break;
				}
				
			}
			rs2.close();
			ResultSet rs3=statement.executeQuery(query3);
			
			while(rs3.next())
			{	
				if(rs3.getString(1).equals(username)&&rs3.getString(8).equals(HashMD5(password,rs3.getString(10)))) {
				response.sendRedirect("http://localhost:8080/askhsh2/Client.jsp");
				found=true;
				ses.setAttribute("username", username);
				ses.setAttribute("property", "Client");
				break;
				}
				
			}
			rs3.close();
			
			if(!found)
			{
				PrintWriter pr = response.getWriter();
				pr.println("<h1>NOT FOUND !!!!</h1>");
				
			}
			
			}
			catch(Exception e) {
				System.out.println("exeption  "+e);
			}
			
			
			
		 }
		 catch(Exception e) {e.printStackTrace();}
	}

	public static String HashMD5(String unhashed,String salt) {
        // Hash the password.
        final String toHash =  salt+ unhashed +salt ;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
        	
        	return "00000000000000000000000000000000";
        }
        messageDigest.update(toHash.getBytes(), 0, toHash.length());
        String hashed = new BigInteger(1, messageDigest.digest()).toString(16);
        if (hashed.length() < 32) {
            hashed = "0" + hashed;
        }
        return hashed.toUpperCase();
    }

}
