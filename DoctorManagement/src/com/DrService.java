package com;

import model.Doctor;


//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;
//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;
@SuppressWarnings("unused")
@Path("/Doctor")


public class DrService {
	
	
	Doctor doctorObj = new Doctor();
	
	
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	
	public String readDoctor()
	{
		
	 return doctorObj.readDoctor();
	 
	}
	
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertItem(@FormParam("drdCode") String dCode,
	 @FormParam("drName") String dName,
	 @FormParam("drsSlary") String dsalary,
	 @FormParam("drSpecial") String dspecial)
	
	{
	 String output = doctorObj.insertDoctor(dCode, dName, dsalary, dspecial);
	 
	return output;
	}
	
	
	
	
	
	
	

}
