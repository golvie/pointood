<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"  %> 
<%@ page import="com.epood.model.data.OrderItem"  %>  
<%@ page import="com.epood.model.data.Order"  %>    
<%@ page import="com.epood.model.dao.OrderDao"  %>
<jsp:useBean id="order" scope="request" class="com.epood.model.data.Order" />

<table>
<tr>
    <td>Order number: <b>${order.order}</b></td>
  </tr>
  <tr>
    <td>Date ordered: <b>${order.customerConfirmed}</b></td>
  </tr>
  <tr>
    <td>Order address: <b>${order.shippingAddress.address}</b></td>
  </tr>
  <tr>
    <td>Order total price: <b>${order.orderTotalPrice}</b></td>
  </tr>
</table>
<br />
<table>
  <tr>
    <th>Product</th>
    <th>Amount</th>
    <th>Sub-total</th>
  </tr>
	<% for (OrderItem orderItem : order.getOrderItems()) { %>
		<tr>
		<td><a href='c?mode=product&productId=<%= orderItem.getProductId() %>'>
		<%= orderItem.getProduct().getName() %></a></td>
		<td><%= orderItem.getItemCount() %></td>
		<td><%= (orderItem.getItemCount() * orderItem.getProduct().getPrice()) %></td>
	<%} %>
</table>
