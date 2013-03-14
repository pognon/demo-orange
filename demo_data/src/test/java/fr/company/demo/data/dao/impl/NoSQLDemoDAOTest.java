package fr.company.demo.data.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.company.demo.data.dao.IDemoDAO;
import fr.company.demo.data.entity.nosql.SimpleComment;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/context-data-test.xml" })
@ActiveProfiles("noSQLDB")
public class NoSQLDemoDAOTest {

	
	
private static final Logger LOG = LoggerFactory.getLogger( NoSQLDemoDAOTest.class);
	
	

	/** Interface de la DAO demoDAO */
	
	@Autowired
	private IDemoDAO demoDAO;
	

	public  NoSQLDemoDAOTest() {
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
	
	@Test
	public void addCommentToCassandra() throws Exception{

		SimpleComment simpleComment = new SimpleComment(1,"pognon lorys", "Just a test for kundera"); 
        
        demoDAO.addCommentToCassandra(simpleComment);
        
        
	}
	
	@Test
	public void getCommentFromCassandra() throws Exception{
		SimpleComment comment = demoDAO.getCommentsFromCassandra().get(0);
		LOG.info("The comment value is : " + comment.getCommentText());
	}
}
