/**
 * 
 */
package com.epood.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 2745584137380185063L;
	
	private int order;
	private int orderStatusType;
	private int customer;
	private String orderNumber;
	private Date updated;
	private Date customerConfirmed;
	private String note;
	private int orderType;
	private int shippingAddressId;
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
	 * @return the orderStatusType
	 */
	public int getOrderStatusType() {
		return orderStatusType;
	}
	/**
	 * @param orderStatusType the orderStatusType to set
	 */
	public void setOrderStatusType(int orderStatusType) {
		this.orderStatusType = orderStatusType;
	}
	/**
	 * @return the customer
	 */
	public int getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(int customer) {
		this.customer = customer;
	}
	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * @return the updated
	 */
	public Date getUpdated() {
		return updated;
	}
	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	/**
	 * @return the customerConfirmed
	 */
	public Date getCustomerConfirmed() {
		return customerConfirmed;
	}
	/**
	 * @param customerConfirmed the customerConfirmed to set
	 */
	public void setCustomerConfirmed(Date customerConfirmed) {
		this.customerConfirmed = customerConfirmed;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the orderType
	 */
	public int getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	/**
	 * @return the shippingAddressId
	 */
	public int getShippingAddressId() {
		return shippingAddressId;
	}
	/**
	 * @param shippingAddressId the shippingAddressId to set
	 */
	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
	
}
