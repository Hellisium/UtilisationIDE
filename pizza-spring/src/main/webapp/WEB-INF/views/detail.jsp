<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Pizza Spring - Détail</title>
</head>
<body>

	<div class="m-2">
		<a class="btn btn-primary" href="<c:url value="/listeCommande"/>" role="button"> Retour à la liste des commandes </a>
 	</div>
 	
 	<div> 	
 		<h3> -- Détail -- </h3>
 		
 		<div>
 			<div><strong>Nom : </strong>${commande.nom}</div>
 			<div><strong>Telephone : </strong>${commande.telephone}</div>
 			<div>
 				<strong>Commandé le : </strong>
 				<fmt:formatDate value="${commande.dateEmission}" pattern="dd/MM/yyyy" />
 				à <fmt:formatDate value="${commande.dateEmission}" pattern="HH:mm" />
 			</div>
 			
 			<div class="mb-3">_______________</div>
 			
 			<c:forEach items="${commande.pizzas}" var="pizza">
 				<h6>${pizza.nom} (${pizza.categorie.nom})</h6>
 				<ul>
 					<c:forEach items="${pizza.ingredient}" var="ingredient">
				 		<li>${ingredient.nom}</li>
				 	</c:forEach>
				</ul>
 			</c:forEach>
 			
 			<div>_______________</div>
 			
 		</div>
 	</div>
 	
 	<form:form servletRelativeAction="" acceptCharset="utf-8">
 		<button class="btn btn-outline-success mt-4" type="submit"> Commande prête </button>
 	</form:form>

</body>
</html>