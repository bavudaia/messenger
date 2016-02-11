package org.bala.messenger.resources;

import javax.ws.rs.CookieParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.QueryParam;

public class MessageFilterBean {
	private @MatrixParam("param") String matrixParam;
	private   @HeaderParam("customHeaderValue") String customHeaderValue;
	private   @CookieParam("name") String cookieName;
	private @QueryParam("id") int id;
	public String getMatrixParam() {
		return matrixParam;
	}
	public void setMatrixParam(String matrixParam) {
		this.matrixParam = matrixParam;
	}
	public String getCustomHeaderValue() {
		return customHeaderValue;
	}
	public void setCustomHeaderValue(String customHeaderValue) {
		this.customHeaderValue = customHeaderValue;
	}
	public String getCookieName() {
		return cookieName;
	}
	public void setCookieName(String cookieName) {
		this.cookieName = cookieName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
