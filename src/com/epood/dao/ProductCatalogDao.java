/**
 * 
 */
package com.epood.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.epood.model.domain.ProductCatalog;

/**
 * @author Jaroslav Judin
 * Apr 17, 2010
 */
public class ProductCatalogDao {
	
	public List<ProductCatalog> getAllCatalogs() {	
		ArrayList<ProductCatalog> catalogList = null;
		try {
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
		
		return catalogList; 
	}
	
}
