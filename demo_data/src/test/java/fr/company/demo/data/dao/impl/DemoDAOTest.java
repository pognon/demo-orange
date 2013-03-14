package fr.company.demo.data.dao.impl;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import fr.company.demo.data.dao.IDemoDAO;
import fr.company.demo.data.entity.DemoEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/context-data-test.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DbUnitTestExecutionListener.class })
@ActiveProfiles("relationalDB")
public class DemoDAOTest  {
	
	private static final Logger LOG = LoggerFactory.getLogger(DemoDAOTest.class);
	
	
	

	/** Interface de la DAO demoDAO */
	
	@Autowired
	private IDemoDAO demoDAO;
	

	public DemoDAOTest() {
	}

	/**
	 * Méthode appelée avant chaque test.
	 * 
	 * @throws Exception
	 *             si probleme.
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		//super.setUp();
	}

	/**
	 * Méthode appelée apres chaque test.
	 * 
	 * @throws Exception
	 *             si probleme.
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		// réinitailiser l'état de la base de données
	}

	/**
	 * Test de la méthode de création d'une personne
	 * 
	 * @throws ParseException
	 *             lié à la construction de la date de naissance
	 */
	@Test
	@DatabaseSetup("/dbunit/dataSet.xml")
	public void testSomething() throws Exception {

		try {
			
			List<DemoEntity> result = demoDAO.doSomethingFromDatabase();
			
			LOG.info("The result size is : " + result.size());

		}

		catch (Exception e) {
			// le test a échoué
			fail("Le Test a échoué " + e);
		}

	}
	
}
