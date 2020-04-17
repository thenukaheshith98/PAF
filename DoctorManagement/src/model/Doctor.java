package model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

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
	
	public String insertDoctor(String dcode, String dname, String dsalary, String dspecial)
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
		 return "Error while connecting to the database for inserting."; 
		 }
	 
	 // create a prepared statement
	
	 String query = " insert into Doctor(`drID`,`drdCode`,`drName`,`drsSlary`,`drSpecial`)"+ " values (?, ?, ?, ?, ?)";
	 
	 PreparedStatement preparedStmt = ((java.sql.Connection) con).prepareStatement(query);
	 
	 // binding values
	 
	 preparedStmt.setInt(1, 0);
	 preparedStmt.setString(2, dcode);
	 preparedStmt.setString(30, dname);
	 preparedStmt.setDouble(5, Double.parseDouble(dsalary));
	 preparedStmt.setString(20, dspecial); 
	 
	// execute the statement
	
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	 catch (Exception e)
	 {
	 output = "Error while inserting a Doctor .";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 }
	
	
	public String readDoctor()
	 {
	 String output = "";
	 try
	 {
	 Connection con = connect();
	 if (con == null)
	 {return "Error while connecting to the database for reading."; }
	
	 // Prepare the html table to be displayed
	 
	 output = "<table border=\"1\"><tr><th>Doctor Code</th><th>Doctor Name</th><th>Salary</th><th>Specilization</th><th>Update</th><th>Remove</th></tr>";
	 String query = "select * from doctor";
	 Statement stmt = ((java.sql.Connection) con).createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	
	 // iterate through the rows in the result set
	 
	 while (rs.next())
	 {
	 String drID = Integer.toString(rs.getInt("itemID"));
	 String drdCode = rs.getString("itemCode");
	 String drName = rs.getString("itemName");
	 String drsSlary = Double.toString(rs.getDouble("itemPrice"));
	 String drSpecial = rs.getString("itemDesc");
	 
	 // Add into the html table
	 
	 output += "<tr><td>" + drdCode + "</td>";
	 output += "<td>" + drName + "</td>";
	 output += "<td>" + drsSlary + "</td>";
	 output += "<td>" + drSpecial + "</td>";
	 
	 // buttons
	 
	 output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"items.jsp\">"+"<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
	 + "<input name=\"itemID\" type=\"hidden\" value=\"" + drID
	 + "\">" + "</form></td></tr>";
	 }
	 con.close();
	 
	 // Complete the html table
	 
	 output += "</table>";
	 }
	 
	 
	 
	 
	 catch (Exception e)
	 {
	 output = "Error while reading the items.";
	 System.err.println(e.getMessage());
	 }
	 return output;
	 } 
	
	
	
	

}
