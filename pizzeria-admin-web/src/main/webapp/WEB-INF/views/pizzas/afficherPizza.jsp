<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Page Lister Pizza" name="title" />
</jsp:include>

<body>
	<c:import url="../layout/menu.jsp" />
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<div>
						<form method="post"
							<c:choose>
								<c:when test="${ not empty pizza.date }">
									action="edit"
								</c:when>
								<c:otherwise>
									action="add"
								</c:otherwise>
							</c:choose>>

							<c:choose>
								<c:when test="${ not empty pizza.date }">
									<h1>Mettre à Jour la Pizza</h1>
								</c:when>
								<c:otherwise>
									<h1>Ajouter une Pizza</h1>
								</c:otherwise>
							</c:choose>

							<!-- Form groupe pour le code -->
							<c:choose>
								<c:when test="${not empty form.erreurs['code'] }">
									<div class="form-group has-danger">
										<label class="form-control-label" for="nom">Code :</label> <input
											type="text" name="code" id="code"
											value="<c:out value="${ pizza.code }"/>"
											class="form-control form-control-danger" />
										<div class="form-control-feedback">
											Erreur:
											<c:out value="${ form.erreurs['code'] }" />
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group">
										<label class="form-control-label" for="code">* Code :</label>
										<input type="text" name="code" id="code"
											value="<c:out value="${ pizza.code }"/>" class="form-control" />
									</div>
								</c:otherwise>
							</c:choose>

							<!-- Form groupe pour le nom -->
							<c:choose>
								<c:when test="${not empty form.erreurs['nom'] }">
									<div class="form-group has-danger">
										<label class="form-control-label" for="nom">* Nom :</label> <input
											type="text" name="nom" id="nom"
											value="<c:out value="${ pizza.nom }"/>"
											class="form-control form-control-danger" />
										<div class="form-control-feedback">
											Erreur:
											<c:out value="${ form.erreurs['nom'] }" />
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group">
										<label class="form-control-label" for="nom">* Nom :</label> <input
											type="text" name="nom" id="nom"
											value="<c:out value="${ pizza.nom }"/>" class="form-control" />
									</div>
								</c:otherwise>
							</c:choose>


							<!-- Form groupe pour les categories -->
							<div
								<c:choose>
									<c:when test="${not empty form.erreurs['categorie'] }"> class="form-group row has-danger" </c:when>
									<c:otherwise>class="form-group"</c:otherwise>
								</c:choose>>
								<label class="form-control-label" for="categorie">* Catégorie :</label> 
								<select class="form-control" id="categorie"
									name="categorie">
									<c:forEach var="type" items="${ categories }">
										<option value="${ type.key }"
											<c:if test="${ pizza.categorie == type.key }">selected</c:if>>
											<c:out value="${ type.value }" />
										</option>
									</c:forEach>
								</select>
								<c:if test="${not empty form.erreurs['categorie'] }">
									<small>Erreur: <c:out
											value="${ form.erreurs['categorie'] }" /></small>
								</c:if>
							</div>

							<!-- Form groupe pour le prix -->
							<c:choose>
								<c:when test="${not empty form.erreurs['prix'] }">
									<div class="form-group has-danger">
										<label class="form-control-label" for="prix">* Prix :</label>
										<span class="input-group-addon">$</span> <input
											pattern="\d+(\.)?\d+" required type="text" name="prix"
											id="prix" value="<c:out value="${ pizza.prix }"/>"
											class="form-control form-control-danger" />
										<div class="form-control-feedback">
											Erreur:
											<c:out value="${ form.erreurs['prix'] }" />
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group">
										<label class="form-control-label" for="prix">* Prix :</label>
										<input pattern="\d+(\.)?\d+" required type="text" name="prix"
											id="prix" value="<c:out value="${ pizza.prix }"/>"
											class="form-control" />
									</div>
								</c:otherwise>
							</c:choose>

							<!-- Form groupe pour l'url de l'image -->
							<c:choose>
								<c:when test="${not empty form.erreurs['urlImage'] }">
									<div class="form-group has-danger">
										<label class="form-control-label" for="urlImage">Url
											Image :</label> <input type="text" name="urlImage" id="urlImage"
											value="<c:out value="${ pizza.urlImage }"/>"
											class="form-control form-control-danger" />
										<div class="form-control-feedback">
											Erreur:
											<c:out value="${ form.erreurs['urlImage'] }" />
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="form-group">
										<label class="form-control-label" for="urlImage">* Url
											Image :</label> <input type="text" name="urlImage" id="urlImage"
											value="<c:out value="${ pizza.urlImage }"/>"
											class="form-control" />
									</div>
								</c:otherwise>
							</c:choose>

							<!-- Form group de validation -->
							<div class="form-group">
								<c:choose>
									<c:when test="${ not empty pizza.date }">
										<div class="col-8"></div>
										<div class="col-4">
											<input type="hidden" name="oldCode" value="${ pizza.code }">
											<button type="submit" class="btn btn-primary">Modifier</button>
										</div>
									</c:when>
									<c:when test="${ not empty requestScope.form.erreurs }">
										<div class="col-8">
											<div class="alert alert-danger">
												<strong>Erreur!</strong>
												<c:out value="${ requestScope.form.resultat }" />
											</div>
										</div>
										<div class="col-4">
											<button type="submit" class="btn btn-primary">Créer</button>
										</div>
									</c:when>
									<c:otherwise>
										<div class="col-8"></div>
										<div class="col-4">
											<button type="submit" class="btn btn-primary">Créer</button>
										</div>
									</c:otherwise>
								</c:choose>
							</div>
							<strong>* Champs requis</strong>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-3">
			<div class="card">
				<div class="card-block">Ici bientôt zone d'activités</div>
			</div>
		</div>
	</div>
	<c:import url="../layout/bottom.jsp" />
</body>
</html>