<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
   <xsl:template match="/export">
      <html>
      	<head>
      	<link href="main_info.css" rel="stylesheet" type="text/css" />
      	</head>
         <body>
            <h1>Informations Personnelles Pierre Boué 1001 Pneus</h1>
            <!--xsl:for select=""-->
            <h2>Date export du fichier : <xsl:value-of select="export_date" /> </h2>
            <h3>Client</h3>
            <table>
               <tr>
                  <th>email</th>
                  <th>prénom</th>
                  <th>nom</th>
                  <th>genre</th>
                  <th>date de naissance</th>
                  <th>tva</th>
                  <th>création</th>
                  <th>transfert bancaire activé</th>
                  <th>paiement différé</th>
               </tr>
               <xsl:for-each select="customer">
                  <tr>
                     <td>
                        <xsl:value-of select="email" />
                     </td>
                     <td>
                        <xsl:value-of select="firstname" />
                     </td>
                     <td>
                        <xsl:value-of select="lastname" />
                     </td>
                     <td>
                        <xsl:value-of select="gender" />
                     </td>
                     <td>
                        <xsl:value-of select="date_of_birth" />
                     </td>
                     <td>
                        <xsl:value-of select="tax_vat" />
                     </td>
                     <td>
                        <xsl:value-of select="created_at" />
                     </td>
                     <td>
                        <xsl:value-of select="others/bank_enable_transfer" />
                     </td>
                     <td>
                        <xsl:value-of select="others/deferred_payment" />
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
            <h3>Adresses</h3>
            <table>
               <tr>
                  <th>prénom</th>
                  <th>nom</th>
                  <th>suffixe</th>
                  <th>Société</th>
                  <th>Rue</th>
                  <th>Ville</th>
                  <th>CP</th>
                  <th>région</th>
                  <th>pays</th>
                  <th>n° tva</th>
                  <th>téléphone</th>
                  <th>facturation</th>
                  <th>Livraison</th>
               </tr>
               <xsl:for-each select="addresses">
                  <tr>
                     <td>
                        <xsl:value-of select="address/firstname" />
                     </td>
                     <td>
                        <xsl:value-of select="address/lastname" />
                     </td>
                     <td>
                        <xsl:value-of select="address/suffix" />
                     </td>
                     <td>
                        <xsl:value-of select="address/company" />
                     </td>
                     <td>
                        <xsl:value-of select="address/streets/street" />
                     </td>
                     <td>
                        <xsl:value-of select="address/city" />
                     </td>
                     <td>
                        <xsl:value-of select="address/postcode" />
                     </td>
                     <td>
                        <xsl:value-of select="address/region" />
                     </td>
                     <td>
                        <xsl:value-of select="address/country" />
                     </td>
                     <td>
                        <xsl:value-of select="address/vat_id" />
                     </td>
                     <td>
                        <xsl:value-of select="address/telephone" />
                     </td>
                     <td>
                        <xsl:value-of select="address/is_default/billing" />
                     </td>
                     <td>
                        <xsl:value-of select="address/is_default/shipping" />
                     </td>
                  </tr>
               </xsl:for-each>
            </table>
            <h3>Listes d'envie</h3>
            
  			<!--xsl:transform extension-element-prefixes="/wishlists/wishlist"-->
            <table>
               <tr>
                  <th>nom</th>
                  <th>partagée</th>
                  <th>sku produit</th>
                  <th>nom produit</th>
                  <th>description</th>
                  <th>quantité</th>
                  <th>Ajouté</th>
               </tr>
               <tr>
                 <td>
                    <xsl:value-of select="name" />
                 </td>
				 <td>
					<xsl:value-of select="shared" />
				 </td>
                 <td>
                    <xsl:value-of select="items/item/product/sku" />
                 </td>
				 <td>
					<xsl:value-of select="items/item/product/name" />
				 </td>
				 <td>
					<xsl:value-of select="items/item/description" />
				 </td>
				 <td>
					<xsl:value-of select="items/item/qty" />
				 </td>
				 <td>
					<xsl:value-of select="items/item/added_at" />
				 </td>
               </tr>
            </table>
            <!--/xsl:transform-->
         </body>
      </html>
   </xsl:template>
</xsl:stylesheet>
