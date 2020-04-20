package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Hospital {

	private Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/Hospital", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public String insertHospital(String hos_ID, String hos_name, String hos_City, String hos_hotline) {
		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for inserting.";
			}

			String query = " insert into Hospital(`hospital_ID`,`hospital_Name`,`hospital_city`,'hospital_hotline')"
					+ " values (?, ?, ?, ?, ?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(1, hos_ID);
			preparedStmt.setString(2, hos_name);
			preparedStmt.setString(3, hos_City);
			preparedStmt.setString(4, hos_hotline);

			preparedStmt.execute();
			con.close();
			output = "Inserted successfully";
		} catch (Exception e) {
			output = "Error while inserting the Hospital.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	
	  public String readHospital() { String output = ""; try { Connection con =
	  connect(); if (con == null) {
		 return "Error while connecting to the database for reading."; }
	 
	 output = "<table border=\"1\"><tr><th>Hospital ID</th><th>Hospital Name</th><th>hospital_city</th><th>Hospital Hot-line</th><th>Update</th><th>Remove</th></tr>";
	 String query = "select * from Hospital";
	 Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query);
	  
	  while (rs.next()) { String hos_ID = rs.getString("Hospital ID"); String
	  hos_name = rs.getString("Hospital name"); String hos_City =  rs.getString("Hospital City");
	  String hos_hotline =rs.getString("Hospital Hot Line");
	  
	  output += "<tr><td>" + hos_ID + "</td>";
	  output += "<td>" + hos_name +"</td>";
	  output += "<td>" + hos_City + "</td>";
	  output += "<td>" + hos_hotline + "</td>"; 
	  
	  output +=  "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>" + "<td><form method=\"post\" action=\"hospital.jsp\">" +"<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">" + "<input name=\"hos_ID\" type=\"hidden\" value=\"" + hos_ID + "\">" +"</form></td></tr>"; } con.close();
	  
	  output += "</table>"; } catch (Exception e) { output = "Error while reading the Hospitals."; System.err.println(e.getMessage()); }
	 return output; }
	 
	 public String updateHospital(String hos_ID, String hos_name, String hos_City, String hos_hotline) 
	 { 
		 String output = "";
	  try 
	  { 
		  Connection con = connect();
	 
		  if (con == null)
		  { return "Error while connecting to the database for updating."; }
	  
	 String query ="UPDATE Hospital SET hos_name=?,hos_City=?,hos_hotline=?WHERE hos_ID=?";
	 
	
	  
	  PreparedStatement preparedStmt = ((java.sql.Connection) con).prepareStatement(query);
		 
	  
	  preparedStmt.setString(1,hos_ID); 
	  preparedStmt.setString(2,hos_name);
	  preparedStmt.setString(3, hos_City);
	  preparedStmt.setString(4 ,hos_hotline);
	  preparedStmt.setString(4,hos_ID);
	 
	  
	  preparedStmt.execute(); con.close(); output = "Updated successfully"; } catch
	  (Exception e) { output = "Error while updating the Hospital.";
	  System.err.println(e.getMessage()); } return output; }
	  
	  public String deleteHospital(String hos_ID) { String output = ""; try {
	  Connection con = connect(); if (con == null) { return
	  "Error while connecting to the database for deleting."; }
	  
	 String query = "delete from items where hos_ID=?"; PreparedStatement
	  preparedStmt = con.prepareStatement(query);
	  
	  preparedStmt.setString(1, hos_ID);
	 
	 preparedStmt.execute(); con.close(); output = "Deleted successfully"; } catch
	 (Exception e) { output = "Error while deleting the hospital.";
	 System.err.println(e.getMessage()); } return output; }
	 

}
