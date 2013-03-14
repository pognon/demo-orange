package fr.company.demo.service.mobile;


import java.util.List;

import fr.company.demo.service.mobile.exception.MobileServiceException;
import fr.company.demo.service.mobile.response.dto.UserDto;


public interface IMobileWebService {
	
	
	public  List<UserDto> doSomething(String content) throws MobileServiceException;
	

}
