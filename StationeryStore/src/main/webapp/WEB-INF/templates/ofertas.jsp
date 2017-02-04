<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<jsp:include page="menu.jsp"/>	
	<div class="container">
		<ol class="breadcrumb">
			<li class="active">Início</li>
		</ol>
		<c:if test="${not empty msg}">
			<div class="alert alert-success alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<c:out value="${msg }"/>
			</div>
		</c:if>
		<div class="row">
			<c:forEach var="produto" items="${Produtos}">
				<div class="col-sm-6 col-md-4">
					<div class="thumbnail">
					<img alt="${produto.descricao}" class="card-img-top" src="img/produtos/p${produto.id}.jpg">
					<div class="caption">
						<h3>${produto.descricao}</h3>
						<p>${produto.complemento}</p>
						<h2><fmt:setLocale value="pt_BR"/><fmt:formatNumber value="${produto.preco.number}" type="currency"/></h2>
						<p><a href="?Add=${produto.id}" class="btn btn-primary" role="button">Comprar</a></p>
					</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</body>
</html>