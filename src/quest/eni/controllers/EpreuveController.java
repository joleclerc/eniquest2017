package quest.eni.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import quest.eni.entities.Epreuve;
import quest.eni.services.EpreuveService;
import quest.eni.services.EpreuveServiceImpl;

@Path("/epreuves")
public class EpreuveController {
	
	private static EpreuveService epreuveService = EpreuveServiceImpl.getInstance();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllEpreuve() {
		
		//Initialisation des obj
		Response response;
		List<Epreuve> epreuves = epreuveService.getAllEpreuve();
		
        Gson gson = new Gson();
                
        String json = gson.toJson(epreuves);
        
        response = Response.ok()
        		.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(json).build();
        
        return response;
	}
	
	@GET
	@Path("/details")
    @Produces(MediaType.APPLICATION_JSON)
	public Response getDetailsEpreuve(@QueryParam("idEpreuve") int idEpreuve) {
		
		//Initialisation des obj
		Response response;
		Epreuve epreuve = epreuveService.getEpreuveDetailsById(idEpreuve);
		
        Gson gson = new Gson();
                
        String json = gson.toJson(epreuve);
        
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
