<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/pais">
    <html>
      <head>
        <title>Irlanda</title>
        <style>
          table, th, td { border-style: outset; }
          th { text-align: left; }
          td { text-align: right; }
          img { max-width: 400px; }
        </style>
      </head>
      <body>
        <table>
          <tr>
            <th>Nombre</th>
            <td><xsl:value-of select="nombre"/></td>
          </tr>
          <tr>
            <th>Población</th>
            <td><xsl:value-of select="poblacion"/></td>
          </tr>
          <tr>
            <th>Continente</th>
            <td><xsl:value-of select="continente"/></td>
          </tr>
          <tr>
            <th>Capital</th>
            <td><xsl:value-of select="capital"/></td>
          </tr>
          <tr>
            <th>Coordenadas Capital</th>
            <td>Latitud: <xsl:value-of select="coordenadas/latitud"/><br/>Longitud: <xsl:value-of select="coordenadas/longitud"/></td>
          </tr>
          <tr>
            <th>Costa</th>
            <xsl:choose>
              <xsl:when test="costa='true'">
                <td>Sí</td>
              </xsl:when>
              <xsl:otherwise>
                <td>Sin litoral</td>
              </xsl:otherwise>
            </xsl:choose>
          </tr>
        </table>
        <xsl:for-each select="fotografias/fotografia">
          <img>
            <xsl:attribute name="src">
              <xsl:value-of select="url"/>
            </xsl:attribute>
            <xsl:attribute name="alt">
              <xsl:value-of select="descripcion"/>
            </xsl:attribute>
          </img>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
