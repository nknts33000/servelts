package askhsh2;

public abstract class  User {
	public String username;
	public String name;
	public String surname;
	public String password;
	
public abstract void login();
	User(String unm,String nm, String snm, String passw)
	{
		username= unm;
		name = nm;
		surname = snm;
		password = passw;
	}
}
