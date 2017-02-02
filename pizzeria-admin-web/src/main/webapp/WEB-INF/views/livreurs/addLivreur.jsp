<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Liste de Livreur" name="title" />
</jsp:include>
<body>
	<c:import url="../layout/menu.jsp" />
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<c:choose>
						<c:when test="${ not empty livreur }">
							<h1>Mettre à jour un livreur</h1>
						</c:when>
						<c:otherwise>
							<h1>Nouveau Livreur</h1>
						</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${ not empty livreur }">
							<form method="post" class="col-lg-12" action="edit">
						</c:when>
						<c:otherwise>
							<form method="post" class="col-lg-12" action="add">
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${ not empty livreur }">
							<input type="hidden" name="id" placeholder="id"
								value="${livreur.id}">
						</c:when>
					</c:choose>

					<div class="form-group">
						<input type="text" name="nom" placeholder="Nom"
							value="${livreur.nom}" class=" form-control col-lg-8 "
							required="" required pattern="[a-zA-Z]+">
					</div>
					<div class="form-group">
						<input type="text" name="prenom" placeholder="Prénom"
							value="${livreur.prenom}" class=" form-control col-lg-8 "
							required="" required pattern="[a-zA-Z]+">
					</div>
					<div class="form-group">
						<input type="email" name="email" placeholder="Email"
							value="${livreur.email}" class=" form-control col-lg-8 "
							required="">
					</div>
					<input type="submit"
						class="btn btn-success col-lg-offset-6 col-lg-4" value="Valider">
					<a href="<c:url value="/admin/livreurs/list"/>"
						class="btn btn-danger col-lg-offset-6 col-lg-4">Annuler</a>
					</form>

				</div>
			</div>
		</div>
		<%@include file="../layout/activityArea.jsp"%>

	</div>

	<c:import url="../layout/bottom.jsp" />
</body>
</html>