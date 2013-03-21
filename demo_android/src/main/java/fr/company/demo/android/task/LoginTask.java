package fr.company.demo.android.task;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import fr.company.demo.android.model.Login;
import fr.company.demo.android.util.Logger;



public class LoginTask extends GenericServerCommand{
	
	
	final String TAG = getClass().getName();
	
	
	private Login loginData;
	
	public LoginTask(Context activity, String commandToken) {
		
		super(activity, commandToken);
	
		Logger.log(TAG, "Creating a LogingTask...");
		
		
		
		this.mockFileName = "LoginResponse";
		this.fileName = "LoginResponse.plist";
		//this.objectKey = "loginDto";
		this.token = commandToken;
		//this.url = PropertyManager.getWSEndpointURI() + "/login";
		this.shouldPersistResponse = false;
		this.activity = activity;
		
	}
	
	
	@Override
	public List<?> parseData(String data) {
		
		Logger.log(TAG, "parseData..." + data);
		
		List<Login> logins = new ArrayList<Login>();
		Login login = null;
		
		try{
		
		Object json = new JSONObject(data);
		
		if(json instanceof JSONArray){
			
			JSONArray jsonArray = new JSONArray(data);
			for (int i = 0; i < jsonArray.length(); i++){
				
				json = jsonArray.getJSONObject(i);
				login = new Login();
				login.initWithJSONObject((JSONObject)json);
				
				logins.add(login);
			}

		}
		
		else{
			
			login = new Login();
			login.initWithJSONObject((JSONObject)json);
			logins.add(login);
		}
		
		}catch(Exception e){
			
		}
		
		return logins;
	}
	
	
	@Override
	public String buildRequestData(String wsCallerId, String hash,
			String timestamp) throws Exception{
		
		
		Logger.log(TAG, "buildRequestData...");
		
		if(loginData!=null){
			
			JSONObject json = new JSONObject();
			
			json.put("wsCallerId", wsCallerId);
			json.put("timestamp", timestamp);
			json.put("hash", hash);
			json.put("identifiant", loginData.getUsername());
			json.put("password", loginData.getPassword());
			
			return json.toString(2);
			
		}
		
		return null;
	}


	public Login getLoginData() {
		return loginData;
	}


	public void setLoginData(Login loginData) {
		this.loginData = loginData;
	}

}
