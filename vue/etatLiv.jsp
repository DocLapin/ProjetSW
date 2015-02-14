<!-- etatLiv -->

<%@ page import="modele.Commande" %>

<% 
	Commande laCommande = (Commande) request.getAttribute("commandeChoisie");
%>
<html> 
	<body>
		<h1> Vérifier l'état d'une livraison </h1>
		Numero de la commande : <%= laCommande.getNumcde() %> <br>
		Etat de la livraison : 
		
		<% if(laCommande.getDateLiv() == null) {  %>
		
		livraison non prévue
		
		<% } else {  %>
		
		en cours de livraison <br>
		Date de livraison : <%= laCommande.getDateLiv() %>
		
		<% } %>
		
	</body> 
</html>

