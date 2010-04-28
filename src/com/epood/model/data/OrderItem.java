/**
 * 
 */
package com.epood.model.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.epood.model.data.Product;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */


@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = 3325120894174470680L;
	
	@Id
	@Column(name = "order_item")
	@GeneratedValue
	private int orderItem;
	
	@Column(name = "order_")
	private int order;
	
	@Column(name = "product")
	private int productId;
	
	@Column(name = "item_count")
	private int itemCount;
	
	@ManyToOne
	@JoinColumn(name = "product", insertable = false, updatable = false)
	private Product product;
	
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
	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}
	
}
