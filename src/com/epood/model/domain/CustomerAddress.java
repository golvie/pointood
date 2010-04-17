/**
 * 
 */
package com.epood.model.domain;

/**
 * @author J
 *
 */
public class CustomerAddress {

	private int customerAddress;
	
	private int customer;
	
	private String zip;
	
	private String house;
	
	private String address;
	
	private String county;
	
	private String townCounty;

	/**
	 * @return the customerAddress
	 */
	public int getCustomerAddress() {
		return customerAddress;
	}

	/**
	 * @param customerAddress the customerAddress to set
	 */
	public void setCustomerAddress(int customerAddress) {
		this.customerAddress = customerAddress;
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
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the house
	 */
	public String getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(String house) {
		this.house = house;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * @return the townCounty
	 */
	public String getTownCounty() {
		return townCounty;
	}

	/**
	 * @param townCounty the townCounty to set
	 */
	public void setTownCounty(String townCounty) {
		this.townCounty = townCounty;
	}
	
}
