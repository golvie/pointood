/**
 * 
 */
package com.epood.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epood.model.action.OrderAction;
import com.epood.model.data.Order;

/**
 * @author Jaroslav Judin
 * Apr 19, 2010
 */
public class CartController implements Controller {

	static Logger log = Logger.getLogger(CartController.class);
	private String view = null;
	private Order order;
	
	@Override
	public String service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		view = "cart";
		
		if (request.getParameter("clearAll")!=null) {
			if (request.getSession(true).getAttribute("current_order")!=null){
				((Order) request.getSession(true).getAttribute("current_order")).getOrderItems().clear();
			}
		} else if (request.getParameter("checkedProducts")!=null) {
			new OrderAction().removeCheckedItems(request);
		} else if (request.getParameter("submit")!=null && request.getParameter("customerAddressId")!=null) {
			new OrderAction().saveOrder(order, view, request); //view = 
		} else if (request.getParameter("productId")!=null
					&& request.getParameter("itemCount")!=null) {
			new OrderAction().insertOrUpdateOrder(order, request);
		}
		
		return view;
	}
	

}
