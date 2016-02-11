package org.bala.messenger.database;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.bala.messenger.model.Comment;
import org.bala.messenger.model.Message;
import org.bala.messenger.model.Profile;

@SuppressWarnings("deprecation")
public class DataBase {
	private static Map<Long, Message>messages = new HashMap<>();
	private static Map<String, Profile>profiles = new HashMap<>();
	
	
	static
	{
		Date _2015 = new Date();
		Date _2016 = new Date();
		Date _2017 = new Date();
		_2015.setYear(115);
		_2016.setYear(116);
		_2017.setYear(117);
		
		
		/*Profile DB Dump*/
		Profile p1 =  new Profile("bala","Balamurugan","avudaiappan",_2016);
		Profile p2 =  new Profile("kun","Sergio","Aguero",_2017);
		Profile p3 =  new Profile("ceeni","sreeni","g",_2015);
		Profile p4 =  new Profile("santosh","sathosh","R",_2017);
		Profile p5 =  new Profile("harish","HARISH","K",_2017);
		Profile p6 =  new Profile("jammy","Shanmug","TR",_2017);
		Profile p7 =  new Profile("kavin","Kavin","Prakash",_2017);
		profiles.put("bala",p1);
		profiles.put("kun",p2);
		profiles.put("ceeni",p3);
		profiles.put("santosh",p4);
		profiles.put("harish",p5);
		profiles.put("jammy",p6);
		profiles.put("kavin",p7);
		
		
		
		/*Message DB Dump */
		Message m1 = new Message(1L,"hi",null,"Bala");
		Message m2 = new Message(2L,"hello",_2015,"Harish");
		Message m3 = new Message(3L,"hello Ji!",_2015,"Santhosh");
		Message m4 = new Message(4L,"hello Buddy!",_2016,"Ceeni");
		Message m5 = new Message(5L,"hello guys!",_2017,"Jammy");
		Message m6 = new Message(6L,"gm",_2015,"Bala");
		Message m7 = new Message(7L,"gud morning",_2015,"Harish");
		Message m8 = new Message(8L,"gud morning fellas!",_2015,"Santhosh");
		Message m9 = new Message(9L,"gud morning gud morning!",_2016,"Ceeni");
		Message m10 = new Message(10L,"good morning",_2017,"Jammy");
		

		Comment m1c1 = new Comment(1L,"poda mokka",p3,_2015);
		Comment m1c2 = new Comment(2L, "mooditu poda",p4,_2016);
		
		Map<Long,Comment> m1c = new HashMap<>();
		m1c.put(1L, m1c1);
		m1c.put(2L, m1c2);
		
		
		m1.setComments(m1c);
		
		messages.put(1L,m1);
		messages.put(2L ,m2);
		messages.put(3L ,m3);
		messages.put(4L ,m4);
		messages.put(5L ,m5);
		messages.put(6L ,m6);
		messages.put(7L ,m7);
		messages.put(8L ,m8);
		messages.put(9L ,m9);
		messages.put(10L ,m10);
		
		/*Comments in Messages*/
		

		
		
	}
	public DataBase(){
		System.out.println("database constructor");

	}
	
	public static Map<Long,Message> getMessages()
	{
		return messages;
	}
	public static Map<String,Profile> getProfiles()
	{
		return profiles;
	}
}
