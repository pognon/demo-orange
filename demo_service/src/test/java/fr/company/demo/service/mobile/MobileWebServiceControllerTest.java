package fr.company.demo.service.mobile;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/context-webservice.xml" })
@WebAppConfiguration
@Transactional
public class MobileWebServiceControllerTest {

	private static final Logger LOG = Logger
			.getLogger(MobileWebServiceControllerTest.class.getName());
	
	
	 @Autowired
	    protected WebApplicationContext wac;
	    protected MockMvc mockMvc;

	    @Before
	    public final void onSetup() throws Exception {
	        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	    }

	
	  @Test public void doTestSomeController() throws Exception {
	  
	  LOG.info("doTestSomeController....");
	  
	  MvcResult result = mockMvc.perform(get("/mobile/test/1").accept(MediaType.APPLICATION_JSON))
			  .andDo(print()).andReturn();
	  
	  LOG.info("The response is : " + result.getResponse().getContentAsString());
			  
	 /*
	  .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	  .andExpect(content().string("Hello World!"));
	  */
	  
	  }
	 
}
