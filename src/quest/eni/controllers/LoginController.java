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
import quest.eni.entities.Stagiaire;
import quest.eni.resources.ReponseLogin;
import quest.eni.services.PersonneService;
import quest.eni.services.PersonneServiceImpl;

@Path("/login")
public class LoginController {
	
	private static PersonneService personneService = PersonneServiceImpl.getInstance();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response verifyLogin(@QueryParam("login") String login, @QueryParam("pw") String pw) {
		
		//Initialisation des obj
		Response response;
		boolean isValid = personneService.verifyLogin(login, pw);
		String rep = "";
		ReponseLogin repLog;
		Personne personne = null;
		
		if(isValid){
			personne = personneService.getStagOrForm(login);
			if(personne instanceof Formateur){
				System.out.println("L'id du formateur est : " + ((Formateur) personne).getIdFormateur());
				rep = "Je suis un formateur !";
			}else if(personne instanceof Stagiaire){
				System.out.println("L'id du stagiaire est : " + ((Stagiaire) personne).getIdStagiaire());
				rep = "Je suis un stagiaire !";
			}
			
		}else{
			rep = "L'identification a échoué";
		}
		
		repLog = new ReponseLogin(rep, personne);
		System.out.println(rep);
		
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
