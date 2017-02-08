<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Ajouter Entr&eacute;e" name="title" />
</jsp:include>

<body>

	<%@include file="../layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card well">
				<div class="card-block"></div>
				<h2>Nouvelle Entrée</h2>

				<form method="post" class="form-horizontal">
					<fieldset>
						<div class="form-group">
							<label class="col-md-4 control-label" for="nom">Nom</label>
							<div class="col-md-4">
								<input id="nom" name="nom" type="text"
									placeholder="Nom de l'entrée" class="form-control input-md"
									required>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label" for="nom">Prix</label>
							<div class="col-md-4">
								<input id="prix" name="prix" type="number"
									class="form-control input-md" required step="any">
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label" for="nom">Url Image</label>
							<div class="col-md-4">
								<input id="image" name="image" type="text"
									 class="form-control input-md"
									required>
							</div>
						</div>

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