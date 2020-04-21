package com.PAFHospitalManagamentSystem.PAFHospitalManagamentSystem;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import model.PAFHospitalManagamentSystem.Appointment;

public class AppointmnetRepository {
	
	Connection con =null;
	List<Appointment> appointment;
	public AppointmnetRepository() {
		
		String url ="jdbc:mysql://localhost:3306/appointmentapiproject?serverTimezone=UTC";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);	
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		appointment = new ArrayList<Appointment>();
		
		Appointment a1 = new Appointment();
		a1.setP_id(1);
		a1.setP_name("g.h. perera");
		a1.setP_age(34);
		a1.setType_of_case("fewer");
		a1.setD_name("nakawita i.m.");
		
		Appointment a2 = new Appointment();
		a2.setP_id(2);
		a2.setP_name("w.d.u perera");
		a2.setP_age(25);
		a2.setType_of_case("knee pain");
		a2.setD_name("kasthuri d.h");
		
		Appointment a3 = new Appointment();
		a3.setP_id(3);
		a3.setP_name("g.h. jenifer");
		a3.setP_age(18);
		a3.setType_of_case("migraine");
		a3.setD_name("premasiri r.n");
		
		
		appointment.add(a1);
		appointment.add(a2);
		appointment.add(a3);

		
	}
	
	public List<Appointment> getAllAppointments() {
		return appointment;
	}
	
	// view data function
	public String ViewAllAppointmnets() {
		String output = "";
		try {
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			// Prepare the html table to be displayed
			output = "<table border=\"1\"><tr><th>Patient ID</th><th>Patient Name</th><th>Patient Age</th><th>Type of Case</th><th>Doctor Name</th><th>Update</th><th>Remove</th></tr>";
			String query = "select * from appointmnets";				
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String p_id = Integer.toString(rs.getInt("p_id"));
				String p_name = rs.getString("p_name");
				String p_age =  Integer.toString(rs.getInt("p_age"));
				String type_of_case =rs.getString("type_of_case");
				String d_name =rs.getString("d_name");
				
				output += "<tr><td>" + p_id + "</td>";
				output += "<td>" + p_name + "</td>";
				output += "<td>" + p_age + "</td>";
				output += "<td>" + type_of_case + "</td>"; 
				output += "<td>" + d_name + "</td>";
				  
				// buttons
				  output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"
						  + "<td><form method=\"post\" action=\"Appointment.jsp\">"+"<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
						  + "<input name=\"drID\" type=\"hidden\" value=\"" + p_id
						  + "\">" + "</form></td></tr>";
							 }
							 con.close();
							 
							 output += "</table>";
		 }catch (Exception e)
		 {
			 output = "Error while reading the Appointment details .";
			 System.err.println(e.getMessage());
			 }
			 return output;
			}
		
	
	//insert data function
	public Appointment CreateAppointment(Appointment a1) {
		String insertSql = "INSERT INTO `appointmnets`(`p_id`, `p_name`, `p_age`, `type_of_case`, `d_name`) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(insertSql);
			st.setInt(1, a1.p_id);
			st.setString(2, a1.p_name);
			st.setInt(3, a1.p_age);
			st.setString(4, a1.type_of_case);
			st.setString(5, a1.d_name);
			
			st.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		return a1;
	}
	
	//update data function
	public Appointment updateAppointment(Appointment a1) {
		String updateSql = "UPDATE `appointmnets` SET `p_name`=?,`p_age`=?,`type_of_case`=?,`d_name`=? WHERE `p_id`=?";
		try {
			PreparedStatement st = con.prepareStatement(updateSql);
			
			st.setString(1, a1.p_name);
			st.setInt(2, a1.p_age);
			st.setString(3, a1.type_of_case);
			st.setString(4, a1.d_name);
			st.setInt(5, a1.p_id);
			
			st.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}

		
		return a1;
	}
	
	//delete data function
	public Appointment DeleteAppointment(Appointment a1) {
		String deleteSql = "DELETE FROM `appointmnets` WHERE `p_id`=?";
		try {
			PreparedStatement st = con.prepareStatement(deleteSql);
			
		
			st.setInt(1, a1.p_id);
			
			st.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}

		
		return a1;
	}
}

