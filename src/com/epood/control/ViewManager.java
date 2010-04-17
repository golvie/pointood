/**
 * 
 */
package com.epood.control;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epood.log.MyLogger;

/**
 * @author Jaroslav Judin
 * Apr 16, 2010
 */
public class ViewManager {

	public static void navigate(String view, HttpServletRequest request, 
			HttpServletResponse response,ServletContext context) 
				throws ServletException, IOException  {

        try {
        	MyLogger MyLogger1 = new MyLogger();
		
        	if (view.equals("products")) {
        		context.getRequestDispatcher("/jsp/products.jsp").forward(request, response);
        	} else if (view.equals("login")) {
        		context.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        	}
        	
        } catch (Exception ex) {
			MyLogger MyLogger = new MyLogger();
			MyLogger.Log("ViewManager.navigate():",ex.getMessage());
        }

    }
	
	
}
