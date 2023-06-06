package askhsh2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CreateProgram extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		Admin.CreateProgram(req.getParameter("pname"), req.getParameter("min"), req.getParameter("costmonth"), req.getParameter("costminute"));
	}
}
