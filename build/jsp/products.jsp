<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.epood.model.domain.Product"  %> 
<%@ page import="java.util.List"  %> 
<jsp:useBean id="ProductDAO" scope="page" class="com.epood.dao.ProductDao" />


<jsp:include page="/jsp/header.jsp" />

<table align="center">
	<tr><th>Products:</th></tr>
	<%
    List<Product> productList = null;
	if (request.getParameter("productId") == null)
		productList =  ProductDAO.getAllProducts();
	else {
		int id = Integer.parseInt(request.getParameter("productId"));
		productList =  ProductDAO.getProductsById(id);
	}
 	try {
      for (int n = 0; n < productList.size()  ; n++) {    
    	  out.println("<tr><td>"+ productList.get(n).getName() +"</td>"
    			  + "<td>"+ productList.get(n).getPrice() +"</td></tr>");
      }
 	} catch(Exception ex) { 
		out.println("Mingi viga");
		if (productList == null) {
			out.println("Massiivi ei saanud katte");
		}
	}
         
 	%>
 	</table>

	

<jsp:include page="/jsp/footer.jsp" /><br>