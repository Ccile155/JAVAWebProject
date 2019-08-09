<%-- 
    Document   : Success
    Created on : 31 juil. 2019, 12:16:42
    Author     : Administrateur
--%>
<%@page import="Mediatheque.Authentifier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css"> 
        <%@include file="/favicon.html" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/Navbar.jsp" %>
        <br>
        <h1 style="text-align: center; color: #17A2B8;"> Connexion réussie, bienvenue <%= session.getAttribute("user") %>!</h1>
        <div class="container" id="success">
            <br>
            <br>
        </div>  
        <br>
        <%@include file="/Footer.jsp" %>
    </body>
</html>
