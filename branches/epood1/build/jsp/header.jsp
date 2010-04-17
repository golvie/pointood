<%@ page import="com.epood.model.domain.ProductCatalog"  %> 
<%@ page import="java.util.List"  %> 
<jsp:useBean id="ProductCatalogDAO" scope="page" class="com.epood.dao.ProductCatalogDao" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>EPOOD</title>
<body>
<table align="center" width="850px">
  <tr>
    <td width="20%"><h2>.:EPOOD:.</h2></td>
  </tr>
</table>
<hr width="850px" align="center">

<table align="center" width="850px">
  <tbody>
    <tr>
	<td valign="top">
	<table>
	<tr><th>Products_Catalog:</th></tr>
	<tr><td><a href='c?mode=products'>All Products</a></td></tr>
	<%
    List<ProductCatalog> productList =  ProductCatalogDAO.getAllCatalogs();
 	try {
      for (int n = 0; n < productList.size()  ; n++) {    
    	  out.println("<tr><td><a href='c?mode=products&productId="
    			  +productList.get(n).getProductCatalog()+"'>"+ productList.get(n).getName() +"</a></tr></td>");
      }
 	} catch(Exception ex) { 
		out.println("Mingi viga");
		if (productList == null) {
			out.println("Massiivi ei saanud katte");
		}
	}
         
 	%>
 	</table>
      <td width="65%" align="left" valign="top">