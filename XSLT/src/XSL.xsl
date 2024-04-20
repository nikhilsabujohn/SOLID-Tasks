<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body bgcolor="#F0FFFF">
<br></br>
<br></br>
  <h2 style="text-align:center;font-size:60px">LIBRARY ANIME COLLECTION</h2>
  <style>
  th
  {
  color:#FFFFFF;
  }
  
  td,tr{
  border:1px solid black;
  border-radius: 5px;
  font-weight:600;
  }
  </style>
  <table style="width:100%;height:50%">
    <tr bgcolor="#5D3FD3" style="font-size:30px;font-color:white">
      <th style="text-align:center">Title</th>
      <th style="text-align:center">Author</th>
      <th style="text-align:center">Price</th>
      <th style="text-align:center">Discount</th>
      <th style="text-align:center">Final Price</th>
    </tr>
    <xsl:for-each select="library/book">
    <tr style="text-align:center;font-size:25px">
      <td style="text-align:left;padding-left:20px"><xsl:value-of select="title"/></td>
      <td><xsl:value-of select="author"/></td>
      <td>₹ <xsl:value-of select="price"/></td>
      <xsl:choose>
      <xsl:when test="price>1000">
      <td style="color:#0BDA51"><xsl:text>20%</xsl:text></td>
      <td style="color:#0BDA51">₹ <xsl:value-of select="price*0.8"/></td>
      </xsl:when>
      <xsl:otherwise>
      <td><xsl:text>10%</xsl:text></td>
      <td>₹ <xsl:value-of select="price*0.9"/></td>
      </xsl:otherwise>
      </xsl:choose>
    </tr>
    </xsl:for-each>
  </table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>

