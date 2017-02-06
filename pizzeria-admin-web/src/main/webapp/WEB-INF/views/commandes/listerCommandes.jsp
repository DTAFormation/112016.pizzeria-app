<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<jsp:include page="../layout/entete.jsp">
		<jsp:param value="Liste des commandes" name="title" />
	</jsp:include>
	
	<body>
		<c:import url="../layout/menu.jsp"/>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
	                <h1>Liste des commandes</h1>
					<a class="btn btn-primary" href="<c:url value="/admin/commandes/add"/>">Nouvelle Commande</a>
					<br>
					<table class="table">
						<tr>
							<td>#</td>
							<td>Client</td>
							<td>Livreur</td>
							<td>Listes des pizzas</td>
							<td>Total</td>
							<td>Statut</td>
						</tr>
				
						<c:forEach var="commande" items="${listeCommandes}">
							<tr>
								<td><c:out value="${ commande.id }"/></td>
								<td><c:out value="${ commande.clientId.nom }"/></td>
								<td><c:out value="${ commande.livreurId.nom }"/></td>
								<td><select name="pizzas" id="pizzas"
										style="width: 210px;" size="16">
											<c:forEach var="pizza" items="${ listePizzas }">
												<option value=" Je suis la ${ pizza.id }">
													<c:out value="${ pizza.nom }" />
												</option>
											</c:forEach>
									</select></td>
								<td><c:out value="${ commande.total }"/></td>
								<td><c:out value="${ commande.statut.label }"/></td>
								<td><a href="<c:url value="/admin/commandes/edit?id=${commande.id}"/>" class="btn btn-primary">Editer</a></td>
								<td>
									<form method="post" action="delete">
										<input type="hidden" name="id" value="${commande.id}">
										<button type="submit" class="btn btn-danger">Supprimer</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-3">
			<div class="card">
				<div class="card-block">
					Ici bientôt zone d'activités
				</div>
			</div>
		</div>
	</div>
	    <c:import url="../layout/bottom.jsp"/>
	</body>
</html>