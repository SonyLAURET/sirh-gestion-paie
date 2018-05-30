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
				<li class="nav-item active"><a class="nav-link" href="../bullentin/lister">Bulletins</a>
				</li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h1>SIRH - Ajouter un employé</h1>

		<form:form methode="get" modelAttribute="employe">
			<div class="row">
				<label for="matricule" class="col-4">Matricule</label>
				<form:input class="text col-6" id="matricule" path="matricule" />
			</div>
			<br />
			<div class="row">
				<label for="entreprise" class="col-4">Entreprise</label>
				<form:select path="entreprise.id" items="${entreprise}"
					itemValue="id" itemLabel="denomination" id="entreprise"
					class="col-6"></form:select>
			</div>
			<br />
			<div class="row">
				<label for="profil" class="col-4">Profil</label>
				<form:select path="profilRemuneration.id" items="${profil}"
					itemValue="id" itemLabel="code" id="profil" class="col-6"></form:select>
			</div>
			<br />
			<div class="row">
				<label for="grade" class="col-4">Grade</label>
				<form:select path="grade.id" items="${grade}" itemValue="id"
					itemLabel="code" id="entreprise" class="col-6"></form:select>
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