package fr.company.demo.core.service.exception;

import java.io.IOException;

import org.springframework.http.client.ClientHttpResponse;

public class CustomResponseException extends IOException {

	public CustomResponseException(ClientHttpResponse response) {
		// TODO Auto-generated constructor stub
	}

}
