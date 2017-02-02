<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/entete.jsp">
		<jsp:param value="Page ajouter Pizza" name="title" />
	</jsp:include>
	
	<body>
		<c:import url="../layout/menu.jsp"/>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
	                <h1>Liste des Pizzas</h1>
					<a class="btn btn-primary" href="<c:url value="/admin/pizzas/add"/>">Nouvelle Pizza</a>
					<br>
					<table class="table">
						<tr>
							<th>#</th>
							<th></th>
							<th>Code</th>
							<th>Nom</th>
							<th>Type</th>
							<th>Prix</th>
							<th>Note</th>
							<th>Date d'ajout</th>
							<th></th>
						</tr>
				
						<c:forEach var="pizza" items="${listePizzas}">
							<tr>
								<td><c:out value="${ pizza.id }"/></td>
								<td><img width="80px" height="50px" src="<c:url value="${ pizza.urlImage }"/>"></td>
								<td><c:out value="${ pizza.code }"/></td>
								<td><c:out value="${ pizza.nom }"/></td>
								<td><c:out value="${ pizza.categorie }"/></td>
								<td><c:out value="${ pizza.prix }"/></td>
								<td><c:out value="${ pizza.note }"/></td>
								<td><c:out value="${ pizza.date }"/></td>
								<td><a href="<c:url value="/admin/pizzas/edit?code=${pizza.code}"/>" class="btn btn-primary">Editer</a></td>
								<td>
									<form method="post" action="delete">
										<input type="hidden" name="code" value="${pizza.code}">
										<button type="submit" class="btn btn-danger">Supprimer</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
					<c:if test="${ not empty message }">
						<div class="alert alert-success alert-dismissible fade show" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				  				<span aria-hidden="true">&times;</span>
				  			</button>
			  				<strong>Félicitation</strong> <c:out value="${ message }"/>
						</div>
					</c:if>
				</div>
			</div>
		</div>
		<%@include file="../layout/activityArea.jsp"%>
	</div>
	    <c:import url="../layout/bottom.jsp"/>
	</body>
</html>