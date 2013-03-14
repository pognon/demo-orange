package fr.company.demo.service.mobile;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.company.demo.core.service.impl.DemoService;
import fr.company.demo.data.dao.impl.DemoDAO;
import fr.company.demo.data.entity.DemoEntity;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/context-service.xml" }) 
public class MobileServiceCallerTest {

	private static final Logger LOG = Logger
			.getLogger(MobileServiceCallerTest.class.getName());

	@Autowired
	@InjectMocks
	DemoService demoService;

	@Mock
	DemoDAO demoDAO;
	

	@Before
	public void setUp() throws Exception {
		
		// intialisation des annotation Mockito
		MockitoAnnotations.initMocks(this);
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void doSomething() {

		try {
			
			LOG.info("Hello...");
			
			List<DemoEntity> tmp = new ArrayList<DemoEntity>();
			when(demoDAO.doSomethingFromDatabase()).thenReturn(tmp);
			demoService.doSomething();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
