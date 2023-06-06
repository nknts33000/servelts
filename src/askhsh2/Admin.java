package askhsh2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin extends User{
	
	float sallary;
	Admin(String unm, String nm, String snm, String passw,float sall) {
		super(unm, nm, snm, passw);
		sallary=sall;
	}

	@Override
	public void login() {
		
		
	}
	public static void AddSeller(String unm, String nm, String snm,String pass,String salt )
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
			Statement statement=null;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","nikontounis");
			String query="Insert Into sellers (username,n_ame,surname,salary,password,salt) Values('"+unm+"','"+nm+"','"+snm+"',1000,'"+pass+"','"+salt+"');";
			statement=con.createStatement();
			statement.executeUpdate(query);
			System.out.println(query);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	public static void DeleteSeller(String uname)
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
			String query = "Delete from sellers Where username='"+uname+"';";
			statement=con.createStatement();
			statement.executeUpdate(query);
			
		}catch( Exception e)
		{
			System.out.println("exception   !!!!");
		}
	}
	public static void CreateProgram(String pname,String minutes,String cost_per_month,String cost_per_minute)
	{
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
			Statement statement=null;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","nikontounis");
			String query="Insert Into Programs (program_name,minutes,cost_per_month,cost_per_minute) Values('"+pname+"',"+minutes+","+cost_per_month+","+cost_per_minute+");";
			statement=con.createStatement();
			statement.executeUpdate(query);
			System.out.println(query);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
