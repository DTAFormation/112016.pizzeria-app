<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Modifier Boisson" name="title" />
</jsp:include>
<body>
	<%@include file="../layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<c:set var="dessert" scope="session" value="${param.dessert}" />
					<form class="form-horizontal" method="post">
						<fieldset>

							<!-- Form Name -->
							<h2>Editer le dessert</h2>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="nom">Nom</label>
								<div class="col-md-4">
									<input id="nom" name="nom" type="text" value="${dessert.nom}"
										placeholder="Nom du dessert" class="form-control input-md"
										required>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="prix">Prix</label>
								<div class="col-md-4">
									<input id="prix" name="prix" type="number"
										value="${dessert.prix}" placeholder=" Prix du dessert"
										class="form-control input-md" required>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="email">Url image</label>
								<div class="col-md-4">
									<input id="url_image" name="url_image" type="url_image"
										value="${dessert.urlImage}" placeholder="Url de l'image"
										class="form-control input-md" required>
								</div>
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="valider"></label>
								<div class="col-md-4">
									<button id="valider" name="valider" class="btn btn-primary">Valider</button>
									<a
										href="<c:url value="list"/>"
										class="btn btn-danger">Annuler</a>
								</div>
							</div>

						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<%@include file="../layout/activityArea.jsp"%>

	</div>
	<%@include file="../layout/bottom.jsp"%>
</body>
</html>