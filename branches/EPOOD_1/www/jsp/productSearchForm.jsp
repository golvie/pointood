<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import="java.util.List"  %>  
<%@ page import="com.epood.model.data.Product"  %> 
<%@ page import="com.epood.model.data.ProductCatalog"  %>
<%@ page import="com.epood.model.dao.ProductDao"  %>
<%@ page import="com.epood.model.dao.ProductCatalogDao"%>

<jsp:useBean id="specialCatalog" scope="request" class="com.epood.model.data.ProductCatalog" />
<jsp:include page="/jsp/header.jsp" />

<h4>Product search</h4>

<form method="get" action="c">
<input name="mode" type="hidden" value="product" />
<input name="search" type="hidden" value="1" />
<br/><br/>
<table>
  <tr>
    <th>Description</th>
    <th>Value</th>
  </tr>
  <tr>
    <td>Name or description fragment</td>
    <td><input type="text" name="criteria" /></td>
  </tr>
  <tr>
    <td>Product category</td>
    <td><select name="productCategoryId">
      <option value="">All</option>
      <% 
      List<ProductCatalog> catalogs = new ProductCatalogDao().getAllCatalogs();
      	for (ProductCatalog catalog : catalogs){ %>
      		<option value="<%= catalog.getProductCatalog() %>"><%= catalog.getName() %></option>
      	<%} %>
    </select></td>
  </tr>
  <tr>
    <td>Product added</td>
    <td><input type="text" name="created" /></td>
  </tr>
  <tr>
    <td>Product modified</td>
    <td><input type="text" name="updated" /></td>
  </tr>
  <tr>
    <td>Price range</td>
    <td>
      <input type="text" name="priceStart" size="6"/>
      -
      <input type="text" name="priceEnd" size="6"/>
    </td>
  </tr>
</table>

<input type="submit" value="Search Products" /></form>

<%
List<Product> productList = specialCatalog.getProducts();

	out.println("<table>");
	for (Product product : productList) {    
	    out.println("<tr><td><a href='c?mode=product&productId="
	    	+ product.getProductId()+"'>"
	    	+ product.getName() +"</a></td><td>"
	    	+ product.getPrice() +"</td></tr>");
	 }
	 out.println("</table>");
 %>
<jsp:include page="/jsp/footer.jsp" />