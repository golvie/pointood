<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.List"  %>     
<%@ page import="com.epood.model.data.Product"  %> 
<%@ page import="com.epood.model.dao.ProductDao"  %> 
<jsp:useBean id="ProductCatalogDAO" scope="page" class="com.epood.model.dao.ProductCatalogDao" />
<jsp:useBean id="catalog" scope="request" class="com.epood.model.data.ProductCatalog" />

<jsp:include page="/jsp/header.jsp" />

<table align="center">
	<%
    List<Product> productList = null;
	if (catalog.getProducts().size() == 0){
		productList =  new ProductDao().getAllProducts();
		out.println("<tr><th>All Products:</th></tr>");
	} else {
		productList =  catalog.getProducts();
		out.println("<tr><th>"+ catalog.getName()+":</th></tr>");
	}
 	try {
      for (Product product : productList) {    
    	  out.println("<tr><td><a href='c?mode=product&productId="
    			  + product.getProductId()+"'>"
    			  + product.getName() +"</a></td><td>"
    			  + product.getPrice() +"</td></tr>");
      }
 	} catch(Exception ex) { 
		out.println("Error");
		if (productList == null) {
			out.println("Product List isn't available");
		}
	}
         
 	%>
 	</table>

<jsp:include page="/jsp/footer.jsp" />