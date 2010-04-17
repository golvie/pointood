/**
 * 
 */
package com.epood.model.domain;

import java.io.Serializable;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public class ProductCatalog implements Serializable {

	private static final long serialVersionUID = -4689558509929038452L;
	
	private int productCatalog;
	private int structUnit;
	private String name;
	/**
	 * @return the productCatalog
	 */
	public int getProductCatalog() {
		return productCatalog;
	}
	/**
	 * @param productCatalog the productCatalog to set
	 */
	public void setProductCatalog(int productCatalog) {
		this.productCatalog = productCatalog;
	}
	/**
	 * @return the structUnit
	 */
	public int getStructUnit() {
		return structUnit;
	}
	/**
	 * @param structUnit the structUnit to set
	 */
	public void setStructUnit(int structUnit) {
		this.structUnit = structUnit;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
