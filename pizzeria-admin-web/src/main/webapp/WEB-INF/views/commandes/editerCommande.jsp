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
	
	<%@include file="../layout/bottom.jsp"%>
</body>
</html>