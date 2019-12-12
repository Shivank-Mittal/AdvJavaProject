package fr.epita.quiz.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;

import com.sun.research.ws.wadl.Option;

import fr.epita.quiz.datamodel.Options;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.OptionDAO;
import fr.epita.quiz.services.QuestionDAO;

@Path("/questions/")

public class QuestionResource {
	
	
	@Inject
	QuestionDAO dao;
	
	@Inject
	OptionDAO optionDAO;
	
	private static final Logger LOGGER = LogManager.getLogger(QuestionResource.class);
	
	
	@POST
	@Path("/create/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createQuestion(@RequestBody Question question) throws URISyntaxException {
		LOGGER.debug("entering => createQuestion() with parameters : {} ", question);
		//create a question 
		dao.create(question);
		LOGGER.info("received creation order for question : {}",  question);
		return Response.ok(question.getId()).build();
	}
	
	@POST
	@Path("/create/option/")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createOptinons(@RequestBody Options options)throws URISyntaxException {
		System.out.println("Reached To post methord");
		optionDAO.create(options);
		System.out.println("Id : "+  options.getQuestionId() +"\n Option : "+options.getOptions()+" \n CorrectOption : " + options.isCorrectOption() + 
				"questionId : "+options.getQuestionId());
		return Response.ok(options.getId()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getQuestionById(@PathParam("id") int id) {
		//create a question 
		Question question = dao.getById(id, Question.class);
		
		return Response.ok(question).build();
	}

	
	@GET
	@Path("searchContent/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchQuestions(@QueryParam("qContent") String questionContent) {
		//create a question 
		List<Question> searchList = dao.search(new Question(questionContent));
		return Response.ok(searchList).build();
	}
	
	@GET
	@Path("getAllQuestions/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllQuestions() {
		//create a question 
		List<Question> searchList = dao.getAll(new Question());
		return Response.ok(searchList).build();
	}
	
	@POST
	@Path("/delete")
	public void deleteQuestions(@RequestBody int id) {
		dao.delete(id,Question.class);
	}
	
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response UpdateQuestions( @PathParam("id")int id,  @RequestBody Question question) {
		
		System.out.println("testing update" + id + "\n "+question.getQuestionContent());
		
		
		Question updatedQuestion = dao.getById(id, Question.class);
		
		updatedQuestion.setQuestionContent(question.getQuestionContent());
		
		dao.update(updatedQuestion);
		
		return Response.ok().build();
		
	}
	
	
	@GET
	@Path("/optionList/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response optionsList(@QueryParam("questionID") int questionID) {
		//create a question 
		Options option = new Options();
		option.setQuestionId(questionID);
		List<Options> optionList = optionDAO.search(option);
		return Response.ok(optionList).build();
	}
	

}
