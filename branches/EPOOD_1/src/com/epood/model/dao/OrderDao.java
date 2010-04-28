/**
 * 
 */
package com.epood.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.epood.model.dao.DBconnection;
import com.epood.model.data.Order;
import com.epood.model.data.OrderItem;

/**
 * @author Jaroslav Judin
 * Apr 20, 2010
 */
public class OrderDao {

	private static Logger log = Logger.getLogger(OrderDao.class);
	
	@SuppressWarnings("unchecked")
	public List<Order> getOrdersForCustomer(int customerId) {
		HibernateUtil.getSession().beginTransaction();
	    return HibernateUtil.getSession().createQuery(
	        "FROM Order WHERE customer = " + customerId).list();
	}
	
	public Order getOrder(int orderId) {
		HibernateUtil.getSession().beginTransaction();
	    return (Order) HibernateUtil.getSession().createQuery(
	        "FROM Order WHERE order = " + orderId).uniqueResult();
	}
	
	public void saveOrder(Order o) {
		Connection connection = null;
		CallableStatement cs = null;
		try {
			connection = new DBconnection().getConnection();
			String sql = "{call save_order(?,?,?,?::timestamp,?,?) }" ;
			
			cs = connection.prepareCall(sql);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.setInt(1, o.getOrderStatusType());
			cs.setInt(2, o.getCustomer());
			cs.setInt(3, o.getShippingAddressId());
			cs.setTimestamp(4, new java.sql.Timestamp(o.getCustomerConfirmedDate().getTime()));
			cs.setInt(5, o.getOrderType());
			cs.executeUpdate();
			int orderId = cs.getInt(6);
			
			for(OrderItem item : o.getOrderItems()) {
				sql = "{call save_order_item(?,?,?) }" ;
				cs = connection.prepareCall(sql);
				cs.setInt(1, orderId);
				cs.setInt(2, item.getProductId());
				cs.setInt(3, item.getItemCount());
				cs.executeUpdate();
			}
			connection.close();
		} catch(NumberFormatException ex) {
			log.error("GetUser - parse Id Wrong Id");
		} catch (SQLException e) {
			log.error("order save error",e);
		}
		
		
	}
	/*
	public void saveOrder(Order o) throws Exception {
		 HibernateUtil.getSession().beginTransaction();
		 try {
		    HibernateUtil.getSession().save(o);
		 } catch (RuntimeException e) {
		    log.error("Error saving order: " + e);
		    HibernateUtil.getSession().getTransaction().rollback();
		    throw e;
		 }
		 HibernateUtil.getSession().getTransaction().commit();
	}
	*/
	/* */
	public void finalize() {
		try {
			HibernateUtil.getSession().close();
		} catch (HibernateException e) {
			HibernateUtil.getSession().getTransaction().rollback();
			System.out.println("Cannot close the session");
		}
	}
	
}
