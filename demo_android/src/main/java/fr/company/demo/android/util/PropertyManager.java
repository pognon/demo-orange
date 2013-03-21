package fr.company.demo.android.util;

import java.io.InputStream;
import java.util.Properties;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;

public class PropertyManager {

	private static PropertyManager instance;

	private static Properties properties;
	

	public PropertyManager(Activity activity) {
		try {
			
			Resources resources = activity.getResources();
			AssetManager assetManager = resources.getAssets();
			InputStream inputStream = assetManager.open("app.properties");
			properties = new Properties();
			properties.load(inputStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static PropertyManager getInstance(Activity activity) {
		if (null == instance) {
			instance = new PropertyManager(activity);
		}
		return instance;
	}
	
	public static String getProperty(String key){
		return properties.getProperty(key);
	}
	
	
	public static String getDefaultWSEndpointURI(){
		return  properties.getProperty("WSEndpointURI");
	}
	
	public static String getWSCallerId(){
		return properties.getProperty("WSCallerId");
	}
	
	public static String getWSCallerSecret(){
		return properties.getProperty("WSCallerSecret");
	}
	
	public static Boolean isMockEnabled(){
		return Boolean.valueOf(properties.getProperty("MockEnabled"));
	}
	
	public static Boolean isLogEnabled(){
		return Boolean.valueOf(properties.getProperty("LogEnabled"));
	}

}
