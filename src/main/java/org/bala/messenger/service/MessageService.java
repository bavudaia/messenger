package org.bala.messenger.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bala.messenger.database.DataBase;
import org.bala.messenger.exceptions.DataNotFoundException;
import org.bala.messenger.model.ErrorMessage;
import org.bala.messenger.model.Message;
public class MessageService {
	
	private Map<Long, Message> messages = DataBase.getMessages();
	public MessageService()
	{
		//System.out.println("MessageService Constructor");

	}
   public List<Message> getAllMessages()
   {
	   return new ArrayList<Message>(messages.values());
   }
   
   public List<Message> getMessagesByYear( int year)
   {
	   
	   Collection<Message> messColl = messages.values();
	   List<Message> messageList = new ArrayList<>();
	   System.out.println(year);
	   if(year == 0)
	   {
		   messageList = getAllMessages();
		   return messageList;
	   }
	   for(Message mess : messColl)
	   {
		   @SuppressWarnings("deprecation")
		   int messYear = mess.getCreated().getYear() + 1900;
		   if(messYear == year)
			   messageList.add(mess);
	   }
	   return messageList;
   }
   
   public List<Message> paginateMessages(int start, int length,int year)
   {
	   List<Message> messageList = null;
       messageList = getMessagesByYear(year);
       if(start == 0 && length == 0)
       {
    	   return messageList;
       }
	  List<Message> resultList = new ArrayList<>();
	  for(int i=start;i<start+length;i++)
	  {
		  resultList.add(messageList.get(i));
	  }
	  return resultList;
   }
   
   public Message getMessage(long id) throws DataNotFoundException
   {
	   Message message = messages.get(id);
	   if(message == null)
		   throw new DataNotFoundException(new ErrorMessage("Data Not Found Buddy",404,"www.error.com"));
	   return message;
   }
   //CREATE
   public Message addMessage(Message message,String selfUrl,String profileUrl)
   {
	   Set<Long> idSet = messages.keySet();
	   Iterator<Long> iter = idSet.iterator();
	   long maxId = 0 ;
	   while(iter.hasNext())
	   {
		   long id = iter.next();
		   if(id > maxId)
			   maxId = id;
	   }
	   long id = maxId+1;
	   message.setId(id);
	   selfUrl = selfUrl +"/"+ id;
	   message.addLink(selfUrl, "self");
	   message.addLink(profileUrl, "profile");
	   messages.put(id, message);
	   return message;
   }
   //UPDATE
   public Message updateMessage(Message message)
   {
	   if(!messages.containsKey(message.getId()))
		   return null;
	   System.out.println(message.getMessage());
	   messages.put(message.getId(),message);		   
	   return message;
   }
   //DELETE
   public Message removeMessage(long id)
   {
	   return messages.remove(id);
   }
}
