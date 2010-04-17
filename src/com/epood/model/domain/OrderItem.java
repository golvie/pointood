/**
 * 
 */
package com.epood.model.domain;

import java.io.Serializable;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 3325120894174470680L;
	
	private int orderItem;
	private int order;
	private int productId;
	private int itemCount;
	
	/**
	 * @return the orderItem
	 */
	public int getOrderItem() {
		return orderItem;
	}
	/**
	 * @param orderItem the orderItem to set
	 */
	public void setOrderItem(int orderItem) {
		this.orderItem = orderItem;
	}
	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}
	/**
	 * @return the itemCount
	 */
	public int getItemCount() {
		return itemCount;
	}
	/**
	 * @param itemCount the itemCount to set
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
}
