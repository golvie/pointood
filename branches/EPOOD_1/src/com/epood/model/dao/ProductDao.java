/**
 * 
 */
package com.epood.model.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.epood.model.data.Product;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public class ProductDao {

	Logger log = Logger.getLogger(this.getClass());
	
    @SuppressWarnings("unchecked")
	public List<Product> getAllProducts() {
		HibernateUtil.getSession().beginTransaction();
	    return HibernateUtil.getSession().createQuery(
	        "FROM Product ORDER BY name").list();
    }
    
    public Product getProduct(int id) {
    	HibernateUtil.getSession().beginTransaction();
    	return (Product) HibernateUtil.getSession().createQuery(
            "FROM Product WHERE product=" + id).uniqueResult();
    }
    
    @SuppressWarnings("unchecked")
	public List<Product> getProductsByCriteria(HttpServletRequest req) 
    											throws Exception {	
    	HibernateUtil.getSession().beginTransaction();
        String query = "FROM Product";

        String criteria = req.getParameter("criteria");
        String productCategoryId = req.getParameter("productCategoryId");
        String createdStart = req.getParameter("createdStart");
        String createdEnd = req.getParameter("createdEnd");
        String updatedStart = req.getParameter("updatedStart");
        String updatedEnd = req.getParameter("updatedEnd");
        String priceStart = req.getParameter("priceStart");
        String priceEnd = req.getParameter("priceEnd");

        boolean trueNeeded = false;
        
        if (!"".equals(criteria) || !"".equals(productCategoryId)
                || !"".equals(createdStart) || !"".equals(createdEnd)
                || !"".equals(updatedStart) || !"".equals(updatedEnd)
                || !"".equals(priceStart) || !"".equals(priceEnd)) {
              query += " WHERE";
              trueNeeded = true;
        }
        if (!"".equals(criteria) && criteria != null) {
            query += " (Lower(name) LIKE '%" + criteria.toLowerCase() + "%' "
                + "OR Lower(description) LIKE '%" + criteria.toLowerCase()
                + "%') AND ";
        }
        if (!"".equals(productCategoryId) && productCategoryId != null) {
            query += " product_catalog=" + productCategoryId + " AND ";
        }
        if (!"".equals(createdStart) && createdStart != null) {
            query += " created>'" + createdStart + "' AND ";
        }
        if (!"".equals(createdEnd) && createdEnd != null) {
            query += " created<'" + createdEnd + "' AND ";
        }
        if (!"".equals(updatedStart) && updatedStart != null) {
            query += " updated>'" + updatedStart + "' AND ";
        }
        if (!"".equals(updatedEnd) && updatedEnd != null) {
            query += " updated<'" + updatedEnd + "' AND ";
        }
        if (!"".equals(priceStart)) {
            query += " price > " + priceStart + " AND ";
        }
        if (!"".equals(priceEnd)) {
            query += " price < " + priceEnd + " AND ";
        }
        if (trueNeeded) {
            query += " 1=1";
        }
        log.info(query);

        query += " ORDER BY name";
        try {
            return HibernateUtil.getSession().createQuery(query).list();
        } catch (final Exception e) {
        	  HibernateUtil.getSession().getTransaction().rollback();
          throw e;
        }
    }
    
    public void finalize() {
		try {
			HibernateUtil.getSession().close();
		} catch (HibernateException e) {
			HibernateUtil.getSession().getTransaction().rollback();
			System.out.println("Cannot close the session");
		}
	}
    
}
