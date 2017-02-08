<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Entr&eacute;es" name="title" />
</jsp:include>
<body>
	<%@include file="../layout/menu.jsp"%>

	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h2>Entrées</h2>
					<a href="<c:url value="create"/>" class="btn btn-primary">Ajouter</a>

					<table id=tableEntree class="table table-striped">

						<caption></caption>
						<thead>
							<tr>
								<th>Id</th>
								<th>Image</th>
								<th>Nom</th>
								<th>Prix</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="entree" items="${listeEntrees}">
								<tr>
									<td>${entree.id}</td>
									<td><img width="80px" height="50px" src="<c:url value="${ entree.urlImage }"/>"></td>
									<td>${entree.nom}</td>
									<td>${entree.prix} &euro;</td>
									<td><a
										href="<c:url value="/admin/entrees/update?id=${entree.id}"/>"
										class="btn btn-success">Editer</a></td>
									<td>
										<form method="post">
											<input type="hidden" name="id" value="${entree.id}">
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