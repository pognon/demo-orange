package fr.company.demo.core.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {

	/** Contexte Spring */
	private static ApplicationContext ctx = null;

	/**
	 * Permet de récupérer le contexte Spring de l'application
	 * 
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}

	/**
	 * Permet de setter le contexte Spring et l'initialisation de l'application
	 */
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;
	}

}