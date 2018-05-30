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
					href="../employes/lister">Employés</a></li>
				<li class="nav-item active"><a class="nav-link"
					href="../bulletin/lister">Bulletins</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h1>Lister des bulletins</h1>
		<a role="button" href="creer" class="offset-6 col-6 btn btn-light">Créer
			un nouveau Bulletin un employé</a><br />
		<table class="table table-striped">
			<tr>
				<th>Date/heure Création</th>
				<th>Periode</th>
				<th>Matricule</th>
				<th>Salaire Brut</th>
				<th>Net imposable</th>
				<th>Net A payer</th>
				<th>Actions</th>
			</tr>
			<c:forEach var="bulletin" items="${calcul}">
				<tr>
					<td>${bulletin.key.date}</td>
					<td>${bulletin.key.periode.dateDebut} - ${bulletin.key.periode.dateFin}</td>
					<td>${bulletin.key.remunerationEmploye.matricule}</td>
					<td>${bulletin.value.salaireBrut}</td>
					<td>${bulletin.value.netImposable}</td>
					<td>${bulletin.value.netAPayer}</td>
					<td><a href="visualiser/${bulletin.key.id}">Action</a></td>
				</tr>
			</c:forEach>
		</table>
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