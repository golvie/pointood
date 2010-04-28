<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.epood.model.data.Order"  %>    
<%@ page import="com.epood.model.dao.OrderDao"  %>
<%@ page import="java.util.List"  %> 

<jsp:include page="/jsp/header.jsp" />
<script src="js/productOrderInfo.js" type="text/javascript"></script>

<%
List<Order> orders = new OrderDao().getOrdersForCustomer((Integer)session.getAttribute("user"));

if (orders.size()==0) {
	out.println("You din't order anything before");
} else {
%>
<div ID="response" style="visibility:hidden;"></div>
<br/><br/>
<table>
	<tr>
        <th>No.</th>
        <th>Order date</th>
        <th>Order address</th>
        <th>Total</th>
        <th>&nbsp;</th>
    </tr>
<% for(Order customerOrder : orders) { %>
	<tr>
	<% out.println("<td><a href='javascript:select_product("
					+customerOrder.getOrder()+")'>"+customerOrder.getOrder()+"</a></td>");%>
	<td><%= customerOrder.getCustomerConfirmed() %></td>
	<td><%= customerOrder.getShippingAddress().getAddress() %></td>
	<td><%= customerOrder.getOrderTotalPrice() %></td>
	<td><a href="c?mode=XML&order=<%= customerOrder.getOrder() %>" target='_self'><b><u>XML</u></b></a></td>
	<td><a href="c?mode=XML&order=<%= customerOrder.getOrder() %>&parse=1" target='_self'><b><u>parsed xml</u></b></a></td>
	</tr>
<%} %>
<%} %>
</table>

<jsp:include page="/jsp/footer.jsp" />