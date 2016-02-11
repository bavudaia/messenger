package org.bala.messenger.resources;


import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	public InjectDemoResource() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/annotations1")
	public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
							   @HeaderParam("customHeaderValue") String customHeaderValue,
							   @CookieParam("name") String cookieName
			)
	{
		System.out.println("matrix: " + ((matrixParam==null)?"null":matrixParam) + "\ncustomHeader:" +(( customHeaderValue==null)?"null":customHeaderValue)
				+ "cookie: " + ((cookieName==null)?"null":cookieName));
		return "matrixParam: " + ((matrixParam==null)?"null":matrixParam) + "\ncustomHeaderValue:" +(( customHeaderValue==null)?"null":customHeaderValue)
				+ "cookieName: " + ((cookieName==null)?"null":cookieName);
	}

	@GET
	@Path("/annotations2")
	public String getParamsUsingAnnotations(@BeanParam MessageFilterBean filterBean
			)
	{
		return "matrix: " + ((filterBean.getMatrixParam()==null)?"null":filterBean.getMatrixParam()) + "\ncustomHeader:" +(( filterBean.getCustomHeaderValue()==null)?"null":filterBean.getCustomHeaderValue())
				+ "\ncookie: " + ((filterBean.getCookieName()==null)?"null":filterBean.getCookieName())
				+"\nQuery: "	+ filterBean.getId()	
						;

	}	
	
	@GET
	@Path("/context")
	public String getAllParametersUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders header){
		String path = uriInfo.getAbsolutePath().toString();
		String headerData = header.getMediaType().getType();
		return path + headerData;
	}
}
