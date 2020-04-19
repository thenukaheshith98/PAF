package com;

import model.Doctor;




import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



import com.google.gson.*;



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
	
	public String insertDoctor(@FormParam("drdCode") String dCode,
			
	 @FormParam("drName") String dName,
	 @FormParam("drsSlary") String dsalary,
	 @FormParam("drSpecial") String dspecial)
	
	{
	 String output = doctorObj.insertDoctor(dCode, dName, dsalary, dspecial);
	 
	return output;
	}
	
	
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String updateDoctor(String doctorData)

	{
		

		
	 JsonObject docObj = new JsonParser().parse(doctorData).getAsJsonObject();
	 

	 
	 String drID = docObj.get("drID").getAsString();
	 String drCode = docObj.get("drCode").getAsString();
	 String drName = docObj.get("drName").getAsString();
	 String drsSlary = docObj.get("drsSlary").getAsString();
	 String drSpecial = docObj.get("drSpecial").getAsString();
	 
	 String output = doctorObj.updateDoctor(drID, drCode, drName, drsSlary, drSpecial);
	
	 return output;

	}

	
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	
	public String deleteDoctor(String doctorData)
	{
		

		
	 Document doc = Jsoup.parse(doctorData, "", Parser.xmlParser());


	 
	 String drID = doc.select("drID").text();
	 String output = doctorObj.deleteDoctor(drID);
	return output;
	}

	
	
	
	

}
