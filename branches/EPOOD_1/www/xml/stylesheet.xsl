<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="order">
  <html>
  <body>
Order number: <xsl:value-of select="order_id"/><br/>
Date ordered: <xsl:value-of select="date"/><br/>
Order address: <xsl:value-of select="address"/><br/>
Order total price: <xsl:value-of select="total_price"/><br/>
<br/><br/>
  <table border="0">
    <tr>
      <th>Product</th>
      <th>Amount</th>
      <th>Sub-total</th>
    </tr>
	<xsl:for-each select="products/product">
    <tr>
      <td><xsl:value-of select="name"/></td>
	  <td><xsl:value-of select="amount"/></td>
	  <td><xsl:value-of select="price"/></td>
    </tr>
	</xsl:for-each>
  </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>