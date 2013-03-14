package fr.company.demo.service.mobile.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.company.demo.core.service.IDemoService;
import fr.company.demo.service.mobile.exception.MobileServiceException;
import fr.company.demo.service.mobile.response.dto.UserDto;

@Controller
@RequestMapping(value = "/mobile")
public class MobileWebService /* implements IMobileWebService */{

	private static final Logger LOG = Logger.getLogger(MobileWebService.class
			.getName());

	@Autowired
	private IDemoService demoService;

	@RequestMapping(value = "/test/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	List<UserDto> doSomething(@PathVariable String id)
			throws MobileServiceException {

		LOG.info("Pognon Lorys.....");

		try {

			demoService.doSomething();
			UserDto user = new UserDto();

			List<UserDto> users = new ArrayList<UserDto>();

			for (int i = 0; i < 10; i++) {

				user = new UserDto();
				user.setLastname("Lastname_" + i);
				user.setFirstname("firstname_" + i);

				users.add(user);
			}

			return users;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
