<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Pizza Spring - Recapitulatif</title>
  </head>
  <body>
  
  	<div class="m-2">
		<a class="btn btn-primary" href="<c:url value="/"/>" role="button"> Retour à l'accueil </a>
 	</div> 
 	
 	<div> 	
 		<h3> -- Récapitulatif -- </h3>
 		
 		<div>
 			<div><strong>Nom : </strong>${commande.nom}</div>
 			<div><strong>Telephone : </strong>${commande.telephone}</div>
 			<div>
 				<strong>Commandé le : </strong>
 				<fmt:formatDate value="${commande.dateEmission}" pattern="dd/MM/yyyy" />
 				à <fmt:formatDate value="${commande.dateEmission}" pattern="HH:mm" />
 			</div>
 			
 			<div class="mb-3">_______________</div>
 			
 			<c:forEach items="${nbParTypePizza}" var="pizza">
 				<div>
 					<span>${pizza[0]} x ${pizza[1]} -- ${pizza[2]} €</span>
 				</div>
 			</c:forEach>
 			
 			<div>_______________</div>
 		</div>
 	</div>
  
  </body>
</html>