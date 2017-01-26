<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Page Lister Pizza" name="title" />
</jsp:include>

<body class="container">
	<h1>Liste des pizzas</h1>
	<a class="btn btn-primary" href="new">Nouvelle Pizza</a>
	<br>
	<c:if test="${msg != null}">
		<div class="alert alert-danger" role="alert">${msg}</div>
	</c:if>

	<table class="table">
		<tr>
			<td>Image</td>
			<td>Informations</td>
			<td></td>
		</tr>

		<c:forEach var="pizza" items="${listePizzas}">
		<tr>
			<td><img src="${pizza.urlImage}"></td>
			<td>
				<div class="row">
					<div class="col-md-6">
						Ref. ${pizza.id}
						<br> <b>${pizza.nom}</b><br>${pizza.prix}
						€<br>
					</div>
					<div class="col-md-6">
						<a href="<c:url value="/pizzas/edit?code=${pizza.code}"/>" class="btn btn-primary">Editer</a>
						<br>
						<form method="POST">
							<input type="hidden" name="code" value="${pizza.code}">
							<input type="hidden" name="action" value="supprimer">
							<button type="submit" class="btn btn-danger">Supprimer</button>
						</form>
						<form method="POST">
							<input type="hidden" name="id" value="${pizza.id}">
							<input type="hidden" name="action" value="inconnu">
							<button type="submit" class="btn btn-danger">Action
								inconnue</button>
						</form>
					</div>
				</div>
			</td>
		</tr>
		</c:forEach>

	

	</table>
</body>
</html>