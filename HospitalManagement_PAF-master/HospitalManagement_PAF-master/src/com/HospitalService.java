package com;


import model.Hospital;


//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
//import org.w3c.dom.Document;
//import org.w3c.dom.Document;

//For JSON
import com.google.gson.*;

import org.jsoup.nodes.Document;

@Path("/hospital")

public class HospitalService {
	HospitalService hospital = new HospitalService();

	
	  @GET
	 
	  @Path("/")
	  
	 @Produces(MediaType.TEXT_HTML)
	  
	  public String readHospital() {
		  return hospital.readHospital();
		  }
	 
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertHospital(
			@FormParam("hos_ID") String hos_ID,
			@FormParam("hos_name") String hos_name,
			@FormParam("hos_City") String hos_City,
			@FormParam("hos_hotline") String hos_hotline)

	{
		String output = hospital.insertHospital(hos_ID, hos_name, hos_City, hos_hotline);
		return output;
	}

	
	  @PUT
	  
	 @Path("/")
	  
	  @Consumes(MediaType.APPLICATION_JSON)
	  
	  @Produces(MediaType.TEXT_PLAIN) 
	  
	  public String updateHospital(String hos_data){
	  
	 JsonObject hospital1 = new JsonParser().parse(hos_data).getAsJsonObject();
	  
	 String hos_ID = hospital1.get("hos_ID").getAsString();
	 String hos_name = hospital1.get("hos_name").getAsString();
	 String hos_City = hospital1.get("hos_City").getAsString();
	 String hos_hotline =hospital1.get("hos_hotline").getAsString(); 
	 
	  String output = hospital.updateHospital(hos_ID, hos_name, hos_City, hos_hotline);
	 
	  return output;
	 
	  }
	  
	  
	  
	  @DELETE
	  
	  @Path("/")
	  
	  @Consumes(MediaType.APPLICATION_XML)
	  
	 @Produces(MediaType.TEXT_PLAIN) 
	  
	  public String deleteItem(String hos_data) {
	 
	  Document doc = Jsoup.parse(hos_data, "", Parser.xmlParser());
	  
	 
	  String hos_ID = doc.select("hos_ID").text();
	  String output = hospital.deleteItem(hos_ID);
	 
	  return output;
	
	  }
	 



}
