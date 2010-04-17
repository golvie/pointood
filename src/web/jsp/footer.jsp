</td>
	<td align="right" valign="top">
	<% if(session.getAttribute( "username" ) != null){ %>
	<table>
		<tr></tr>
		<td align="right">
         Logged in as:<br/>
         <b><%  out.println(session.getAttribute( "first_name" ) +" " +session.getAttribute( "last_name" ));%></b>
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
