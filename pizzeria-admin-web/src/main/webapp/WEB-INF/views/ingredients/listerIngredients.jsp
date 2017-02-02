<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Ingredients" name="title" />
</jsp:include>
<body>
	<c:import url="../layout/menu.jsp" />
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h1>Ingrédients</h1>

					<a href="<c:url value="/admin/ingredients/create"/>"
						class="btn btn-primary">Ajouter</a>

					<table id=tableIngredient class="table table-striped">

						<caption></caption>
						<thead>
							<tr>
								<th>Id</th>
								<th>Nom</th>
								<th></th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="ingredient" items="${listeIngredients}">
								<tr>
									<td>${ingredient.id}</td>
									<td>${ingredient.nom}</td>
									<td><a
										href="<c:url value="/admin/ingredients/update?id=${ ingredient.id }" />"
										class="btn btn-primary">Editer</a></td>
									<td>
										<form method="post" action="delete">
											<input type="hidden" name="id" value="${ ingredient.id }">
											<button class="btn btn-danger" type="submit">Supprimer</button>
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
	<c:import url="../layout/bottom.jsp" />
</body>
</html>