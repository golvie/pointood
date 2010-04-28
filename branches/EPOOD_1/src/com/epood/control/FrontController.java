/**
 * 
 */
package com.epood.control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * @author J
 *
 */
@SuppressWarnings("serial")
public class FrontController extends HttpServlet {

	Logger log = Logger.getLogger(this.getClass());
	
	public  void init(ServletConfig config) {
		try {
			super.init(config);
		} catch (ServletException e) {
			log.error(getServletInfo(), e);
		}		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ServletContext context = getServletConfig().getServletContext() ;
		
		ControllerFactory ControllerFactory  = new ControllerFactory ();
		Controller Controller = null;
		String view = null;
		
		if ( (Controller = ControllerFactory.create(request, response)) != null)
			view = Controller.service(request, response);
		if(view == null)
			view="catalog";
		if (request.getSession().getAttribute("user")==null)
			if (!view.equals("catalog") && !view.equals("product"))
				view = "catalog";
		ViewManager.navigate(view, request, response, context);
		
	}
	
	public String getServletInfo() {
		return "Epood application servlet";
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}
	
}
