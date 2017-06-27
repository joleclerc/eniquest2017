package quest.eni.controllers;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import quest.eni.entities.Formateur;
import quest.eni.entities.Personne;
import quest.eni.entities.Stagiaire;
import quest.eni.entities.Question;
import quest.eni.resources.ReponseLogin;
import quest.eni.services.PersonneService;
import quest.eni.services.PersonneServiceImpl;
import quest.eni.services.QuestionService;
import quest.eni.services.QuestionServiceImpl;

@Path("/question")
public class QuestionController {
	
private static QuestionService questionService = QuestionServiceImpl.getInstance();
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response getAllQuestion() {
		
		//Initialisation des obj
		Response response;
		List<Question> questions = questionService.getAllQuestion();
		
        Gson gson = new Gson();
                
        String json = gson.toJson(questions);
        
        response = Response.ok()
        		.header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .entity(json).build();
        
        return response;
	}
	
//	@GET
//	@Path("/edit")
//    @Produces(MediaType.APPLICATION_JSON)
//	public Response editQuestion(@QueryParam("idQuestion") int idQuestion) {
//		
//		//Initialisation des obj
//		Response response;
//		Question question = questionService.getQuestionById(idQuestion);
//		
//        Gson gson = new Gson();
//                
//        String json = gson.toJson(question);
//        response = Response.ok()
//        		.header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .header("Access-Control-Max-Age", "1209600")
//                .entity(json).build();
//        
//        return response;
//	}
//	
//	
//	@GET
//	@Path("/delete")
//    @Produces(MediaType.APPLICATION_JSON)
//	public Response deleteQuestion(@QueryParam("idQuestion") int idQuestion) {
//		
//		//Initialisation des obj
//		Response response;
//		int resDelete = questionService.deleteQuestion(idQuestion);
//		
//        Gson gson = new Gson();
//                
//        String json = gson.toJson(resDelete);
//        response = Response.ok()
//        		.header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .header("Access-Control-Max-Age", "1209600")
//                .entity(json).build();
//        
//        return response;
//	}
//	
//	@POST
//	@Path("/save")
//    @Produces(MediaType.APPLICATION_JSON)
//	public Response saveQuestion(@QueryParam("idQuestion") int idQuestion, 
//			@QueryParam("libelleQuestion") String libelleQuestion, 
//			@QueryParam("description") String description) {
//		
//		//Initialisation des obj
//		Response response;
//		Question question = new Question();
//		question.setIdQuestion(idQuestion);
//		question.setLibelleQuestion(libelleQuestion);
//		question.setDescription(description);
//		
//		this.questionService.saveQuestion(question);
//		
//        Gson gson = new Gson();
//                
//        String json = gson.toJson("TODO");
//        response = Response.ok()
//        		.header("Access-Control-Allow-Origin", "*")
//                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//                .header("Access-Control-Allow-Credentials", "true")
//                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
//                .header("Access-Control-Max-Age", "1209600")
//                .entity(json).build();
//        
//        return response;
//	}
	
}
