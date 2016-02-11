package org.bala.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Comment {
	private long id;
	private String comment;
	private Profile profile;
	private Date created;
	public Comment(){}
	
	
	public Comment(long id, String comment, Profile profile, Date created) {
		super();
		this.id = id;
		this.comment = comment;
		this.profile = profile;
		this.created = created;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}



}
