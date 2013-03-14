package fr.company.demo.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.view.Viewable;

import fr.company.demo.web.model.User;

@Path("/controller")
public class Controller {

	@GET
	@Path("/index")
	public Response index(@Context HttpServletRequest request) {

		request.setAttribute("obj", new String("test"));
		
		
		try {
		
			// Do something
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		User user = new User();
		user.setName("Lorys");

		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("user", user);

		return Response.ok(new Viewable("/index", modelMap)).build();
	}
	
}
