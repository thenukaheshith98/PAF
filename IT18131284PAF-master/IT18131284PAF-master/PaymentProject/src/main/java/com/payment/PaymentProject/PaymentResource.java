package com.payment.PaymentProject;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Payments")
public class PaymentResource {
	
	PaymentRepositery PR = new PaymentRepositery();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Payment> getAllPayment(){
		return PR.getAllPayment();
	}
	
	@POST
	@Path("/Payment")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Payment createPayment(Payment P1) {
		return PR.createPayment(P1);
	}
	
	@PUT
	@Path("/Payment")
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Payment updatePayment(Payment P1) {
		return PR.updatePayment(P1);
		
	}
	
	@DELETE
	@Path("/Payment")
	@Consumes(MediaType.APPLICATION_JSON)

	public Payment DeletePayment(Payment P1){
		return PR.DeletePayment(P1);
		
		
	}
	
	
	
}