/**
 * 
 */
package com.epood.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epood.log.MyLogger;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public class MenuControllerFactory {

	public MenuController create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	       
		MenuController MenuController = null;
		   
	    try {
	    	if (request.getParameter("mode") != null) {
	    		if (request.getParameter("mode").equals("products")) {
	    			MenuController = new ProductMenuController();
			    }  else {
					MenuController = new ProductMenuController();
				}		
			} else {
				MenuController = new ProductMenuController();
			}
	        } catch (Exception ex) {
				MyLogger MyLogger = new MyLogger();
				MyLogger.Log("MenuControllerFactory.service():",ex.getMessage());
	        }
	     return MenuController;
	    }
	
}
