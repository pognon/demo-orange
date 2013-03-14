package fr.company.demo.service.mobile.properties;

import org.apache.commons.configuration.FileConfiguration;

public abstract class AbstractPropertiesFacade<P extends FileConfiguration> {
	
	private final String propertiesName;

	protected AbstractPropertiesFacade(String propertiesName) {
		this.propertiesName = propertiesName;
	}

	public String getPropertiesName() {
		return propertiesName;
	}

	/**
	 * @return le FileConfiguration
	 */
	public abstract P getProperties();

}
