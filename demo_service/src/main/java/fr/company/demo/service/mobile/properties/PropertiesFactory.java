package fr.company.demo.service.mobile.properties;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.FileConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;
import org.apache.log4j.Logger;

import fr.company.demo.service.mobile.exception.TechnicalException;



public final class PropertiesFactory implements ConfigurationListener {

	private static final Logger logger = Logger.getLogger( PropertiesFactory.class.getName());
	
	
	private static final PropertiesFactory INSTANCE = new PropertiesFactory();
	private final Map<String, Configuration> propertiesCompositeMap = new HashMap<String, Configuration>();
	
	
	private PropertiesFactory() {
		
	}
	
	public static PropertiesFactory getInstance() {
		return INSTANCE;
	}

	public void configurationChanged(ConfigurationEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public FileConfiguration getCompositeProperties(String propertiesName) {
		
		
		if (!propertiesCompositeMap.containsKey(propertiesName)) {
			initCompositeProperties(propertiesName);
		}

		if (!propertiesCompositeMap.containsKey(propertiesName)) {
			throw new TechnicalException("Impossible d'initialiser le CompositePropertiesManager '" + propertiesName + "'");
		}

		return (FileConfiguration)propertiesCompositeMap.get(propertiesName);
	}
	
	
	protected void initCompositeProperties(String propertiesName) {
		final String methodName = "initCompositeProperties";
		

		synchronized (propertiesCompositeMap) {
			if (propertiesCompositeMap.containsKey(propertiesName)) {
		
			} else {
				try{
					Configuration config = new PropertiesConfiguration("config/"+propertiesName);
					propertiesCompositeMap.put(propertiesName, config);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}

		
	}


}
