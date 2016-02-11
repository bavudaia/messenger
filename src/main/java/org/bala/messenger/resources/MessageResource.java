package org.bala.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.bala.messenger.exceptions.DataNotFoundException;
import org.bala.messenger.model.Message;
import org.bala.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class MessageResource {
	private MessageService messageService = new MessageService();

	public MessageResource() {
		// TODO Auto-generated constructor stub

		//System.out.println("messageResource");
	}
	/*
	@POST

	public Message addMessage(Message message)
	{
		return messageService.addMessage(message);
	}
	*/
	
	@POST
	
	public Response addMessage(@Context UriInfo uriInfo, Message message)
	{   
		String selfUrl = getUrl(uriInfo);
		String profileUrl = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(message.getAuthor())
				.toString();
		
		Message responseMessage = messageService.addMessage(message,selfUrl,profileUrl);
		String newId = String.valueOf(responseMessage.getId());		
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		Response response = Response.created(uri).entity(responseMessage).status(Status.CREATED).build();
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int year,
						 			 @QueryParam("start") int start,
									 @QueryParam("length") int length)
	{ 
		if(year>0 || (start>0 || length>0))
		{
			return messageService.paginateMessages(start, length, year);
		}
		return messageService.getAllMessages();
	}


	@Path("/test")
	@GET
	public String test()
	{
		return "test method under messages for url messages/test";
	}

	@Path("/{messageId}")
	@GET
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) throws DataNotFoundException
	{
		Message message =  messageService.getMessage(messageId);
		/*String url = getUrl(uriInfo);
		String rel ="self";
		System.out.println(url);
		message.addLink(url, rel);*/
		return message;
	}
	
	private String getUrl(UriInfo uriInfo )
	{
		return uriInfo.getAbsolutePathBuilder().build().toString();
		
	}

	@Path("/{messageId}")
	@PUT
	public Message updateMessage(@PathParam ("messageId") long id, Message message)
	{
		//System.out.println(id+ "  :"+ message.getMessage());
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@Path("/{messageId}")
	@DELETE
	public Message removeMessage(@PathParam("messageId") long id)
	{
		return messageService.removeMessage(id); 
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}

}