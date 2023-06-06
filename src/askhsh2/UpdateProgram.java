package askhsh2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateProgram
 */
@WebServlet("/UpdateProgram")
public class UpdateProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProgram() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		Class.forName("org.postgresql.Driver");
		Statement statement=null;
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","nikontounis");
		
		statement=con.createStatement();
		
		if(request.getParameter("tochange").equals("monthly cost")||request.getParameter("tochange").equals("extra cost per minute"))
		{
		String pr_name=request.getParameter("oldname");
		float new_cost=Float.parseFloat(request.getParameter("newattr"));
		if(request.getParameter("tochange").equals("monthly cost")) 
		{
			statement.executeUpdate("Update programs set cost_per_month="+new_cost+" where program_name='"+pr_name+"'");
		}
		else
		{
			statement.executeUpdate("Update programs set cost_per_minute="+new_cost+" where program_name='"+pr_name+"'");
		}
		}
		else if(request.getParameter("tochange").equals("minutes given by program")) 
		{
			String pr_name=request.getParameter("oldname");
			int mins=Integer.parseInt(request.getParameter("newattr"));
		}
		else
		{
			String pr_name=request.getParameter("oldname");
			String new_pr_name=request.getParameter("newattr");
		}
		}
		catch(Exception e)
		{}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
