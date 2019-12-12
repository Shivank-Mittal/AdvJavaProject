package fr.epita.quiz.tests.junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJunit {
	
	
	private static final Logger LOGGER = LogManager.getLogger(); 
	
	@BeforeClass
	public static void beforeAll() {
		LOGGER.info("beforeAll");
	}
	
	@Before
	public void prepareForEach() {
		LOGGER.info("beforeEach");
	}
	
	@Test
	public void firstSuccessTest() {
		LOGGER.info("testSucces");
		
	}
	@Test
	public void firstFailTest() {
		LOGGER.info("testFail");
		Assert.fail();
	}
	@Test
	public void firstErrorTest() {
		LOGGER.error("testError");
		int zero = 0;
		double other = 1/zero;
	}
	
	@After
	public void tearDownForEach() {
		LOGGER.info("afterEach");
	}
	
	@AfterClass
	public static void afterAll() {
		LOGGER.info("afterAll");
	}

}
