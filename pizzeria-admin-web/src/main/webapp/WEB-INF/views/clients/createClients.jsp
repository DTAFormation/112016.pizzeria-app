<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Ajouter Client" name="title" />
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
			<div class="card well">
				<div class="card-block"></div>
				<h2>Nouveau Client</h2>

				<form method="post" class="form-horizontal"
					onSubmit="return validation(this)">
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


						<div class="form-group">
							<label class="col-md-4 control-label">Mot de Passe</label>
							<div class="col-md-4">
								<input type="password" name="hashInputText" id="hashInputText"
									onkeyup="calcHash()" placeholder="Tapez votre mot de passe"
									class="form-control input-md" required>
							</div>
						</div>

						<div class="form-group">
							<label class="col-md-4 control-label">Retaper Mot de
								Passe</label>
							<div class="col-md-4">
								<input type="password" name="verif" id="verif"
									placeholder="Retapez votre mot de passe"
									class="form-control input-md" required>
							</div>
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