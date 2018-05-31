<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un employé</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">

</head>
<body>
	<!--navbar-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="../employes/lister">Employes</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="../bulletin/lister">Bulletins</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h1>Bulletin de salaire</h1>
		<br />
		<div class="row">
			<h4 class="offset-8">Période</h4>
			<p class="offset-8">${bulletinSalaire.periode.dateFin}-
				${bulletinSalaire.key.periode.dateFin}</p>
		</div>
		<div class="row">
			<h4 class="col-12">Entreprise</h4>
			<span class="col-12">DEV ENtreprise</span><br />
			<p class="col-6">Siret :</p>
			<h6 class="offset-2">
				Matricule
				</h4>
		</div>
		<div class="row">
			<h4>Salaire</h4>
			<table class="table table-striped">
				<tr>
					<th>Rubriques</th>
					<th>Base</th>
					<th>Montant Salarial</th>
					<th>Taux Patronal</th>
					<th>Cotisations Patronales</th>
				</tr>
				<tr>
					<td>Salaire de base</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Prime Exeptionnelle</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Salaire Brut</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div class="row">
			<h4>Cotisations</h4>
			<table class="table table-striped">
				<tr>
					<th>Rubriques</th>
					<th>Base</th>
					<th>Montant Salarial</th>
					<th>Taux Patronal</th>
					<th>Cotisations Patronales</th>
				</tr>
				<c:forEach var="bulletin" items="${bulletin.remunerationEmploye.profilRemuneration.cotisationsNonImposables}">
				<tr>				
					<td>${bulletin.libelle }</td>			
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="row">
			<h4>NET Imposable :</h4>
			<table class="table table-striped">
				<tr>
					<th>Rubriques</th>
					<th>Base</th>
					<th>Montant Salarial</th>
					<th>Taux Patronal</th>
					<th>Cotisations Patronales</th>
				</tr>
				<tr>
					<td>Salaire de base</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Prime Exeptionnelle</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Salaire Brut</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div class=" row offset-8">
			<h4>NET A PAYER :</H4>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>
</body>
</html>