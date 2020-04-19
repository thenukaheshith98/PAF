package com.paf.patient.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.paf.patient.bean.Patient;

public class PatientDAO {
	
	public static Connection getConnection( ) {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HelthCare_patient", "root", "admin123");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static String registerPatient(Patient patient) {
		
		String output = null;
		
		try {
			Connection con = getConnection();
			
			String query = "insert into patient_registration values(?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, patient.getNic());
			ps.setString(2, patient.getFirstName());
			ps.setString(3, patient.getLastName());
			ps.setString(4, patient.getDob());
			ps.setString(5, patient.getGender());
			ps.setString(6, patient.getEmail());
			ps.setString(7, patient.getPassword());
			
			ps.executeUpdate();
			
			output = "Patient Register Successfully";
			
		} catch (Exception e) {
			e.printStackTrace();
			
			output = "Error in registration process";
		}
		
		return output;
		
	}
	
	public static String patientLogin(Patient patient) {
		
		String status = "invalid user";
		
		try {
			Connection con = getConnection();
			
			String query = "select patientPassword from patient_registration where email = ?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, patient.getEmail());
			
			ResultSet rs = ps.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("ddd");
				 if (patient.getPassword() == rs.getString("patientPassword") ) {
					 status = "valid user";
				 }
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public static String updatePatient(Patient patient) {
		String status = null;
		
		try {
			Connection con = getConnection();
			
			String queary = "update patient_registration set firstName=?, lastName=?, dob=?, gender=?,"
					+ "email=?, patientPassword=? where nic=?";
			
			PreparedStatement ps = con.prepareStatement(queary);
			
			ps.setString(1, patient.getFirstName());
			ps.setString(2, patient.getLastName());
			ps.setString(3, patient.getDob());
			ps.setString(4, patient.getGender());
			ps.setString(5, patient.getEmail());
			ps.setString(6, patient.getPassword());
			ps.setString(7, patient.getNic());
			
			ps.executeUpdate();
			
			status = "Patient Update Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			status = "Error in update process";
		}
		
		return status;
	}
	
	public static String deletePatient(Patient patient) {
		String status = null;
		
		try {
			Connection con = getConnection();
			
			String query = "delete from patient_registration where nic=?";
			
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, patient.getNic());
			
			ps.execute();
			
			status = "Patient deleted successfuly";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			status = "Error in deleting process.";
		}
		
		return status;
		
	}
	
	public static String patientList() {
		
		String output = "";
		
		try {
			Connection con = getConnection();
			
			output += "<head>\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\"\r\n" + 
					"integrity=\"sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh\" crossorigin=\"anonymous\">\r\n" + 
					"</head>" + 
					"<body>" +
					"<table border=\"1\"><tr><th>NIC</th>" + "<th>First Name</th><th>Last Name</th>" + "<th>Date of Birth</th>" +
					"<th>Gender</th>" + "<th>Email</th>" + "<th>Password</th>" + 
					"</body>";
			
			String query = "select * from patient_registration";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {
				String nic = rs.getString("nic");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String dob = rs.getString("dob");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String password = rs.getString("patientPassword");
				
				output += "<tr><td>" + nic + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + dob + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + password + "</td>";
				
				output += "</tr></table>";
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return output;
	}
	
}
