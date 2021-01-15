<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Pizza Spring - Liste des commandes</title>
</head>
<body>

	<div class="m-2">
		<a class="btn btn-primary" href="<c:url value="/"/>" role="button"> Retour à l'accueil </a>
 	</div> 
 	
	<div>
		<h3> -- Liste des commandes -- </h3>
		
		<table class="table mt-2">
			<thead>
				<tr>
					<th scope="col">Client</th>
					<th scope="col">Heure / Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listeCommande}" var="commande">
					<tr>
						<td>${commande.nom}</td>
						<td>
							<fmt:formatDate value="${commande.dateEmission}" pattern="HH:mm" />
							le <fmt:formatDate value="${commande.dateEmission}" pattern="d/MM/yyyy" />
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="m-2">
		<a class="btn btn-outline-primary mt-4" href="<c:url value="/listeCommande/detail"/>" role="button"> Commande suivante </a>
 	</div> 

</body>
</html>