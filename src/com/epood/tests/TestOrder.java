/**
 * 
 */
package com.epood.tests;

import com.epood.model.data.Order;
import com.epood.model.data.OrderItem;
import com.epood.model.data.Product;

import junit.framework.TestCase;

/**
 * @author Jaroslav Judin
 * Apr 26, 2010
 */
public class TestOrder extends TestCase {
	
	private Order order;
	private OrderItem item1;
	private OrderItem item2;
	private Product product1;
	private Product product2;
	
	public TestOrder(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		item1 = new OrderItem();
		item2 = new OrderItem();
		
		product1 = new Product();
		product2 = new Product();
		product1.setPrice(10);
		product2.setPrice(30);
		item1.setItemCount(2);
		item1.setProduct(product1);
		item2.setItemCount(1);
		item2.setProduct(product2);
		
		order = new Order();
		order.getOrderItems().add(item1);
		order.getOrderItems().add(item2);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		order = null;
		item1 = item2 = null;
		product1 = product2 = null;
	}


	public final void testGetOrderTotalPrice() {
		assertNotNull("order is not initialized", order);
		assertNotNull(product1);
		assertNotNull(product2);
		assertNotNull(item1);
		assertNotNull(item2);
		assertFalse("order has not items", order.getOrderItems().size()==0);
		//System.out.println(item1.getItemCount() +" "+ item1.getProduct().getPrice());
		//System.out.println(item2.getItemCount() +" "+ item2.getProduct().getPrice());
		assertEquals(order.getOrderTotalPrice(), 50, 0.00001);
	}

}
