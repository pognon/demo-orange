package fr.company.demo.android.model;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

public class Login implements Serializable{
	
	    private boolean  logged ;
	    private String sessionToken;
	    private String username;
	    private String password;
	    
	    
	    
		public boolean isLogged() {
			return logged;
		}
		public void setLogged(boolean logged) {
			this.logged = logged;
		}
		public String getSessionToken() {
			return sessionToken;
		}
		public void setSessionToken(String sessionToken) {
			this.sessionToken = sessionToken;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
		
		public void initWithJSONObject(JSONObject json) throws JSONException{
			
			if(json.has("status")) this.logged = json.getBoolean("status");
			if(json.has("sessionToken"))this.sessionToken = json.getString("sessionToken");
			
		}
	    
	    
}
