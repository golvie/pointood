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
        	
        	if (view.equals("catalog")) {
        		context.getRequestDispatcher("/jsp/products.jsp").forward(request, response);
        	} else if (view.equals("login")) {
        		context.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
        	} else if (view.equals("product")){
        		context.getRequestDispatcher("/jsp/product.jsp").forward(request, response);
        	} else if (view.equals("cart")){
        		context.getRequestDispatcher("/jsp/cartItems.jsp").forward(request, response);
        	} else if (view.equals("searchOrder")){
        		context.getRequestDispatcher("/jsp/OrdersForm.jsp").forward(request, response);
        	} else if (view.equals("orderItems")){
        		context.getRequestDispatcher("/jsp/orderItems.jsp").forward(request, response);
        	} else if (view.equals("searchProductsForm")){
        		context.getRequestDispatcher("/jsp/productSearchForm.jsp").forward(request, response);
        	} else if (view.equals("XML")){
        		context.getRequestDispatcher("/xml").forward(request, response);
        	}
        	
        } catch (Exception ex) {
			MyLogger MyLogger = new MyLogger();
			MyLogger.Log("ViewManager.navigate():",ex.getMessage());
        }

    }

}
