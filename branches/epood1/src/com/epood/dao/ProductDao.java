/**
 * 
 */
package com.epood.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.epood.model.domain.Customer;
import com.epood.model.domain.Product;
import com.epood.model.domain.ProductCatalog;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public class ProductDao {

    public List<Product> getAllProducts() {
    	List<Product> productList = null;
		try {
			Connection connect = new DBconnection().getConnection();
			Statement  statement = connect.createStatement();
			String sql = "SELECT product, code, name, description, created, updated, price, producer " +
					"FROM product ORDER BY name";
			ResultSet result = statement.executeQuery(sql);
			productList = new ArrayList<Product>();
			while(result.next()) {
				Product product = new Product();
				product.setName(result.getString("name"));
				product.setDescription(result.getString("description"));
				product.setPrice(result.getDouble("price"));
				productList.add(product);
			}
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList; 
    }
    
    public List<Product> getProductsById(int id) {
    	List<Product> productList = null;
		try {
			Connection connect = new DBconnection().getConnection();
			Statement  statement = connect.createStatement();
			String sql = "SELECT p.product, p.code, p.name, p.description, p.created, p.updated, p.price, p.producer " +
					"FROM product AS p " +
					"INNER JOIN product_product_catalog AS pp ON p.product=pp.product " +
					"INNER JOIN product_catalog AS c ON pp.product_catalog = c.product_catalog " +
					"WHERE c.product_catalog="+id+" ORDER BY name";
			ResultSet result = statement.executeQuery(sql);
			productList = new ArrayList<Product>();
			while(result.next()) {
				Product product = new Product();
				product.setName(result.getString("name"));
				product.setDescription(result.getString("description"));
				product.setPrice(result.getDouble("price"));
				productList.add(product);
			}
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList; 
    }
    
}
