package fr.company.demo.android.util;


import android.util.Log;

public class Logger {
	
	public static void log(String flag, String message){
		if(PropertyManager.isLogEnabled())Log.v(flag, message);
		
	}

}
