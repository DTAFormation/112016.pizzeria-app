<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Page Lister Utilisateurs" name="title" />
</jsp:include>

<body>
	<%@include file="../layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h1>Liste des utilisateurs</h1>
					<a class="btn btn-primary" href="new">Nouvel Utilisateur</a>
					<br> 
					<c:if test="${msg != null}">
						<div class="alert alert-danger" role="alert">${msg}</div>
					</c:if>
				
					<table class="table">
						<thead>
							<tr><th>N°</th>
								<th>Nom</th>
								<th>Prénom</th>
								<th>Email</th>
								<th>Profil</th></tr>
						</thead>
					
						<c:forEach var="user" items="${listeUtilisateurs}">
						<tr>
							<td><c:out value="${user.id }"/></td>
							<td><c:out value="${user.nom}"/></td>
							<td><c:out value="${user.prenom }"/></td>
							<td><c:out value="${user.email}"/></td>
							<td><c:out value="${user.profil}"/></td>
								 					
									<td>
										<a href="<c:url value="/admin/users/edit?id=${user.id}"/>" class="btn btn-primary">Editer</a>
									</td>
									<td> 
										<form method="post">
											<input type="hidden" name="code" value="${user.id}">
											<input type="hidden" name="action" value="supprimer">
											<button type="submit" class="btn btn-danger">Supprimer</button>
										</form>
										
									</td>
					
						</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<%@include file="../layout/activityArea.jsp"%>
	</div>
	<%@include file="../layout/bottom.jsp"%>
</body>
</html>