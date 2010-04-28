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
public interface Controller {
    public String service(HttpServletRequest request, HttpServletResponse response) 
    	throws ServletException, IOException;    
}
