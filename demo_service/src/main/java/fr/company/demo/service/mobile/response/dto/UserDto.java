package fr.company.demo.service.mobile.response.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "user")
public class UserDto {
	
	
	private String firstname;
	private String lastname;
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	

}
