package com.PAFHospitalManagamentSystem.PAFHospitalManagamentSystem;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.PAFHospitalManagamentSystem.Appointment;

@Path("/Appointments")

public class AppointmentResource {
	
	AppointmnetRepository ar = new AppointmnetRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appointment> getAllAppointment() {
		return ar.getAllAppointments();
		
	}
	
	@GET
	@Path("/Appointmentview")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Appointment ViewAllAppointmnet(Appointment a1){
		return ar.ViewAllAppointmnets(a1);
	}
	
	@POST
	@Path("/Appointment")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_HTML})
	public Appointment CreateAppointment(Appointment a1) {
		return ar.CreateAppointment(a1);
	}
	
	@PUT
	@Path("/AppointmentUpdate")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_HTML})
	public Appointment updateAppointment(Appointment a1) {
		return ar.updateAppointment(a1);
	}
	
	@DELETE 
	@Path("/Appointmentdelete")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_HTML})
	public Appointment DeleteAppointment(Appointment a1) {
		return ar.DeleteAppointment(a1);
	} 
	
}
