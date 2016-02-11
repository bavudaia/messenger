package org.bala.messenger.service;

import java.util.ArrayList;
import java.util.List;

import org.bala.messenger.exceptions.DataNotFoundException;
import org.bala.messenger.model.Comment;
import org.bala.messenger.model.Message;

public class CommentService extends MessageService{
	
	public CommentService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Comment> getAllComments(long messageId) throws DataNotFoundException
	{
		Message message = getMessage(messageId);
		
		if(message == null)
		{
			return null;
		}
		return new ArrayList<>(message.getComments().values());
	}
	
	public Comment getCommentById(long messageId, long commentId) throws DataNotFoundException
	{
		return getMessage(messageId).getComments().get(commentId);
	}
}
