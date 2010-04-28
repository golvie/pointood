/**
 * 
 */
package com.epood.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epood.model.dao.OrderDao;
import com.epood.model.data.Order;

/**
 * @author Jaroslav Judin
 * Apr 21, 2010
 */
public class SearchOrderController implements Controller {
	String view = null;
	@Override
	public String service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		view = "searchOrder";
		if (request.getParameter("orderId")!= null) {
			Order order = new OrderDao().getOrder(Integer.valueOf(request.getParameter("orderId")));
			request.setAttribute("order", order);
			view = "orderItems";
		}
		return view;
	}

}
