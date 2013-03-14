package fr.company.demo.service.mobile.properties;

import org.apache.commons.configuration.FileConfiguration;

public abstract class AbstractCompositePropertiesFacade extends AbstractPropertiesFacade<FileConfiguration> {

	
	protected AbstractCompositePropertiesFacade(String propertiesName) {
		super(propertiesName);
	}

	@Override
	public FileConfiguration getProperties() {
		return PropertiesFactory.getInstance().getCompositeProperties(getPropertiesName());
	}
	
}
