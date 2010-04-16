/**
 * 
 */
package com.epood.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Jaroslav Judin
 * Mar 9, 2010
 */
@SuppressWarnings("serial")
public class ProductController extends HttpServlet {

	public  void init() {	
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String mode = req.getParameter("mode");
		if (mode == null) {
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/customers.jsp").forward(req, res);
		} else {
			if (mode.equals("customers")) {
				req.setAttribute ("servletName", "PageControl");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/customers.jsp").forward(req, res);
			} else if (mode.equals("change_customer")) {
				req.setAttribute ("servletName", "PageControl");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/changecustomer.jsp").forward(req, res);
			}
		}
	}

	public String getServletInfo() {
		return "Products application servlet";
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException {
		doGet(request, response);
	}
}
