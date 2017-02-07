<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="col-lg-3 col-md-3">
    <div class="card">
        <div class="card-block">
            <button onclick="sendMessage()">Click me</button>
            Ici bientôt zone d'activités
            <!-- Ici code pour l'affichage de la zone d'activité -->
            <c:forEach var="commande" items="${lastCommands}">
                    <p><c:out value="${ commande }"/></p>
            </c:forEach>
        </div>
    </div>
</div>
