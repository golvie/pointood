package com.epood.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.epood.model.data.Customer;
import com.epood.model.data.CustomerAddress;


public class CustomerDao {
	
	/*String sql = "" ;
	Connection connection ;
	ResultSet QueryResult ;
	*/
	Logger log = Logger.getLogger(this.getClass());
	
	/*public Customer  getAuthCustomer(String username, String passw) {
		MyLogger log = new MyLogger();
		Customer customer = null;
		try {
			connection = new DBconnection().getConnection();
			sql = "select username, passw, first_name, last_name, c.customer  from cst_user as u inner join customer as c on c.customer=u.customer where username like '" + username + "' and passw like md5('"+passw+"')" ;
			QueryResult = connection.createStatement().executeQuery(sql);
			
			while(QueryResult.next()) {
				customer = new Customer();
				customer.setFirstName(QueryResult.getString("first_name"));
				customer.setLastName(QueryResult.getString("last_name"));
				customer.setUsername(QueryResult.getString("username"));
				customer.setPassword(QueryResult.getString("passw"));
				customer.setCustomerId(Integer.valueOf(QueryResult.getString("customer")));
			}
	        connection.close();
	    } catch(NumberFormatException ex) {
			log.Log("GetUser - parse Id", "Wrong Id");
		} catch (SQLException e) {
			log.Log("GetUser", "SQL error");
		}
		return customer;
	}*/
	
	public Customer getAuthCustomer(String username, String passw) {
		HibernateUtil.getSession().beginTransaction();
		return (Customer) HibernateUtil.getSession().createQuery(
		        " FROM Customer WHERE username='" + username + "' AND passw=md5('"
		            + passw + "')").uniqueResult();
	}
    
	/*public List<CustomerAddress> getCustomerAddresses(int customerId) {
		MyLogger log = new MyLogger();
		List<CustomerAddress> customAddr = new ArrayList<CustomerAddress>();

		try {
			connection = new DBconnection().getConnection();
			sql = "SELECT a.cst_address, a.customer, a.zip, a.house, a.address, a.county, a.town_county " +
					"FROM cst_address AS a " +
					"INNER JOIN customer AS c ON a.customer = c.customer " +
					"WHERE a.customer="+customerId;
			QueryResult = connection.createStatement().executeQuery(sql);
			
			while(QueryResult.next()) {
				CustomerAddress address = new CustomerAddress();
				address.setCustomer(Integer.valueOf(QueryResult.getString("customer")));
				address.setZip(QueryResult.getString("zip"));
				address.setHouse(QueryResult.getString("house"));
				address.setAddress(QueryResult.getString("address"));
				address.setCountry(QueryResult.getString("county"));
				address.setTownCounty((QueryResult.getString("town_county")));
				address.setCustomerAddress(Integer.valueOf(QueryResult.getString("cst_address")));
				customAddr.add(address);
			}
			connection.close();
    } catch(NumberFormatException ex) {
		log.Log("GetUser - parse Id", "Wrong Id");
	} catch (SQLException e) {
		log.Log("GetUser", "SQL error");
	}
		return customAddr;
	}*/
	
	@SuppressWarnings("unchecked")
	public List<CustomerAddress> getCustomerAddresses(int customerId) {
		HibernateUtil.getSession().beginTransaction();
	    return HibernateUtil.getSession().createQuery(
	        "FROM CustomerAddress WHERE customer=" + customerId).list();
	  }
	
	public void finalize() {
		try {
			HibernateUtil.getSession().close();
		} catch (HibernateException e) {
			HibernateUtil.getSession().getTransaction().rollback();
			log.error("Cannot close the session");
		}
	}
	
}
