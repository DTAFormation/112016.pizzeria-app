<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Modifier Client" name="title" />
</jsp:include>
<body>
	<%@include file="../layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<c:set var="client" scope="session" value="${param.client}" />
					<form class="form-horizontal" method="post">
						<fieldset>

							<!-- Form Name -->
							<h2>Editer le client</h2>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="nom">Nom</label>
								<div class="col-md-4">
									<input id="nom" name="nom" type="text" value="${client.nom}"
										placeholder="Nom du client" class="form-control input-md"
										required>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="prenom">Prénom</label>
								<div class="col-md-4">
									<input id="prenom" name="prenom" type="text"
										value="${client.prenom}" placeholder=" Prénom du client"
										class="form-control input-md" required>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="email">Email</label>
								<div class="col-md-4">
									<input id="email" name="email" type="email"
										value="${client.email}" placeholder=" Email du client"
										class="form-control input-md" required>
								</div>
							</div>

							<!-- Select Basic -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="categorie">Mot
									de Passe</label>
								<div class="col-md-4">
									<input id="mdp" name="mdp" type="text"
										value="${client.motDePasse}"
										placeholder=" Mot de passe du client"
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