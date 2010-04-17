/**
 * 
 */
package com.epood.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public class ProductMenuController implements MenuController {
	
	@Override
	public String service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String view=null;
		if (request.getParameter("catalogId") != null) {
			view = request.getParameter("catalogId");
		}
		
		return view;
	}

}
