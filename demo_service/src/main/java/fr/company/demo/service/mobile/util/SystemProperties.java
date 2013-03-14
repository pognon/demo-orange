package fr.company.demo.service.mobile.util;

import fr.company.demo.service.mobile.properties.AbstractCompositePropertiesFacade;



public class SystemProperties extends AbstractCompositePropertiesFacade{
	
	private static final SystemProperties INSTANCE = new SystemProperties();

	/**
	 * Initialisation des properties du system.
	 */
	private SystemProperties() {
		super("system.properties");
	}

	
	public static String getWSCallerId(){
		return INSTANCE.getProperties().getString("wsCallerId");
	}
	
	public static String getWSCallerSecret(){
		return INSTANCE.getProperties().getString("wsCallerSecret");
	}
	
	public static String getWSCallCryptKey(){
		return INSTANCE.getProperties().getString("wsCallCryptKey");
	}
	
	
	public static boolean shouldReturnMockedData(){
		return INSTANCE.getProperties().getBoolean("shouldReturnMock");
	}
	
	
	public static boolean  isSessionTokenCheckEnabled(){
		return INSTANCE.getProperties().getBoolean("enableSessionTokenCheck");
	}

	public static int getMaxAllowedTimestampInterval() {
		return INSTANCE.getProperties().getInt("maxAllowedTimestampInterval");
	}
	
	
	
}
