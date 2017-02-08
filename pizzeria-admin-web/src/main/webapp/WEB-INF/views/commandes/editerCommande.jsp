<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="../layout/entete.jsp">
	<jsp:param value="Editer commande" name="title" />
</jsp:include>
<script src="<c:url value="/static/js/options.js"/>"></script>


<body>
	<%@include file="../layout/menu.jsp"%>
	<div class="row">
		<div class="col-lg-9 col-md-9">
			<div class="card">
				<div class="card-block">
					<h1>Editer command</h1>
					<form name="ajout_commande" method="POST" OnSubmit="javascript: valider( document.forms[0].choix );">
						<div class="form-group">
							<label class="form-control-label" for="client">Client :</label> <select
								class="form-control" id="clientId" name="clientId">
								<c:forEach var="client" items="${ clients }">
									<option value="${ client.id }">
										<c:out value="${ client.nom }" />
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label class="form-control-label" for="client">Livreur :</label>
							<select class="form-control" id="livreurId" name="livreurId">
								<c:forEach var="livreur" items="${ livreurs }">
									<option value="${ livreur.id }">
										<c:out value="${ livreur.nom }" />
									</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<table summary="" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<th style="width: 90px;"></th>
									<th style="width: 220px;"></th>
									<th style="width: 150px;"></th>
									<th style="width: 220px;"></th>
									<th style="width: 90px;"></th>
								</tr>
								<tr>
									<td><br></td>
									<td>Pizzas disponibles<br></td>
									<td><br></td>
									<td>Pizzas commandées<br></td>
									<td><br></td>
								</tr>
								<tr>
									<td><br></td>
									<td rowspan="7"><select name="dispo[]" id="dispo"
										style="width: 210px;" size="16" multiple="multiple"
										OnDblClick="javascript: choisirPizza( this.form.dispo, this.form.choix );">
											<c:forEach var="pizza" items="${ pizzas }">
												<option value="${ pizza.id }">
													<c:out value="${ pizza.nom }" />
												</option>
											</c:forEach>
									</select><br></td>
									<td><br></td>
									<td rowspan="7"><select name="choix[]" id="choix"
										style="width: 210px;" size="16" multiple="multiple"
										OnDblClick="javascript: retirerPizza( this.form.choix );">
									<c:forEach var="pizza" items="${ commande.pizzas }">
												<option value="${ pizza.id }">
													<c:out value="${ pizza.nom }" />
												</option>
											</c:forEach>
									</select><br></td>
									<td><br></td>
									<td><input type="button" value="ajouter >"
										OnClick="javascript: choisirPizza( this.form.dispo, this.form.choix );" /><br></td>
								</tr>
								<tr>
									<td><br></td>
									<td><br></td>
									<td><br></td>
								</tr>
								<tr>
									<td><br></td>
									<td><input type="button" value="< retirer"
										OnClick="javascript: retirerPizza( this.form.choix );" /><br></td>
								</tr>
								<tr>
									<td><br></td>
									<td><input type="button" value="<< retirer tout"
										OnClick="javascript: retirerToutePizzas( this.form.choix );" /><br></td>
								</tr>
								<tr>
									<td><br></td>
									<td><br></td>
									<td><br></td>
								</tr>
							</table>
						</div>
						<button type="submit" class="btn btn-primary">Modifier</button>
						<a href="list" class="btn btn-secondary">Retour</a>
					</form>
				</div>
			</div>
		</div>
		<div class="col-lg-3 col-md-3">
			<div class="card">
				<div class="card-block">Ici bientôt zone d'activités</div>
			</div>
		</div>
	</div>
	<%@include file="../layout/bottom.jsp"%>
</body>
</html>