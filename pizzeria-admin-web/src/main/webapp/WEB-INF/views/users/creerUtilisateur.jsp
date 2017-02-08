<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Nouvel Utilisateur" name="title" />
</jsp:include>
<script src="<c:url value="/static/js/sha1.js"/>"></script>
<script type="text/javascript">
	function calcHash() {
		try {
			var hashInput = document.getElementById("hashInputText");

			var hashInputType = document.getElementById("hashInputType");
			var hashVariant = document.getElementById("hashVariant");
			var hashRounds = document.getElementById("hashRounds");
			var hashOutputType = document.getElementById("hashOutputType");
			var hashOutput = document.getElementById("hashOutputText");

			var hashObj = new jsSHA(
					hashVariant.options[hashVariant.selectedIndex].value,
					hashInputType.options[hashInputType.selectedIndex].value, {
						numRounds : parseInt(hashRounds.value, 10)
					});

			hashObj.update(hashInput.value);
			hashOutput.value = hashObj
					.getHash(hashOutputType.options[hashOutputType.selectedIndex].value);
		} catch (e) {
			hashOutput.value = e.message
		}
	}

	function validation(f) {
		if (f.hashInputText.value != f.verif.value) {
			alert('Ce ne sont pas les mêmes mots de passe!');

			f.hashInputText.focus();
			return false;
		} else if (f.hashInputText.value == f.verif.value) {
			return true;
		} else {
			f.hashInputText.focus();
			return false;
		}
	}
</script>
<body onload="calcHash()">
	<%@include file="../layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h1>Nouvel Utilisateur</h1>
					<form name="ajout_utilisateur" method="POST" onSubmit="return validation(this)">
						<div class="form-group">
							<label class="form-control-label" for="nom">Nom</label> <input
								class="form-control" type="text" name="nom" id="nom" required>
						</div>
						<div class="form-group">
							<label class="form-control-label" for="prenom">Prenom</label> <input
								class="form-control" type="text" name="prenom" id="prenom"
								required>
						</div>
						<div class="form-group">
							<label class="form-control-label" for="email">E-mail</label> <input
								class="form-control" type="email" name="email" id="email"
								required>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Mot de Passe</label> <input
								type="password" name="hashInputText" id="hashInputText"
								onkeyup="calcHash()"
								class="form-control input-md" required>

						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Retaper Mot de
								Passe</label> <input type="password" name="verif" id="verif"
								class="form-control input-md" required>

						</div>

						<!-- ----Not displayed---- -->
						<div style="display: none">
							<select name="hashInputType" id="hashInputType">
								<option selected="selected">TEXT</option>
							</select>
						</div>
						<div style="display: none">
							<select name="hashVariant" id="hashVariant">
								<option>SHA-1</option>
							</select>
						</div>
						<div style="display: none">
							<input type="hidden" size="5" name="hashRounds" id="hashRounds"
								value="1">
						</div>
						<div style="display: none">
							<select type="hidden" name="hashOutputType" id="hashOutputType">
								<option selected="selected">HEX</option>
							</select>
						</div>
						<div>
							<input type="hidden" name="hashOutputText" id="hashOutputText">
						</div>
						<!-- ----Not displayed---- -->



						<div class="form-group">
							<label class="form-control-label" for="profil">Profil :</label> <select
								class="form-control" id="profil" name="profil">
								<c:forEach var="profil" items="${ profils }">
									<option value="${ profil.key }">
										<c:out value="${ profil.value }" />
									</option>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Ajouter</button>
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