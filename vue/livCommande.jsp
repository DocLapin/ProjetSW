<!-- livCommande -->

<%
   boolean confirmation = (boolean) request.getAttribute("resultatLiv");
%>


<html> 
	<body>
		<h1> Enregistrement d'une livraison </h1>
		La livraison
		<% if (confirmation) {%>
        a bien etre� enregistr�e !
	   <% } else { %>
		n'��a pas pu �tre enregistr�e ! <% } %>
	</body> 
</html>