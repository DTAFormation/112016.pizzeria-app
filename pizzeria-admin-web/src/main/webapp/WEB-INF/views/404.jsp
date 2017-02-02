<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="layout/entete.jsp">
    <jsp:param value="404" name="title" />
</jsp:include>
<body>
	<%@include file="./layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h1>Erreur 404</h1>
					<p>La ressource que vous essayer d'atteindre n'as pas été trouvé</p>
					<p>Si vous pensez que ceci est une erreur veuillez contacter un administrateur</p>
				</div>
			</div>
		</div>
		<%@include file="./layout/activityArea.jsp"%>
	</div>
	<%@include file="./layout/bottom.jsp"%>
</body>
</html>
