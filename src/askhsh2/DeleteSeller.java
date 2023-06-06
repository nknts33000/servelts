package askhsh2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteSeller extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res)
	{
		Admin.DeleteSeller(GlobalVariables.sellertodelete);
		
	}
	
	

}

