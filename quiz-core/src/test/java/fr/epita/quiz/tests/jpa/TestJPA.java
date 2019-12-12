package fr.epita.quiz.tests.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.quiz.datamodel.Question;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestJPA {
	
	@Inject
	SessionFactory sessionFactory;
	
	
	@Test
	public void testHibernateSession() {
		//given sessionFactory
		
		//when
		Session session = sessionFactory.openSession();
		
		
		//then
		Assert.assertEquals(true,session.isConnected());
	}
	
	@Test
	public void testCreate() {
		//given sessionFactory
		String questionContent = "How to define a property in a maven pom file?";
		Question question = new Question(questionContent);
		
		//when
		Session session = sessionFactory.openSession();
		session.save(question);
		
		
		
		//then
		Question retrievedQuestion = session.get(Question.class, question.getId());
		Assert.assertEquals(questionContent,retrievedQuestion.getQuestionContent());
	}
	
	
	@Test
	public void testUpdate() {
		//given sessionFactory
		String questionContent = "How to define a property in a maven pom file?";
		String questionContentModified = "How to define a parent pom in maven?";
		Question question = new Question(questionContent);
		Session session = sessionFactory.openSession();
		session.save(question);
		
		//when
		question.setQuestionContent(questionContentModified);
		session.update(question);
		
		
		//then
		Question retrievedQuestion = session.get(Question.class, question.getId());
		Assert.assertEquals(questionContentModified,retrievedQuestion.getQuestionContent());
	}
	
	@Test
	public void testDelete() {
		//given sessionFactory
		String questionContent = "How to define a property in a maven pom file?";
	
		Question question = new Question(questionContent);
		Session session = sessionFactory.openSession();
		session.save(question);
		
		//when
		session.delete(question);
		
		
		//then
		Question retrievedQuestion = session.get(Question.class, question.getId());
		Assert.assertNull(retrievedQuestion);
	}
	
	@Test
	public void testSearch() {
		//given sessionFactory
		String questionContent = "How to define a property in a maven pom file?";
	
		Question question = new Question(questionContent);
		Session session = sessionFactory.openSession();
		session.save(question);
		
		//when
		Query<Question> searchQuery = 
				session.createQuery("from Question q where q.questionContent like :pContent", Question.class);
		
		searchQuery.setParameter("pContent", "%maven%" );
		List<Question> questionList = searchQuery.getResultList();
		
		//then
		List<String> notContainingMaven = new ArrayList<>();
		
		questionList.stream().forEach( q -> {
			if (q.getQuestionContent().contains("maven")){
				notContainingMaven.add("");
			}
		} );
		questionList.stream().forEach(new Consumer<Question>() {

			@Override
			public void accept(Question t) {
				// TODO Auto-generated method stub
				
			}
		});
		
		Assert.assertTrue(notContainingMaven.isEmpty());
		
		
		
		
	}
	
	

}
