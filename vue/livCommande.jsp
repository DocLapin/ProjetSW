<!-- livCommande -->

<%
   boolean confirmation = (boolean) request.getAttribute("resultatLiv");
%>


<html> 
	<body>
		<h1> Enregistrement d'une livraison </h1>
		La livraison
		<% if (confirmation) {%>
        a bien etre enregistrée !
	   <% } else { %>
		n'€™a pas pu être enregistrée ! <% } %>
	</body> 
</html>