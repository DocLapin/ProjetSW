<!-- ConsulterCommande -->

<%@ page import="modele.DetailCde" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modele.Produit" %>

<%
    DetailCde detail = (DetailCde) request.getAttribute("commandeChoisie");
	ArrayList<Produit> produit = detail.getPdt(); 
	int i;
%>

<html> 
	<body>
		<h1> Consulter une commande par numeÅro </h1>
		Numero de la commande : <%= detail.getCde().getNumcde() %> <br>
		Adresse de livraison : <%= detail.getAdresseLiv() %>
		Produits : 
		<% for(i = 0; i < detail.getPdt().size(); i++) { %>
			Numero produit : <%= produit.get(i).getNumProd() %>
			<br>
			Designation produit : <%= produit.get(i).getDesignation()%>
			<br>
			Prix produit : <%= produit.get(i).getPrix() %>
			<br> <br>
		<%}%>
		
	</body> 
</html>