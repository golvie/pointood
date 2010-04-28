/**
 * 
 */
package com.epood.model.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.epood.model.dao.OrderDao;
import com.epood.model.dao.ProductDao;
import com.epood.model.data.Order;
import com.epood.model.data.OrderItem;
import com.epood.model.data.OrderType;

/**
 * @author Jaroslav Judin
 * Apr 23, 2010
 */
public class OrderAction {

	Logger log = Logger.getLogger(this.getClass());
	
	public String saveOrder(Order order, String view, HttpServletRequest request) {
		try {
	    	order = (Order) request.getSession(true).getAttribute("current_order");
	    	
	    	OrderBusinessValidator validator = new OrderBusinessValidator();
			if (validator.checkPriceLimit(order)) {
		    	int customerAddressIdParsed = Integer.valueOf(request.getParameter("customerAddressId"));
		    	int customer = (Integer) request.getSession(true).getAttribute("user");
		    	order.setCustomer(customer);
		    	order.setOrderType(OrderType.ORDER.getId());
		    	order.setOrderStatusType(OrderType.ORDER.getId());
		    	order.setShippingAddressId(customerAddressIdParsed);
		    	order.setCustomerConfirmed(new Date());
		    	new OrderDao().saveOrder(order);
		    	order.getOrderItems().clear();
		    	view = "searchOrder";
			} else {
				request.setAttribute("priceLimit", "The total price must be less than 100000.0");
				view = "cart";
			}
	    } catch (Exception e) {
	      log.error("Cannot save order...", e);
	    }
		
		return view;
	}
	
	public void removeCheckedItems(HttpServletRequest request) {
		String checkedItems = request.getParameter("checkedProducts");
		String[] checkedProductsArray = checkedItems.split(",");
		for (String productId : checkedProductsArray) {
			((Order) request.getSession(true).getAttribute("current_order"))
				.removeItem(Integer.valueOf(productId));
		}
	}
	
	public void insertOrUpdateOrder(Order order, HttpServletRequest request) {
		try {
			int productIdParsed = Integer.parseInt(request.getParameter("productId"));
			int itemCountParsed = Integer.parseInt(request.getParameter("itemCount"));
			if (itemCountParsed > 0) {
				if (request.getSession(true).getAttribute("current_order")!=null){
					order = (Order) request.getSession(true).getAttribute("current_order");
				} else {
					order = new Order();
				}
				
				if (order.containsItem(productIdParsed)) {
			        order.getOrderItem(productIdParsed).setItemCount(itemCountParsed);
				} else {
					OrderItem oi = new OrderItem();
			        oi.setItemCount(itemCountParsed);
			        oi.setProductId(productIdParsed);
			        oi.setProduct(new ProductDao().getProduct(productIdParsed));
			        order.getOrderItems().add(oi);
				}
				if (request.getSession(true).getAttribute("current_order")==null)
					request.getSession(true).setAttribute("current_order",order); // if order created first time
			}
		} catch (NumberFormatException e) {
			log.error("wrong input number of items amount");
		} catch (Exception e) {
			log.error(e);
		}
	}
	
}
