
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>

<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Acceuil" name="title" />
</jsp:include>

<body>
	<c:import url="../layout/menu.jsp" />
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h1>Nouvel Ingrédient</h1>
					<form method="post" class="form-horizontal">
						<fieldset>

							<!-- Form Name -->
							<legend></legend>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="nom">Nom</label>
								<div class="col-md-4">
									<input id="nom" name="nom" type="text"
										value="${ingredient.nom}" placeholder="Nom de l'ingrédient"
										class="form-control input-md" required pattern="[a-zA-Z]+">

								</div>
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="valider"></label>
								<div class="col-md-4">
									<button id="valider" name="valider" class="btn btn-primary">Valider</button>
									<a href="<c:url value="/admin/ingredients/list"/>"
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
	<c:import url="../layout/bottom.jsp" />
</body>
</html>