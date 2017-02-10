<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/index.css">

<title>Carrinho</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
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


		<table class="table table-striped">
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
					<td>${produto.setor.descricao}</td>
					<td>${produto.fabricante}</td>
					<td>${produto.complemento}</td>
					<td><fmt:formatNumber value="${produto.preco.number}"
							type="currency" /></td>
					<td><a href="carrinho?remove=${produto.id }"><img src="img/icons/excluir.png" alt="remover"></a>
				</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<th> Total </th>
				<td><fmt:formatNumber value="${total.number}" type="currency" /></td>
				
			</tr>
		</table>
		<a href="carrinho?clear=ok"><img src="img/icons/clear.png"/></a>
	</div>
</body>
</html>