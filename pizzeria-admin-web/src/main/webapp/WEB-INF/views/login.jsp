<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<jsp:include page="./layout/entete.jsp">
	<jsp:param value="Connexion" name="title" />
</jsp:include>
<link rel="stylesheet"
	href="<c:url value="/static/bootstrap/css/signin.css"/>">
<script src="<c:url value="/static/js/sha1.js"/>"></script>
<script language="JavaScript">
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
	    }
	  else if (f.hashInputText.value == f.verif.value) {
	    return true;
	    }
	  else {
	    f.hashInputText.focus();
	    return false;
	    }
	  }
</script>
<body onload="calcHash()">
	<div class="container">
		<form method="POST" class="form-signin">
			<h2 class="form-signin-heading">Se connecter</h2>

			<label for="inputEmail" class="sr-only">Adresse email</label> <input
				type="email" name="email" id="inputEmail" class="form-control"
				placeholder="Adresse email" required> <label
				for="inputPassword" class="sr-only">Mot de passe</label> <input
				type="password" name="hashInputText" id="hashInputText"
				onkeyup="calcHash()" placeholder="Tapez votre mot de passe"
				class="form-control input-md" required>

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
		

			<c:if test="${ not empty erreur }">
				<div class="form-control-feedback">
					Erreur:
					<c:out value="${ erreur }" />
				</div>
			</c:if>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Se
				connecter</button>
		</form>
	</div>

	<%@include file="./layout/bottom.jsp"%>
</body>
</html>