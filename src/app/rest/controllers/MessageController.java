package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.component.StrayAnimalComponent;
import app.component.SightingComponent;
import app.entities.Sighting;
import app.entities.StrayAnimal;


@Component
@Path("/strays")
public class StrayAnimalController {
	
	
	Logger logger = LoggerFactory.getLogger(StrayAnimalController.class);
		
	
	@Autowired
	private StrayAnimalComponent strayAnimal;
	
	@Autowired
	private SightingComponent sight;
	
	
	@POST
    @Path("/add")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Long addStray(
	        @FormParam("type") String type,
	        @FormParam("color") String color,
	        @FormParam("neutered") Boolean neutered,
	        @FormParam("description") String description) 
	{
		return strayAnimal.saveStray(type, color, neutered, description);
	}
	
	//REMOVE
	@POST
	@Path("/sighting/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Sighting addSighting(
			SightingDto parameterObject) 
	{
		Sighting s = sight.addSighting(parameterObject.getLocation(), parameterObject.getLatitude(), parameterObject.getLongitude(), parameterObject.getType(), parameterObject.getColor(), parameterObject.isNeutered(), parameterObject.getAnimalDescription(), parameterObject.getComment());
		return s;
	}
	
	@GET
	@Path("/bytype/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StrayAnimal> getByType(@PathParam("type") String type) {
		return strayAnimal.getByType(type);
	}

	@GET
	@Path("/neutered")
	@Produces(MediaType.APPLICATION_JSON)
	public List<StrayAnimal> getNotNeutered() {
		return strayAnimal.getNotNeutered();
	}
}
	
	
