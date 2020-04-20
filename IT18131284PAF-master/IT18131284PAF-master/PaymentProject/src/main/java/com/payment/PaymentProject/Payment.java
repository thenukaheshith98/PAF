package com.payment.PaymentProject;

public class Payment {
	
	public String Patient_name;
	public String Doctor_name;
	public int Fee;
	public int id;
	
	
	public String getPatient_name() {
		return Patient_name;
	}
	public void setPatient_name(String patient_name) {
		Patient_name = patient_name;
	}
	public String getDoctor_name() {
		return Doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		Doctor_name = doctor_name;
	}
	public int getFee() {
		return Fee;
	}
	public void setFee(int fee) {
		Fee = fee;
	}
	@Override
	public String toString() {
		return "Payment [Patient_name=" + Patient_name + ", Doctor_name=" + Doctor_name + ", Fee=" + Fee + ", id=" + id
				+ "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
