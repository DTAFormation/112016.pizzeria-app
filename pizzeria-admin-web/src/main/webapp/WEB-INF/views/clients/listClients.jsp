<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Clients" name="title" />
</jsp:include>
<body>
	<%@include file="../layout/menu.jsp"%>

	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h2>Clients</h2>
					<a
						href="<c:url value="create"/>"
						class="btn btn-primary">Ajouter</a>

					<table id=tableClient class="table table-striped">

						<caption></caption>
						<thead>
							<tr>
								<th>Id</th>
								<th>Nom</th>
								<th>Prénom</th>
								<th>Email</th>
								<th>Adresse</th>
								<th>Mot De Passe</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="clients" items="${listeClients}">
								<tr>
									<td>${clients.id}</td>
									<td>${clients.nom}</td>
									<td>${clients.prenom}</td>
									<td>${clients.email}</td>
									<td>ici une adresse</td>
									<td>${clients.motDePasse}</td>
									<td><a
										href="<c:url value="/admin/clients/update?id=${clients.id}"/>"
										class="btn btn-success">Editer</a></td>
									<td>
										<form method="post">
											<input type="hidden" name="id" value="${clients.id}">
											<button type="submit" class="btn btn-danger">Supprimer</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<%@include file="../layout/activityArea.jsp"%>
	</div>


	<%@include file="../layout/bottom.jsp"%>
</body>
</html>