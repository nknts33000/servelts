package askhsh2;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteClient extends HttpServlet{

	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		Seller.DeleteClient(GlobalVariables.clienttodelete);
	}
}
