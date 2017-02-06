<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE>
<html>
<jsp:include page="./layout/entete.jsp">
    <jsp:param value="Connexion" name="title"/>
</jsp:include>
<link rel="stylesheet" href="<c:url value="/static/bootstrap/css/signin.css"/>">
<body>
<div class="container">
    <form method="POST" class="form-signin">
        <h2 class="form-signin-heading">Se connecter</h2>
        <label for="inputEmail" class="sr-only">Adresse email</label>
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Adresse email" required>
        <label for="inputPassword" class="sr-only">Mot de passe</label>
        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Mot de passe"
               required>
        <c:if test="${ not empty erreur }">
            <div class="form-control-feedback">Erreur: <c:out value="${ erreur }"/></div>
        </c:if>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
    </form>
</div>

<%@include file="./layout/bottom.jsp" %>

</body>
</html>