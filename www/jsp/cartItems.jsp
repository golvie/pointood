<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.epood.model.data.Product"  %> 
<%@ page import="com.epood.model.data.CustomerAddress"  %>
<%@ page import="com.epood.model.data.OrderItem"  %> 
<%@ page import="com.epood.model.data.Order"  %>
<%@ page import="com.epood.model.dao.CustomerDao"  %>
<%@ page import="java.util.List"  %> 
<jsp:useBean id="priceLimit" scope="request" class="java.lang.String" />

<jsp:include page="/jsp/header.jsp" />
<script src="js/remove.js" type="text/javascript"></script>
<%
Order Order = null;
if (session.getAttribute("current_order")!=null)
	Order = (Order) session.getAttribute("current_order");
if (Order == null || Order.getOrderItems().size() == 0) {
	out.println("Your cart is empty.");
} else { %>
<div>
  <form action="c?mode=cart&clearAll=all" method="post">
    <input type="button" value="Remove selected" onclick="removeCheckedItems();"/>
    <input type="submit" value="Clear Cart">
  </form>
</div>

<table>
  <tr>
    <th>Product name</th>
    <th>Amount</th>
    <th>Remove</th>
    <th>Sub-total</th>
  </tr>
  <%for (OrderItem item : Order.getOrderItems()) { %>
  	<tr>
      <td width="55%"><a href='c?mode=product&productId=<%=item.getProduct().getProductId() %>'>
      <%= item.getProduct().getName() %></a>
      </td>
      <td>
        <form action="c?mode=cart" method="post">
          <input name="itemCount" type="text" size="2" maxlength="2" value="<%= item.getItemCount() %>" /> 
          <input name="productId" type="hidden" value="<%= item.getProduct().getProductId() %>" />
          <input type="submit" value="OK" />
        </form>
      </td>
      <td>
        <form name="productCheckboxForm">
          <input type="checkbox" value="<%= item.getProduct().getProductId() %>" name="productCheckbox" />
        </form>
      </td>
      <td>
      <%= (item.getProduct().getPrice() * item.getItemCount()) %>
      </td>
      </tr>
  <%} %>
</table>
<div align="right">
  <br/>
  Total: <b><%= Order.getOrderTotalPrice() %></b>
  <%
  if (priceLimit.length()>0) { %>
	 <br/>
	 <div style="background:red;">${priceLimit}</div>
 <% } %>
</div>
<div>
  <br/>Please select the shipping address: <br/>
  <form action="c?mode=cart&submit=1" method="post">
    <select name="customerAddressId">
      <% 
      List<CustomerAddress> customerAddr = new CustomerDao().getCustomerAddresses( (Integer) session.getAttribute("user"));
      for (CustomerAddress address : customerAddr) { %>
      		<option value="<%= address.getCustomerAddress() %>"><%= address.getAddress() %></option>
      <%} %>
    </select> 
    <input type="submit" value="Submit">
  </form>
</div>
<%} %>

<jsp:include page="/jsp/footer.jsp" />