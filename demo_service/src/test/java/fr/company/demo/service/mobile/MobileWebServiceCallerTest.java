package fr.company.demo.service.mobile;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/context-webservice.xml" }) 
public class MobileWebServiceCallerTest {

	private static final Logger LOG  = Logger.getLogger(MobileWebServiceCallerTest.class.getName());
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public static final String WS_ENDPOINT = "http://localhost:8080/demo_service/webservice/mobile/test/1";
	//public static final String WS_ENDPOINT = "http://api.echoenabled.com/v1/search?q=scope:http://oddbb.free.fr/*&callback=foo&appkey=echo.echo.streamserver.oddbb.prod";
		
	@Test
	public void doSomethingWSCall() {
		
		
		// Create the object request
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<String> request = new HttpEntity<String>("data", headers);

		HttpEntity<String> response = restTemplate.exchange(WS_ENDPOINT,
				HttpMethod.GET, request, String.class);

		String resultString = response.getBody();
		
		LOG.info("The result is : " + resultString);
		
	}
	
	@Test
	public void testUsingDSL(){
		given().param("key1", "value1").param("key2", "value2").
		expect().body(containsString("OK")).
		when().post("/somewhere");
	}
	
	

}
