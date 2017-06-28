package quest.eni.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import quest.eni.entities.Formateur;
import quest.eni.entities.Personne;
import quest.eni.resources.ReponseLogin;
import quest.eni.services.PersonneService;
import quest.eni.services.PersonneServiceImpl;

@Path("/login")
public class LoginController {
	
	private static PersonneService personneService = PersonneServiceImpl.getInstance();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response verifyLogin(@QueryParam("login") String login, @QueryParam("pw") String pw) {
		
		System.out.println("Entrée dans la méthode : verifyLogin() ");
		//Initialisation des obj
		Response response;
		boolean isValid = personneService.verifyLogin(login, pw);
		boolean isFormateur = false;
		ReponseLogin repLog;
		Personne personne = null;
		
		
		if(isValid){
			personne = personneService.getStagOrForm(login);
			if(personne instanceof Formateur){
				isFormateur = true;
			}
			personne.setMotDePasse(null);
		}
		
		repLog = new ReponseLogin(personne, isValid, isFormateur);
		
        Gson gson = new Gson();
                
        String json = gson.toJson(repLog);
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
