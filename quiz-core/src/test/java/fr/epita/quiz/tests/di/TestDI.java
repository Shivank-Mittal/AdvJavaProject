package fr.epita.quiz.tests.di;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestDI {
	
	@Inject
	@Named("firstQuery")
	String query;
	
	
	@Inject
	@Named("mainDS")
	DataSource ds;
	
	
	@Test
	public void testFirstIntegration() {
		Assert.assertNotNull(query);
		System.out.println(query);
	}
	
	@Test
	public void testDS() throws SQLException {
		//given ds
		//when
		Connection connection = ds.getConnection();
		String schema = connection.getSchema();
		
		//then
		System.out.println(schema);
		Assert.assertEquals("PUBLIC", schema);
		
		
		
		
	}

}
