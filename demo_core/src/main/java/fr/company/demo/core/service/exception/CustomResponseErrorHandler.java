package fr.company.demo.core.service.exception;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;

public class CustomResponseErrorHandler implements ResponseErrorHandler {
	
	private static final Log log = LogFactory.getLog(CustomResponseErrorHandler.class);


	private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();

	public void handleError(ClientHttpResponse response) throws IOException {

	
		
		try {

			//errorHandler.handleError(response);

		} catch (RestClientException scx) {
			
			if (log.isInfoEnabled()) {
				log.info("Found error during webservice call..." + IOUtils.toString(response.getBody(), "UTF-8"));
			}

			//throw new CustomResponseException(response);
		}
	}

	public boolean hasError(ClientHttpResponse response) throws IOException {
		return errorHandler.hasError(response);
	}
}