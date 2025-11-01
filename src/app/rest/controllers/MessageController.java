package app.rest.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import app.components.MessageComponent;
import app.entities.Quote;


@Path("/messageServer")
public class MessageController {
	
	Logger logger = LoggerFactory.getLogger(MessageController.class);
	
	@Autowired
	private MessageComponent messageComponent;
	
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
	
	
