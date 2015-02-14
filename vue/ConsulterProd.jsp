<!-- ConsulterProd -->

<%
    Double prix = (Double) request.getAttribute("prixConverti");
 	int numprod = Integer.parseInt(request.getParameter("numProd"));
	String monnaie = (String) request.getParameter("monnaie");
%>


<html> 
	<body>
		<h1> Consultation du prix d'un produit </h1>
<%-- 			Le produit : <%=numprod%> <br> --%>
		<% if (prix>=0) {%>
       Voici le prix du produit : <%=prix%> <%=monnaie %>
	   <% } else { %>
		n'a pas pu être enregistré ! <% } %>
		
		
	</body> 
</html>