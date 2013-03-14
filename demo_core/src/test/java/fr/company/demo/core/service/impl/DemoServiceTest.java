package fr.company.demo.core.service.impl;

import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.company.demo.core.service.IDemoService;
import fr.company.demo.data.dao.impl.DemoDAO;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/context-core.xml" }) 
@TransactionConfiguration( transactionManager="txManager", defaultRollback = true )
@Transactional
public class DemoServiceTest {
	
	
	@Autowired
	private IDemoService demoService;
	
	@Mock
	private DemoDAO demoDAO;
	
	
	
	
	@Before
	public void setUp() throws Exception {
		
		// intialisation des annotation Mockito
		MockitoAnnotations.initMocks(this);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testDoSomething() {
		
		
		try {
			
			when(demoDAO.doSomethingFromDatabase()).thenReturn(null);
			
			demoService.doSomething();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
