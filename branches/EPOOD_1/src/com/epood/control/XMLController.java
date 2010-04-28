package com.epood.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class XMLController implements Controller {

	static Logger log = Logger.getLogger(XMLController.class);
	
	@Override
	public String service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {		
		
		String view = null;
		
		if (request.getParameter("order") != null) {
			view = "XML";
		}
		
		return view;
	}
	

}