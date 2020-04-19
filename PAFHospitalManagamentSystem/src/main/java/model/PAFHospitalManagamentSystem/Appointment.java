package model.PAFHospitalManagamentSystem;

public class Appointment {
	public int p_id;
	public String p_name;
	public int p_age;
	public String type_of_case;
	public String d_name;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_age() {
		return p_age;
	}
	public void setP_age(int p_age) {
		this.p_age = p_age;
	}
	public String getType_of_case() {
		return type_of_case;
	}
	public void setType_of_case(String type_of_case) {
		this.type_of_case = type_of_case;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	@Override
	public String toString() {
		return "Appointment [p_id=" + p_id + ", p_name=" + p_name + ", p_age=" + p_age + ", type_of_case="
				+ type_of_case + ", d_name=" + d_name + "]";
	}
	
	
	
	
}
