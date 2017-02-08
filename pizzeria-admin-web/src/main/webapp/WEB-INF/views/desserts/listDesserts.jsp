<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Desserts" name="title" />
</jsp:include>
<body>
	<%@include file="../layout/menu.jsp"%>

	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h2>Desserts</h2>
					<a
						href="<c:url value="/admin/desserts/add"/>"
						class="btn btn-primary">Ajouter</a>

					<table id=tableBoisson class="table table-striped">

						<caption></caption>
						<thead>
							<tr>
								<th>Id</th>
								<th>Nom</th>
								<th>Prix</th>
								<th>Url Image</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="dessert" items="${listerDesserts}">
								<tr>
									<td>${dessert.id} </td>
									<td>${dessert.nom}</td>
									<td>${dessert.prix}</td>
									<td><img width="80px" height="50px" src="<c:url value="${ dessert.urlImage }"/>"></td>
									<td><a
										href="<c:url value="/admin/desserts/edit?id=${dessert.id}"/>"
										class="btn btn-success">Editer</a></td>
									<td>
										<form method="post" action="delete">
											<input type="hidden" name="id" value="${dessert.id}">
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