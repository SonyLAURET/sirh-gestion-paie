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
				<li class="nav-item active"><a class="nav-link" href="../employes/lister">Employes</a>
				</li>
				<li class="nav-item active"><a class="nav-link" href="../bulletin/lister">Bulletins</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h1>Ajouter un Bulletin</h1>
		<form:form methode="get" modelAttribute="bulletin">
			<br />
			<div class="row">
				<label for="periode" class="col-4">Periode</label>
				<form:select path="periode.id" items="${periode}" itemValue="id"
					itemLabel="dateDebut" id="periode" class="col-6"></form:select>
			</div>
			<br />
			<div class="row">
				<label for="matricule" class="col-4">Matricule</label>
				<form:select path="remunerationEmploye.id"
					items="${remunerationEmploye}" itemValue="id" itemLabel="matricule"
					id="matricule" class="col-6"></form:select>
			</div>
			<br />
			<div class="row">
				<label for="primeExceptionnelle" class="col-4">Prime
					Exeptionnel</label>
				<form:input class="text col-6" id="primeExceptionnelle"
					path="primeExceptionnelle" />
			</div>
			<br />
			<form:button type="submit" class="offset-7 col-3">Ajouter</form:button>
		</form:form>
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