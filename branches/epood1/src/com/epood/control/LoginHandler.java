/**
 * 
 */
package com.epood.control;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;


/**
 * @author Jaroslav Judin
 * Mar 9, 2010
 */
@SuppressWarnings("serial")
public class LoginHandler extends HttpServlet {

	  public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,
	      IOException {
	    res.setContentType("text/html");
	    PrintWriter out = res.getWriter();

	    String account = req.getParameter("username");
	    String password = req.getParameter("password");
	    String fullname;
	    
	    if(req.getParameter("logout") != null){
	    	req.getSession().invalidate();
	    	res.sendRedirect("/epood1");
	    } else if (( fullname = allowUser(account, password))=="") {
	      out.println("<HTML><HEAD><TITLE>Access Denied</TITLE></HEAD>");
	      out.println("<BODY>Your login and password are invalid.<BR>");
	      out.println("You may want to <A HREF=\"/epood1\">try again</A>");
	      out.println("</BODY></HTML>");
	    } else {
	      // Valid login. Make a note in the session object.
	      HttpSession session = req.getSession();

	      session.setAttribute("logon.isDone", account);
	      session.setAttribute("userName", fullname);
	      // Try redirecting the client to the page he first tried to access
	      try {
	        String target = (String) session.getAttribute("login.target");
	        System.out.println(target);
	        if (target != null) {
	          res.sendRedirect(target);
	          return;
	        }
	      } catch (Exception ignored) {
	      }

	      // Couldn't redirect to the target. Redirect to the site's home page.
	      res.sendRedirect("/epood1");
	    }
	  }

	  protected String allowUser(String account, String password) {
		  
		  return new com.epood.dao.UserDB().getUserFromDB(account, password);
	  }
	}

