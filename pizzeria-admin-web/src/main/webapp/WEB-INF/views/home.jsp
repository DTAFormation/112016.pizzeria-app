<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>

<jsp:include page="./layout/entete.jsp">
	<jsp:param value="Accueuil" name="title" />
</jsp:include>

<body>
	<%@include file="./layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					Bonjour ${user.nom} ${user.prenom}<br> Bienvenue sur le site
					administrateur de la pizzeria DTA
				</div>
			</div>
		</div>
		<%@include file="./layout/activityArea.jsp"%>
	</div>
	<%@include file="./layout/bottom.jsp"%>
</body>
</html>