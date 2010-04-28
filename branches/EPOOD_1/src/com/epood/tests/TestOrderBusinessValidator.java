/**
 * 
 */
package com.epood.tests;

import com.epood.model.action.OrderBusinessValidator;
import com.epood.model.data.Order;
import com.epood.model.data.OrderItem;
import com.epood.model.data.Product;

import junit.framework.TestCase;

/**
 * @author Jaroslav Judin
 * Apr 26, 2010
 */
public class TestOrderBusinessValidator extends TestCase {

	private OrderBusinessValidator validator;
	private Order order1;
	private Order order2;
	private OrderItem item1;
	private OrderItem item2;
	private Product product1;
	private Product product2;

	public TestOrderBusinessValidator(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		product1 = new Product();
		product2 = new Product();
		product1.setPrice(50000);
		product2.setPrice(150000);
		item1 = new OrderItem();
		item2 = new OrderItem();
		item1.setProduct(product1);
		item1.setItemCount(1);
		item2.setProduct(product2);
		item2.setItemCount(1);
		order1 = new Order();
		order2 = new Order();
		order1.getOrderItems().add(item1);
		order2.getOrderItems().add(item2);
		validator = new OrderBusinessValidator();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		order1 = order2 = null;
		item1 = item2 = null;
		product1 = product2 = null;
		validator = null;
	}

	public final void testCheckPriceLimit() {
		assertNotNull(order1);
		assertNotNull(order2);
		assertNotNull(item1);
		assertNotNull(item2);
		assertNotNull(product1);
		assertNotNull(product2);
		assertEquals(order1.getOrderTotalPrice(), 50000, 0.00001);
		assertEquals(order2.getOrderTotalPrice(), 150000, 0.00001);
		assertTrue("these order total price must be less than 100000", validator.checkPriceLimit(order1));
		assertFalse("these order total price must be more than 100000", validator.checkPriceLimit(order2));
	}

}
