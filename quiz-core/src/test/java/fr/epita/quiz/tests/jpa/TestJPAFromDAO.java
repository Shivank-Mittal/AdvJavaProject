package fr.epita.quiz.tests.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.QuestionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJPAFromDAO {
	
	
	@Inject
	QuestionDAO questionDAO;
	
//	@Inject
//	SessionFactory sf;
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	public void testCreate() {
		
		//test
		//given
		Question question = new Question("What is Dependency Injection ?");
		
		//QuestionDAO questionDAO = new QuestionDAO();
		//when
		questionDAO.create(question);
		
		
		//then
		
		Assert.assertNotNull(em.find(Question.class, question.getId()));
		
		
		
	}
	
	

}
