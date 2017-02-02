<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Mettre à jour l'ingrédient</title>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="update ingredients" name="title" />
</jsp:include>

</head>
<body>

	<c:import url="../layout/menu.jsp" />
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<c:set var="ingredient" scope="session" value="${param.ingredient}" />
					<form class="form-horizontal" method="post">
						<fieldset>

							<!-- Form Name -->
							<legend>Mettre à jour l'ingrédient</legend>



							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="nom">Nom</label>
								<div class="col-md-4">
									<input id="nom" name="nom" type="text"
										value="${ingredient.nom}" placeholder="Nom de l'ingredient"
										class="form-control input-md" required="">

								</div>
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="valider"></label>
								<div class="col-md-4">
									<button id="valider" name="valider" class="btn btn-primary">Valider</button>
									<a href="<c:url value="list"/>" class="btn btn-danger">Annuler</a>
								</div>
							</div>

						</fieldset>
					</form>


				</div>
			</div>
		</div>
		<%@include file="../layout/activityArea.jsp"%>

	</div>

	<c:import url="../layout/bottom.jsp" />
</body>
</html>