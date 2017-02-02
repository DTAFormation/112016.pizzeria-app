<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="layout/entete.jsp">
    <jsp:param value="500" name="title" />
</jsp:include>

<body>
	<%@include file="./layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h1>Erreur 500</h1>
					<p>Une erreur au niveau du serveur est survenu.</p>
					<p>Si l'erreur persiste veuillez contacter un administrateur</p>
				</div>
			</div>
		</div>
		<%@include file="./layout/activityArea.jsp"%>
	</div>
	<%@include file="./layout/bottom.jsp"%>
</body>
</html>
