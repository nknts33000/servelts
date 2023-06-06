package askhsh2;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;





public class Client extends User {
	
	String AFM;
	String phonenumber;
	int program_id;
	float debt;
	float minutes_talk;

	Client(String unm, String nm, String snm, String passw,String afm,String phn) {
		super(unm, nm, snm, passw);
		AFM=afm;
		phonenumber = phn;
		program_id = 1;
		debt =0;
		minutes_talk =0;
	}

	public void login()
	{
		
	}
	
	public void SetUsername(String str)
	{
	username = str;
	}
	public void SetPassword(String str)
	{
	password = str;
	}
	public void SetName(String str)
	{
	name = str;
	}
	public void SetSurname(String str)
	{
	surname = str;
	}
	public static void Pay(String us) throws ClassNotFoundException, SQLException
	{
		Class.forName("org.postgresql.Driver");
		Statement statement=null;
		
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","nikontounis");
		
		statement=con.createStatement();
		statement.executeUpdate("Update clients set debt=0,minutes_talk=0 where username='"+us+"'");
	}
	
}
