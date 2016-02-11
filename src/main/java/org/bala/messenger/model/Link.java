package org.bala.messenger.model;

public class Link {

	private String url;
	private String rel;
	
	
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Link(String url, String rel) {
		super();
		this.url = url;
		this.rel = rel;
	}


	public String getUrl() {
		return url;
	}
	
	
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
}
