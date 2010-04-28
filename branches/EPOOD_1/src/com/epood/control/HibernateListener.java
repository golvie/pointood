/**
 * 
 */
package com.epood.control;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.epood.model.dao.HibernateUtil;

/**
 * @author Jaroslav Judin
 * Apr 19, 2010
 */
public class HibernateListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		HibernateUtil.getSession(); // Just call the static initializer of that class    
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		HibernateUtil.getSession().close(); // Free all resources
	}

	
	
}
