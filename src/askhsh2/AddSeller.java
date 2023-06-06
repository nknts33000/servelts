package askhsh2;

import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddSeller extends HttpServlet{
	Random random = new Random();
	byte bytes[]= new byte[20];
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		random.nextBytes(bytes);
		String salt=random.toString();
		Admin.AddSeller(req.getParameter("username"), req.getParameter("name"),req.getParameter("surname"), login.HashMD5(req.getParameter("password"), salt),salt);
	}
}
