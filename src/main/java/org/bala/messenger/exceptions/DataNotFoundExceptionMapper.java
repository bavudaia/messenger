package org.bala.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

	@Override
	public Response toResponse(DataNotFoundException exception) {
		// TODO Auto-generated method stub
		System.out.println("to response method in exception mapper");
		Response response = Response.status(Status.NOT_FOUND).entity(exception.getErrorMessage()).build();
		return response;
	}

}
