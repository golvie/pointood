/**
 * 
 */
package com.epood.control;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epood.dao.UserDB;
import com.epood.log.MyLogger;
import com.epood.model.domain.Customer;

/**
 * @author J
 *
 */
@SuppressWarnings("serial")
public class FrontController extends HttpServlet {

	private MyLogger MyLogger = new MyLogger();
	
	public  void init(ServletConfig config) {
		try {
			super.init(config);
			putLabels();
		} catch(Exception ex) {
			MyLogger.Log("FrontController.init():",ex.getMessage());
		}
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		ServletContext context = getServletConfig().getServletContext() ;
		
		String username = "";
		String passw = "";
		Customer MyUser = null ;
		
		if (req.getParameter("mode") != null) {
			if (req.getParameter("mode").equals("logout")) {
				HttpSession destroyable_session = req.getSession(false);

				if (destroyable_session != null) {
					destroyable_session.invalidate();
					//context.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
				}
			}
		}
		
		HttpSession session = req.getSession(true) ;
		
		if (session.getAttribute("user") != null ) {
			context.getRequestDispatcher("/jsp/customers.jsp").forward(req, res);
		} else {
			if (req.getParameter("kasutajanimi") != null) {
				username = req.getParameter("kasutajanimi");
			}

			if (req.getParameter("parool") != null) {
				passw = req.getParameter("parool");
			}
			System.out.println(username+", "+passw);
			if ((!(username.equals(""))) && (!(passw.equals("")))) {
				UserDB userAuth = new UserDB();
				MyUser = userAuth.getUserFromDB(username, passw);
				//System.out.println(MyUser.getFirstName());
				if (MyUser != null ) {
					session.setAttribute("user", MyUser.getCustomerId());
					session.setAttribute("username", MyUser.getUsername());
					session.setAttribute("first_name", MyUser.getFirstName());
					session.setAttribute("last_name", MyUser.getLastName());
					//view = "otsi_autot";
					//ViewManager.navigate(view,req,res,context);
					context.getRequestDispatcher("/jsp/customers.jsp").forward(req, res);
				}  else
					context.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
			} else
				context.getRequestDispatcher("/jsp/login.jsp").forward(req, res);
		} 
		
		
		/*String mode = req.getParameter("mode");
		if (mode == null) {
			context.getRequestDispatcher("/jsp/customers.jsp").forward(req, res);
		} else {
			if (mode.equals("customers")) {
				req.setAttribute ("servletName", "PageControl");
				context.getRequestDispatcher("/jsp/customers.jsp").forward(req, res);
			} else if (mode.equals("change_customer")) {
				req.setAttribute ("servletName", "PageControl");
				context.getRequestDispatcher("/jsp/changecustomer.jsp").forward(req, res);
			}
		}*/
	}
	
	public String getServletInfo() {
		return "Customers application servlet";
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doGet(request, response);
	}

	public void putLabels() {
      HashMap<String, String> labelMap = new HashMap<String, String>();
      ResourceBundle labels = ResourceBundle.getBundle("Labels");
      Enumeration bundleKeys = labels.getKeys();
      while (bundleKeys.hasMoreElements()) {
	       String key = (String)bundleKeys.nextElement();
	       String value = labels.getString(key);
	       labelMap.put(key, value);
	  }

      getServletConfig().getServletContext().setAttribute("labelMap",labelMap);

    }
	
}
