<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>

	<jsp:include page="./layout/entete.jsp">
		<jsp:param value="Accueuil" name="title" />
	</jsp:include>

<body>
	<c:import url="./layout/menu.jsp"/>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<!-- PUT THINGS HERE -->
				</div>
			</div>
		</div>
		<c:import url="./layout/activityArea.jsp"/>
	</div>
	<c:import url="./layout/bottom.jsp"/><!-- Attention a l'adresse selon la localisation de la jsp courante -->
</body>
</html>