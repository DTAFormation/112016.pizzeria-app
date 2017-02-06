<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
	<button class="navbar-toggler navbar-toggler-right" type="button"
		data-toggle="collapse" data-target="#navbarCollapse"
		aria-controls="navbarCollapse" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="<c:url value="/admin/home"/>"><img
		height="30px" width="auto"
		src="<c:url value="/static/images/LOGO-DTA-vectorisé.jpg"/>"></a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav mr-auto">

			<c:choose>
				<c:when
					test="${fn:contains(pageContext.request.requestURI, 'users')}">
					<li class="nav-item active" style="background-color: gray;"><a class="nav-link"
						href="<c:url value="/admin/users/list"/>">Utilisateurs</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/admin/users/list"/>">Utilisateurs</a></li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when
					test="${fn:contains(pageContext.request.requestURI, 'pizzas')}">

					<li class="nav-item active" style="background-color: gray;"><a class="nav-link"
						href="<c:url value="/admin/pizzas/list"/>">Pizzas</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/admin/pizzas/list"/>">Pizzas</a></li>
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when
					test="${fn:contains(pageContext.request.requestURI, 'entrees')}">

					<li class="nav-item active" style="background-color: gray;"><a class="nav-link"
						href="<c:url value="/admin/entrees/list"/>">Entrees</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/admin/entrees/list"/>">Entrees</a></li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when
					test="${fn:contains(pageContext.request.requestURI, 'clients')}">
					<li class="nav-item active" style="background-color: gray;"><a class="nav-link"
						href="<c:url value="/admin/clients/list"/>"> Clients </a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/admin/clients/list"/>"> Clients </a></li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when
					test="${fn:contains(pageContext.request.requestURI, 'commandes')}">
					<li class="nav-item active" style="background-color: gray;"><a class="nav-link"
						href="<c:url value="/admin/commandes/list"/>">Commandes</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/admin/commandes/list"/>">Commandes</a></li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when
					test="${fn:contains(pageContext.request.requestURI, 'livreurs')}">
					<li class="nav-item active" style="background-color: gray;"><a class="nav-link"
						href="<c:url value="/admin/livreurs/list"/>">Livreurs</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/admin/livreurs/list"/>">Livreurs</a></li>
				</c:otherwise>
			</c:choose>


			<c:choose>
				<c:when
					test="${fn:contains(pageContext.request.requestURI, 'ingredients')}">
					<li class="nav-item active" style="background-color: gray;"><a class="nav-link"
						href="<c:url value="/admin/ingredients/list"/>">Ingrédients</a></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item"><a class="nav-link"
						href="<c:url value="/admin/ingredients/list"/>">Ingrédients</a></li>
				</c:otherwise>
			</c:choose>



			<!-- 			<li class="nav-item"><a class="nav-link" href="#" -->
			<!-- 				disabled="disabled">Statistiques</a></li> -->

			<!-- 			<li class="nav-item"><a class="nav-link" href="#" -->
			<!-- 				disabled="disabled">Promotions</a></li> -->

		</ul>

		<ul class="navbar-nav float-right">
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="/disconnect"/>">Déconnexion</a></li>
		</ul>

	</div>
</nav>