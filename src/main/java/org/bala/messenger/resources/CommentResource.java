package org.bala.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.bala.messenger.exceptions.DataNotFoundException;
import org.bala.messenger.model.Comment;
import org.bala.messenger.service.CommentService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	CommentService commentService = new CommentService();
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) throws DataNotFoundException 
	{
		return commentService.getAllComments(messageId);
	}
	
	@Path("/{commentId}")
	@GET
	public Comment getComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) throws DataNotFoundException
	{
		System.out.println(messageId + "   "  + commentId);
		return commentService.getCommentById(messageId, commentId);
	}
}
