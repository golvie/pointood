/**
 * 
 */
package com.epood.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epood.model.dao.CustomerDao;
import com.epood.model.data.Customer;

/**
 * @author Jaroslav Judin
 * Apr 18, 2010
 */
public class AuthenticationController implements Controller {

	private String username = "";
	private String passw = "";
	private Customer MyUser = null ;
	private String view = null;
	
	@Override
	public String service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if (request.getParameter("mode").equals("logout")) {
			HttpSession destroyable_session = request.getSession(false);
			if (destroyable_session != null) 
				destroyable_session.invalidate();
		}
		
		HttpSession session = request.getSession(true);
		
		if (request.getParameter("username") != null) {
			username = request.getParameter("username");
		}
		if (request.getParameter("password") != null) {
			passw = request.getParameter("password");
		}
		
		if ((!(username.equals(""))) && (!(passw.equals("")))) {
			MyUser = new CustomerDao().getAuthCustomer(username, passw);
			if (MyUser != null ) {
				session.setAttribute("user", MyUser.getCustomerId());
				session.setAttribute("username", MyUser.getFullName());
				view = "catalog";
			}  else
				view = "catalog";
		} else
			view = "catalog";
		
		return view;
	}

	
	
}
