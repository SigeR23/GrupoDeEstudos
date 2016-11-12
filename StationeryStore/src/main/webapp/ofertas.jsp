<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Stationery Store::Ofertas</title>

<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link rel="icon" href="img/favicon.ico" type="image/x-icon">

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
	<nav class="navbar navbar-lg navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#menu">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="index.html" class="navbar-brand logotipo"> <img
					src="img/stationery-store-logo.png" alt="Stationery Store">
				</a>
			</div>
			<div class="collapse navbar-collapse" id="menu">
				<ul class="nav navbar-nav">
					<li><a href="">Ofertas</a></li>
					<li><a href="">Loja</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="" class="dropdown-toggle" data-toggle="dropdown">
							Minha Conta <span class="caret"></span>
					</a>
						<div class="dropdown-menu perfil">
							<div class="col-sm-4 hidden-xs">
								<img class="img-responsive img-rounded"
									src="https://api.adorable.io/avatars/100/watchuru.png">
							</div>
							<ul class="list-unstyled col-sm-8">
								<li>Fulano de Tal</li>
								<li><a href="">Alterar Perfil</a></li>
								<li><a href="">Sair</a></li>
							</ul>
						</div></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<ol class="breadcrumb">
			<li class="active">Início</li>
		</ol>
		<table class = "table table-striped">
			<tr>
				<th>ID</th>
				<th>Descricao</th>
				<th>Setor</th>
				<th>Fabricante</th>
				<th>Complemento</th>
				<th>Preço</th>
				</tr>
			<c:forEach var="produto" items="${Produtos}">
			<tr>
				<td>${produto.id}</td>
				<td>${produto.descricao}</td>
				<td>${produto.setor}</td>
				<td>${produto.fabricante}</td>
				<td>${produto.complemento}</td>
				<td>${produto.preco}</td>
				</tr>
			</c:forEach>
		</table>

	</div>

	<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>