package fr.company.demo.service.mobile.request.dto;

public class QueryDto {
	
	
	private String wsCallerId;
	private String timestamp;
	private String hash;
	
	
	
	public String getWsCallerId() {
		return wsCallerId;
	}
	public void setWsCallerId(String wsCallerId) {
		this.wsCallerId = wsCallerId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	

}
