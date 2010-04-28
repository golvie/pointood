/**
 * 
 */
package com.epood.model.dao;

import java.util.List;

import javax.persistence.OrderBy;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import com.epood.model.data.Product;
import com.epood.model.data.ProductCatalog;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public class ProductCatalogDao {

	Logger log = Logger.getLogger(this.getClass());
	
	@SuppressWarnings("unchecked")
	public List<ProductCatalog> getAllCatalogs() {	
		HibernateUtil.getSession().beginTransaction();
	    return HibernateUtil.getSession().createQuery(
	        "FROM ProductCatalog ORDER BY name").list();
	}
	
	@OrderBy("name")
	public List<Product> getProductsInCatalog(int catalogId) {
		HibernateUtil.getSession().beginTransaction();
	    return getCatalogById(catalogId).getProducts();
	  }
	
	public ProductCatalog getCatalogById(int catalogId) {
		HibernateUtil.getSession().beginTransaction();
	    return (ProductCatalog) HibernateUtil.getSession().createQuery(
	        "FROM ProductCatalog WHERE product_catalog = " + catalogId)
	        .uniqueResult();
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

/*
public List<ProductCatalog> getAllCatalogs() {
	List<ProductCatalog> catalogList = null;
	Session session = null;
	
	try {
        session = HibernateUtil.getSession();
        session.beginTransaction();
        catalogList = session.createQuery("from ProductCatalog as PC").list();
	} catch (Exception e) {
		 log.error("getAllCatalogs():",e);
	} finally {
		session.close();
	}
        
	return catalogList; */
	
	
	/*try {
		Connection connect = new DBconnection().getConnection();
		Statement  statement = connect.createStatement();
		String sql = "SELECT product_catalog, name, struct_unit " +
				"FROM product_catalog ORDER BY name";
		ResultSet result = statement.executeQuery(sql);
		catalogList = new ArrayList<ProductCatalog>();
		while(result.next()) {
			ProductCatalog catalog = new ProductCatalog();
			catalog.setName(result.getString("name"));
			catalog.setProductCatalog(result.getInt("product_catalog"));
			catalog.setStructUnit(result.getInt("struct_unit"));
			catalogList.add(catalog);
		}
		connect.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	*/