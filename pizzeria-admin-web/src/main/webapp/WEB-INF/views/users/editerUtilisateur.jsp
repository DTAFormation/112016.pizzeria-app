<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Page modifier Utilisateur" name="title" />
</jsp:include>
<body>
	<%@include file="../layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h1>Mettre à jour un utilisateur</h1>
					<form name="updateUser" method="POST">
						<div class="form-group">
							<label class="form-control-label" for="nom">Nom</label>
							<input class="form-control" type="text" name="nom" id="nom" value="${oldUtilisateur.getNom()}" required>
						</div>
						<div class="form-group">
							<label class="form-control-label" for="prenom">Prenom</label>
							<input class="form-control" type="text" name="prenom" id="prenom" value="${oldUtilisateur.getPrenom()}" required>
						</div>
						<div class="form-group">
							<label class="form-control-label" for="email">E-mail</label>
							<input class="form-control" type="email" name="email" id="email" value="${oldUtilisateur.getEmail()}" required>
						</div>
						<div class="form-group">
							<label class="form-control-label" for="motdepasse">Mot de passe</label>
							<input class="form-control" type="text" name="motdepasse" id="motdepasse" value="${oldUtilisateur.getMotDePasse()}" required>
						</div>
						<div class="form-group">
							<label class="form-control-label" for="profil">Profil :</label> 
								<select class="form-control" id="profil" name="profil">
									<c:forEach var="profil" items="${ profils }">
										<option value="${ profil.key }" <c:if test="${ oldUtilisateur.profil == profil.key }">selected</c:if> >
											<c:out value="${ profil.value }" />
										</option>
									</c:forEach>
								</select>
						</div>
						<button type="submit" class="btn btn-primary">Modifier</button>
						<a href="list" class="btn btn-secondary">Retour</a>
					</form>
				</div>
			</div>
		</div>
		<%@include file="../layout/activityArea.jsp"%>
	</div>
	<%@include file="../layout/bottom.jsp"%>
</body>
</html>