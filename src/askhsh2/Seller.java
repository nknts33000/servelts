package askhsh2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Seller extends User {
	public float sallary;

	Seller(String unm, String nm, String snm, String passw,float slr) {
		super(unm, nm, snm, passw);
		sallary = slr;
	}

	@Override
	public void login() {
		
	}
	public static void AddClient(String uname,String nm, String snm,String pnum,String afm,String passwd,String salt)
	{
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			
			Statement statement=null;
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","123otinanai");
			String query="Insert Into Clients Values('"+uname+"','"+nm+"','"+snm+"','"+afm+"','"+pnum+"',0,1,'"+passwd+"',0,'"+salt+"');";
			statement=con.createStatement();
			statement.executeUpdate(query);
			System.out.println(query);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void DeleteClient(String uname)
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
			String query = "Delete from clients Where username='"+uname+"';";
			System.out.println(query);

			statement=con.createStatement();
			statement.executeUpdate(query);
			
		}catch( Exception e)
		{
			System.out.println("exception   !!!!");
		}
	}
	public static void DeleteProgram(String pname)
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
			String query = "Delete from programs Where program_name='"+pname+"';";
			System.out.println(query);

			statement=con.createStatement();
			statement.executeUpdate(query);
			
		}catch( Exception e)
		{
			System.out.println("exception   !!!!");
		}
	}
	public static void SetDebt(String username) throws SQLException, ClassNotFoundException
    {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/webapp","postgres","nikontounis");
		Statement st1= con.createStatement();
		Statement st2=con.createStatement();
		
		ResultSet rs=st1.executeQuery("Select * from clients where username='"+username+"'");
		int p_i=rs.getInt("program_id");
		int mins=rs.getInt("minutes_talk");
		rs=st1.executeQuery("Select * from programs where program_id="+p_i);
		float cost_per_month=rs.getFloat("cost_per_month");
		float cost_per_minute=rs.getFloat("cost_per_minute");
		int mins2=rs.getInt("minutes");
		if(mins2<=mins)
		{
			st2.executeUpdate("Update clients set debt="+cost_per_month+" where username="+username);
			
			
		}
		else
		{
			st2.executeUpdate("Update clients set debt="+cost_per_month+(mins2-mins)*cost_per_minute+" where username="+username);
			
		}
    }
	public static void ChangeClientProgram(String us,String pro_id) throws ClassNotFoundException, SQLException
	{

		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/webapp","postgres","nikontounis");
		Statement st1= con.createStatement();
		Statement st2= con.createStatement();
		ResultSet rs=st1.executeQuery("Select * from programs where program_name='"+pro_id+"'");
		int i=rs.getInt("program_id");
		st2.executeUpdate("Update clients set prtogram_id="+i+" where username='"+us+"'");
	}

}
