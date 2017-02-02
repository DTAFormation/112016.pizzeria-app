<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Page Lister Pizza" name="title" />
</jsp:include>
<head>
<title>Livreurs</title>
</head>
<body>
	<c:import url="../layout/menu.jsp" />

	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h1>Livreurs</h1>
					<a class="btn btn-primary" href="add">Ajouter</a> <br>
					<table class="table">
						<tr>
							<th>Nom</th>
							<th>Prénom</th>
							<th>Email</th>
							<th></th>
							<th></th>
						</tr>
						<c:forEach var="livreur" items="${listeDeLivreur}">
							<tr>
								<td>${livreur.nom}</td>
								<td>${livreur.prenom}</td>
								<td>${livreur.email}</td>
								<td><a href="edit?code=${livreur.id}"
									class="btn btn-primary">Editer</a></td>
								<td><form method="post" action="delete">
										<input type="hidden" name="IdLivreur" value="${livreur.id}">
										<input type="submit" class="btn btn-danger" value="Supprimer">
									</form></td>
							</tr>
						</c:forEach>
					</table>

				</div>
			</div>
		</div>
		<%@include file="../layout/activityArea.jsp"%>

	</div>

	<c:import url="../layout/bottom.jsp" />

</body>
</html>