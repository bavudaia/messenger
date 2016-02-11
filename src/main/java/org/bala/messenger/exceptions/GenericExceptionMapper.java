package org.bala.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.bala.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<NumberFormatException> {

	@Override
	public Response toResponse(NumberFormatException exception) {
		// TODO Auto-generated method stub
		Response response = Response.status(Status.BAD_REQUEST).entity(new ErrorMessage("Wrong Url pattern",500,"www2.error.new"))
				.build()	;
		return response;
	}
	
}
