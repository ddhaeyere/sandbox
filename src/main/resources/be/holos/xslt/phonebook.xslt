<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">

        <html>
            <head>
                <title>Directory</title>
            </head>
            <body>

                <table border="1">

                    <tr>
                        <th>Name</th>
                        <th>Telephone</th>
                        <th>Email</th>
                    </tr>

                    <xsl:for-each select="phonebook/person">
                        <xsl:sort/>
                        <tr>
                            <td><xsl:value-of select="name"/></td>
                            <td><xsl:value-of select="telephone"/></td>
                            <td><xsl:value-of select="email"/></td>
                        </tr>
                    </xsl:for-each>

                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>