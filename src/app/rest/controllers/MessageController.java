package app.rest.controllers;

import java.util.List;

import javax.ws.rs.Consumes;
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

import app.components.Message;
import app.entities.Quote;


@Path("/messageServer")
public class MessageController {
	
	Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private Message messageComponent;
	
	@POST
 @Path("/getQuote")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public Quote getQuote(
	        QuoteDTO parameterObject)
	{
		Quote q = messageComponent.selectQuote(parameterObject.getCategory(), parameterObject.getMessage());
		return q;
	}
}
	
	
