<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Modifier Mode Passe" name="title" />
</jsp:include>
<body>

<script language="JavaScript">
function validation(f) {
 if (f.mdp1.value != f.mdp2.value) {
    alert('Ce ne sont pas les mêmes mots de passe!');
    f.mdp1.focus();
    return false;
    }
  else if (f.mdp1.value == f.mdp2.value) {
    return true;
    }
  else {
    f.mdp1.focus();
    return false;
    }
  }
</script>

	<%@include file="../layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block well">
					<c:set var="client" scope="session" value="${param.client}" />
					<form class="form-horizontal" method="post" onSubmit="return validation(this)" >
						<fieldset>

							<h2>Changer le mot de passe du client</h2>

							<div class="form-group">
								<label class="col-md-4 control-label" for="password">Mot
									de Passe</label>
								<div class="col-md-4">
									<input id="mdp" name="mdp1" type="password"
										value=""
										class="form-control input-md" required>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="password">Retaper Mot
									de Passe</label>
								<div class="col-md-4">
									<input id="mdp" name="mdp2" type="password"
										value=""
										class="form-control input-md" required>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label" for="valider"></label>
								<div class="col-md-4">
								
									<input type="submit"  class="btn btn-primary">
									<a href="<c:url value="/admin/clients/list"/>"
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