/**
 * 
 */
package com.epood.model.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author Jaroslav Judin
 * Apr 19, 2010
 */
public class HibernateUtil {

	static Logger log = Logger.getLogger(HibernateUtil.class);
	
	private static SessionFactory sessionFactory;
	
    public static Session getSession() {
    	if (sessionFactory == null) {
    		try {
                // Create the SessionFactory from hibernate.cfg.xml
                sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
                log.info("sessionFactory created");
            } catch (Throwable ex) {
                // Make sure you log the exception, as it might be swallowed
                log.error("Initial SessionFactory creation failed !! " + ex);
                throw new ExceptionInInitializerError(ex);
            }
    	}
        return sessionFactory.getCurrentSession();
    }

	
}
