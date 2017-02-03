<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%-- Menu de navigation à inclure quand le menu est nécessaire --%>
<%--
<nav class="navbar navbar-default">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="./home"><img height="30px" width="auto" src="<c:url value="/static/images/LOGO-DTA-vectorisé.jpg"/>"></a>
		</div>
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="#" disabled="disabled">Utilisateurs</a></li>
				<li><a href="#" disabled="disabled">Pizzas</a></li>
				<li><a href="#" disabled="disabled">Clients</a></li>
				<li><a href="#" disabled="disabled">Commandes</a></li>
				<li><a href="#" disabled="disabled">Livreurs</a></li>
				<li><a href="#" disabled="disabled">Ingrédients</a></li>
				<li><a href="#" disabled="disabled">Statistiques</a></li>
				<li><a href="#" disabled="disabled">Promotions</a></li>
			</ul>
		</div><!--/.nav-collapse -->
--%>
<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
	<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<a class="navbar-brand" href="<c:url value="/admin/home"/>"><img height="30px" width="auto" src="<c:url value="/static/images/LOGO-DTA-vectorisé.jpg"/>"></a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/users/list"/>">Utilisateurs</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/pizzas/list"/>">Pizzas</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/boissons/list"/>">Boissons</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/clients/list"/>">Clients</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/commandes/list"/>">Commandes</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/livreurs/list"/>" >Livreurs</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/admin/ingredients/list"/>">Ingrédients</a></li>
			<li class="nav-item"><a class="nav-link" href="#" disabled="disabled">Statistiques</a></li>
			<li class="nav-item"><a class="nav-link" href="#" disabled="disabled">Promotions</a></li>
		</ul>
		<ul class="navbar-nav float-right">
            <li class="nav-item">
              <a class="nav-link" href="<c:url value="/disconnect"/>">Déconnexion</a>
            </li>
		</ul>
	</div>
</nav>