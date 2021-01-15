<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Pizza Spring - Accueil</title>
  </head>
  <body>
  
  	<div class="m-2">
		<a class="btn btn-primary" href="<c:url value="/commande"/>" role="button"> Commander </a>
		<a class="btn btn-primary" href="<c:url value="/listeCommande"/>" role="button"> Voir les commandes </a>
		<a class="btn btn-primary" href="<c:url value="/rapportActivite"/>" role="button"> Voir le rapport d'activite </a>
 	</div> 
  
  </body>
</html>