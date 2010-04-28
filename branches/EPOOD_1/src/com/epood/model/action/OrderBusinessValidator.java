/**
 * 
 */
package com.epood.model.action;

import com.epood.model.data.Order;

/**
 * @author Jaroslav Judin
 * Apr 23, 2010
 */
public class OrderBusinessValidator {

	public boolean checkPriceLimit(Order order) {
		double price = order.getOrderTotalPrice();
		if (price<100000)
			return true;
		else 
			return false;
	}
	
}
