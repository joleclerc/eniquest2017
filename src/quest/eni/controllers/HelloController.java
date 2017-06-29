package quest.eni.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/hello")
public class HelloController {
	
//	@POST
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
//	public Response verifyLogin(@FormParam("login") String login, @FormParam("pw") String pw) {
		
		//Initialisation des obj
		Response response;
        Gson gson = new Gson();
        String coucou = "COUCOU C'EST MOI !";
                
        String json = gson.toJson(coucou);
        response = Response.ok()
        		.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(json).build();
        
        return response;
		
	}


}