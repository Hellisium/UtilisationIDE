<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Pizza Spring - Rapport d'activité</title>
</head>
<body>

	<div class="m-2">
		<a class="btn btn-primary" href="<c:url value="/"/>" role="button"> Retour à l'accueil </a>
 	</div>
 	
	<div>
		<h3> -- Rapport d'activité -- </h3>
		
		<h5 class="mt-3"> Commande par client </h5>
		<table class="table mt-2">
			<thead>
				<tr>
					<th scope="col">Client</th>
					<th scope="col">Nombre de comandes</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${commandeParClient}" var="commande">
					<tr>
						<td>${commande.nom}</td>
						<td>${commande.nombre}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h5 class="mt-3"> Pizzas par catégorie </h5>
		<table class="table mt-2">
			<thead>
				<tr>
					<th scope="col">Catégorie</th>
					<th scope="col">Nombre de pizzas</th>
					<th scope="col">Montant encaissé</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pizzaParCategorie}" var="pizza">
					<tr>
						<td>${pizza.categorie}</td>
						<td>${pizza.nombre}</td>
						<td>${pizza.prix / 100} €</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>