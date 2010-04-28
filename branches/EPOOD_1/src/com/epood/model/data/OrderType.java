/**
 * 
 */
package com.epood.model.data;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public enum OrderType {

	OFFER(1), ORDER(2);

	private int id;

	OrderType(final int id) {
	  this.id = id;
	}

	public int getId() {
	  return id;
	}
	
}
