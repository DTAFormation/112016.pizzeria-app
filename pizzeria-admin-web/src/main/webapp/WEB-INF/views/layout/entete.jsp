<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Pizzeria | ${param.title}</title>
    <link rel="stylesheet" href="<c:url value="/static/bootstrap/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/static/bootstrap/css/bootstrap-theme.css"/>">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="<c:url value="/static/bootstrap/js/bootstrap.js"/>"></script>
    <script>
        var wsocket;
        var serviceLocation = "ws://localhost:8080/pizzeria-admin-web/activity";

        function sendMessage() {

            var msg = '{"origin":"' + "client" + '", "sender":"'
                + "Me" + '", "received":""' + ', "action":""}';
        //    console.log(msg);
            wsocket.send(msg);
        }

        function onMessageReceived(evt) {

            alert("ok");
            var msg = JSON.parse(evt.data);
            console.log(msg);
        }

        function connectToServer() {

            wsocket = new WebSocket(serviceLocation);
            wsocket.onmessage = onMessageReceived;

        }

        $(document).ready(function () {

            connectToServer();
        });
    </script>
</head>
