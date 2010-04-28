<%@ page import="com.epood.model.data.Order"  %>
</td>
	<td align="right" valign="top">
	<% if(session.getAttribute( "user" ) != null){ %>
	<table>
		<tr>
		<td align="right">
         Logged in as:<br/>
         <b><%  out.println(session.getAttribute("username"));%></b>
        </td>
        </tr>
        <tr align="right">
              <td><a href="c?mode=ordersearch">My previous orders</a></td>
        </tr>
        <tr align="right">
         <td>
           <a href="c?mode=cart">Shopping cart [ <%
        	   if (session.getAttribute("current_order") == null)
        		   out.println("0");
        	   else
        	   	   out.println(((Order) session.getAttribute("current_order")).
        			   getOrderItems().size()); %>]</a>
         </td>
        </tr>
        <tr align="right">
         <td>
            <a href="c?mode=product&form=1">Search products</a>
         </td>
        </tr>
    	<tr align="right">
        	<td><a href="c?mode=logout">logout</a></td>
        </tr>
     </table>
    <%} else { %>
    <jsp:include page="/jsp/login.jsp" />
    <%} %>	
	</td>
    </tr>
  </tbody>
</table>
</html>
