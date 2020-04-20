package com.payment.PaymentProject;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class PaymentRepositery {
	
	Connection con = null;
	List<Payment> pay;
	public List<Payment> PaymentRepositery() {
		
		 String url ="jdbc:mysql://localhost:3306/paymentproject";
		 String username = "root";
		 String password = "";
		 
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(url,username,password);
			 
		 } catch(Exception e){
			 System.out.println(e);
		 }
		
		pay = new ArrayList<>();
		
		Payment P1 = new Payment();
		
		P1.setPatient_name("Kiara");
		P1.setDoctor_name("Dr.Silva");
		P1.setFee(1000);
		P1.setId(120);
		
		Payment P2 = new Payment();
		P2.setPatient_name("Wishni");
		P2.setDoctor_name("Dr.Dias");
		P2.setFee(1000);
		P2.setId(108);
		
		Payment P3 = new Payment();
		P3.setPatient_name("Kushi");
		P3.setDoctor_name("Dr.Sanjana");
		P3.setFee(1200);
		P3.setId(196);
		
		pay.add(P1);
		pay.add(P2);
		pay.add(P3);
		
	    return pay;
		
	}
	
	public List<Payment> getAllPayment(){
		return pay;
		
	}
	
	public Payment createPayment(Payment P1) {
		String sql = "INSERT INTO 'payment'('Id', 'Patient_Name', 'Doctor_Name', 'Fee') VALUES (?,?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, P1.getId());
			st.setString(2, P1.getPatient_name());
			st.setString(3, P1.getDoctor_name());
			st.setFloat(4, P1.getFee());
			
			st.executeUpdate();
			
		}catch (Exception e){
			System.out.println(e);
		}
		
		pay.add(P1);
		System.out.println(pay);
		return P1;
		
	}
	
	public Payment updatePayment(Payment P1) {
		String sql = "UPDATE 'payment' SET 'Patient_Name'=?,'Doctor_Name'=?,'Fee'=? WHERE 'Id'=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, P1.getPatient_name());
			st.setString(2, P1.getDoctor_name());
			st.setFloat(3, P1.getFee());
			st.setInt(4, P1.getId());
			
			st.executeUpdate();

		} catch(Exception e){
			System.out.println(e);
		}
		return P1;
		
	}
	
	public Payment DeletePayment(Payment P1) {
		String sql = "DELETE FROM 'payment' WHERE'Id'=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, P1.getId());
			st.executeUpdate();

		} catch(Exception e){
			System.out.println(e);
		}
		return P1;
		
	}

	
}
