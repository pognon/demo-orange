package fr.company.demo.core.service.impl;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import fr.company.demo.core.service.IDemoService;
import fr.company.demo.core.service.exception.ServiceException;
import fr.company.demo.data.dao.IDemoDAO;
import fr.company.demo.data.dao.impl.DemoDAO;
import fr.company.demo.data.exception.DAOException;


@Service
public class DemoService implements IDemoService {
	
	/** Logger */
	private static final Logger LOG = LoggerFactory.getLogger(DemoService.class);
	
	
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;
	
	
	
	@Autowired
	private IDemoDAO demoDAO;
	
	
	//@Transactional
	public void doSomething() throws ServiceException {
		// TODO Auto-generated method stub
		LOG.info("Service method doSomething is calling...");
	
		try {
			demoDAO.doSomethingFromDatabase();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

}
