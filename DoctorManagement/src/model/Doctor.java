package model;

import java.sql.DriverManager;

import com.sun.jdi.connect.spi.Connection;

public class Doctor {
	
	private Connection connect()

	 {
	 Connection con = null;
	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");

	 //Provide the correct details: DBServer/DBName, username, password
	 
	 con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "");
	 }
	 catch (Exception e)
	 {e.printStackTrace();}
	 return con;
	 }
	
	
	

}
