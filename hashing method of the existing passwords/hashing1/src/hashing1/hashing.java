package hashing1;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class hashing {
	
	public static void main(String[] args)  {
		/*try {
		final String url="jdbc:postgresql://localhost/webapp";
		final String user="postgres";
		final String pass="nikontounis";
		Class.forName("org.postgresql.Driver");
		Connection con=DriverManager.getConnection(url,user,pass);
		insertMethod(con);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		} DO NOT RUUUUN!!!!!!!!!!! */
		
	}

	public static String HashMD5(String unhashed,String salt) {
        // Hash the password.
        final String toHash =  salt+ unhashed +salt ;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException ex) {
        	System.out.println("hi");
            return "00000000000000000000000000000000";
        }
        messageDigest.update(toHash.getBytes(), 0, toHash.length());
        String hashed = new BigInteger(1, messageDigest.digest()).toString(16);
        if (hashed.length() < 32) {
            hashed = "0" + hashed;
        }
        return hashed.toUpperCase();
    }
	
	public static void insertMethod(Connection c) 
	{
		try {
			
			
		String pass;
		String salt;
		String query;
		SecureRandom random = new SecureRandom();
		byte bytes[]= null;
		 
		Statement st1=c.createStatement();
		Statement st2=c.createStatement();
		ResultSet rs=st1.executeQuery("Select * from sellers");//same for admins and clients
		
		while(rs.next())
		{
			bytes=new byte[20];
			random.nextBytes(bytes);
			pass=rs.getString("password");
			salt=random.toString();
			query="Update sellers set password='"+HashMD5(pass,salt)+"',salt='"+salt+"'  where username='"+rs.getString("username")+"'";// same for admins and clients
			st2.executeUpdate(query);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
