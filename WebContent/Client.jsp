<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.Connection, java.sql.DriverManager,java.sql.ResultSet,java.sql.SQLException,java.sql.Statement"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Utf-8">
<title></title>
</head>
<body>
<% 

	HttpSession session1=request.getSession();
 	String clientname=session1.getAttribute("username").toString();
 	Class.forName("org.postgresql.Driver");
	Statement statement=null;
	
	Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webapp","postgres","nikontounis");
	
	statement=con.createStatement();
	ResultSet rs=statement.executeQuery("select * from clients where username='"+clientname+"'");
	rs.next();
	
 
%>
<h3>name: </h3><% out.println(rs.getString("n_ame"));%>
<h3>surname: </h3><% out.println(rs.getString("surname"));%>
<h3>afm: </h3><% out.println(rs.getString("afm"));%>
<h3>phone number: </h3><% out.println(rs.getString("phone_number"));%>


<form action="pay" method="get" >
<h3 name="debt">debt :</h3><%out.println(rs.getFloat("debt"));%>
<input type="button" value="pay" name="pay">
</form>
<h3>minutes spent: </h3><% out.println(rs.getString("minutes_talk"));%>
<h3>program: </h3><% rs=statement.executeQuery("select * from programs where program_id="+rs.getInt("program_id"));rs.next();out.println(rs.getString("program_name"));rs.close();%>
<form action="updatedata">
<h3>update</h3>
<select name="updt">
<option name="username" value="username">username</option>
<option name="name" value="name">name</option>
<option name="surname" value="surname">surname</option>
<option name="password" value="password">password</option>
</select>
<input type="text" name="newdata">
<input type="submit">
</form>

<form action="logoutofpage">
<input type="submit" value="log out">
</form>
<form action="showcalls">
<input type="submit" value="show calls">
</form>
</body>
</html>