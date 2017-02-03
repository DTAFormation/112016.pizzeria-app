<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Ajouter Client" name="title" />
</jsp:include>

<body>
	<%@include file="../layout/menu.jsp"%>

	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card well">
				<div class="card-block"></div>
				<h2>Nouveau Client</h2>

				<form method="post" class="form-horizontal">
					<fieldset>

						<!-- Form Name -->
						<legend></legend>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="nom">Nom</label>
							<div class="col-md-4">
								<input id="nom" name="nom" type="text"
									placeholder="Nom du client" class="form-control input-md"
									required>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="prenom">Prénom</label>
							<div class="col-md-4">
								<input id="prenom" name="prenom" type="text"
									placeholder=" Prénom du client" class="form-control input-md"
									required>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="email">Email</label>
							<div class="col-md-4">
								<input id="email" name="email" type="email"
									placeholder=" Email du client" class="form-control input-md"
									required>
							</div>
						</div>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="adresse">Adresse</label>
							<div class="col-md-4">
								<input id="adresse" name="adresse" type="text"
									placeholder=" Adresse du client" class="form-control input-md" 
									required>
							</div>
						</div>

						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-4 control-label" for="password">Mot
								de Passe</label>
							<div class="col-md-4">
								<input id="mdp" name="mdp" type="password"
									placeholder=" Mot de passe du client"
									class="form-control input-md" required>
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