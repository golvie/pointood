<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.epood.model.data.Product"  %> 
<%@ page import="java.util.List"  %> 
<jsp:useBean id="ProductDAO" scope="page" class="com.epood.model.dao.ProductDao" />
<jsp:useBean id="product" scope="request" class="com.epood.model.data.Product" />

<jsp:include page="/jsp/header.jsp" />

<table align="left">

	<tr><td colspan="2">
	<h3>${product.name}</h3>
	</td></tr>
	<tr>
    <td colspan="2">
	${product.description} <br/><br/>
	</td></tr>
	<tr>
    <td align="left">Price: 
    <b>${product.price}</b> 
    </td>
    <td align="right" width="50%">
    <%if (session.getAttribute( "user" ) != null) { %>
    <form method="post" action="c?mode=cart">
          Desired amount: 
          <input type="hidden" name="productId" value="${product.productId}" /> 
          <input type="text" size="4" name="itemCount" maxlength="2" value="1" style="text-align: right" /> 
          <input type="submit" value="Add to cart" />
        </form>
    <%} %>
    </td></tr>
	
</table>
<jsp:include page="/jsp/footer.jsp" />