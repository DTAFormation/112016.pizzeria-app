<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Ajouter une boisson" name="title" />
</jsp:include>

<body>
	<%@include file="../layout/menu.jsp"%>

	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block"></div>
				<h2>Nouvelle Boisson</h2>

				<form method="post" class="form-horizontal">
					<fieldset>

						<!-- Form Name -->
						<legend></legend>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="nom">Nom</label>
							<div class="col-md-4">
								<input id="nom" name="nom" type="text"
									placeholder="Nom de la boisson" class="form-control input-md"
									required>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="prenom">Prix</label>
							<div class="col-md-4">
								<input id="prix" name="prix" type="text"
									placeholder=" Prix de la boisson" class="form-control input-md"
									required>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="email">Url
								image</label>
							<div class="col-md-4">
								<input id="url_image" name="url_image" type="text"
									placeholder=" Url de l'image" class="form-control input-md"
									required>
							</div>
						</div>

						<!-- Select Basic -->
						<div class="form-group">
							<label class="col-md-4 control-label" for="categBoisson">Catégorie de boissons
								</label>
							<div class="col-md-4">
								<select id="categorie" name="categorie" class="form-control">
									<option value="GAZ">Gaz</option>
									<option value="SANS_GAZ">Sans gaz</option>
									<option value="ALCOOL">Alcool</option>
								</select>
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
		<%@include file="../layout/activityArea.jsp"%>

	</div>

	<%@include file="../layout/bottom.jsp"%>
</body>
</html>