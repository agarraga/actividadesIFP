<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/facturas">
    <html>
      <head>
        <title>Transformar</title>
      </head>
      <body>
        <p>test</p>
        <table>
          <tr>
            <th>Numero</th>
            <th>Fecha</th>
            <th>Datos Emisor</th>
            <th>Datos Cliente</th>
            <th>Detalles Factura</th>
          </tr>
          <xsl:for-each select="factura">
            <tr>
              <td><xsl:value-of select="numero"/></td>
              <td><xsl:value-of select="fecha"/></td>
              <td><xsl:apply-templates select="factura/datos_emisor"/></td>
              <td><xsl:apply-templates select="factura/datos_cliente"/></td>
              <td><xsl:value-of select="detalles_factura/importe"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
  <xsl:template match="factura/datos_emisor"/>
    <xsl:value-of select="nombre"/><br/><xsl:value-of select="cif"/><br/><xsl:value-of select="telefono"/>
  <xsl:template/>
  <xsl:template match="factura/datos_cliente"/>
    <xsl:value-of select="nombre"/><br/><xsl:value-of select="cif"/><br/><xsl:value-of select="telefono"/>
  <xsl:template/>
</xsl:stylesheet>
