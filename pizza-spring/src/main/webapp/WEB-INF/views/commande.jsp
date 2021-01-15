<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
  <head>
  	<meta charset="UTF-8">
  	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Pizza Spring - Commander</title>
  </head>
  <body>
  
  	<div class="m-2">
		<a class="btn btn-primary" href="<c:url value="/"/>" role="button"> Retour à l'accueil </a>
 	</div> 
 	
	<div>
		<h3> -- Commander -- </h3>
		
		<form:form servletRelativeAction="commande" modelAttribute="donneesCommandeDto" acceptCharset="utf-8">
			<div>
				<label>Nom : </label>
				<form:input placeholder="Entrez votre nom" path="nom"/> <small><form:errors path="nom"/></small>
			</div>
			<div>
				<label>Téléphone : </label>
				<form:input placeholder="Entrez votre numéro de téléphone" path="telephone"/> <small><form:errors path="telephone"/></small>
			</div>
			<div>
				<label> Pizza :</label>
				<div>
					<c:forEach items="${pizzasDisponible}" var="pizza">
						<div>
							<button type="button" id="buttonSupprimer_${pizza.id}" onClick="SupprimerPizza('${pizza.nom}', '${pizza.id}')" class="btn btn-outline-danger" style="border-radius:50%;"> - </button>
							<span id="${pizza.id}"> 0 </span>
							<button type="button" onClick="AjouterPizza('${pizza.nom}', '${pizza.id}')" class="btn btn-outline-success" style="border-radius:50%;"> + </button>
							<span class="mr-2">${pizza.nom} -- ${pizza.prix / 100} €</span>
						</div>
					</c:forEach>
				</div>
			</div>
			
			<small><form:errors path="pizzas"/></small>
			<div id="nbPizzaChoisies">
				<input type="hidden" name="pizzas"/>
			</div>
			
			<div>
				<button type="submit" class="btn btn-outline-primary mt-4">Commander</button>
			</div>
		</form:form>
	</div>
  
  </body>
  
  <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <script>
	var tabPizza = [];
	function AjouterPizza(pizza_name, pizza_id){
		var pizzaDejaPrise = false;
		for (var i = 0; i < tabPizza.length; i++)
		{
			if(tabPizza[i][0] == pizza_name){
				tabPizza[i][1] = tabPizza[i][1] + 1;
				document.getElementById(pizza_id).innerHTML = tabPizza[i][1];
				pizzaDejaPrise = true;
			}
		}
		if(pizzaDejaPrise == false){
			tabPizza.push([pizza_name, 1]);
			document.getElementById(pizza_id).innerHTML = 1;
		}
		updateChoixPizza();
	}

	function SupprimerPizza(pizza_nom, pizza_id){
		for (var i = 0; i < tabPizza.length; i++)
		{
			if(tabPizza[i][0] == pizza_nom && tabPizza[i][1] > 0){
				tabPizza[i][1] = tabPizza[i][1] - 1;
				document.getElementById(pizza_id).innerHTML = tabPizza[i][1];
			}
		}
		updateChoixPizza();
	}
	
	function updateChoixPizza(){
		var inputPizza = "";
		for(var i = 0; i < tabPizza.length; i++){
			for(var j = 0; j < tabPizza[i][1]; j++){
				inputPizza += '<input type="hidden" name="pizzas" value="' + tabPizza[i][0] + '"/>';
			}
		}
		document.getElementById("nbPizzaChoisies").innerHTML= inputPizza;
	}
</script>
</html>