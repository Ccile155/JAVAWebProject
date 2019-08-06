<%-- 
    Document   : admin
    Created on : 6 août 2019, 12:14:53
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Gestion DB</title>
    </head>
    <body>
        <%@include file="/Navbar.jsp" %>
        <br>
        <br>
        <div class="container" style="text-align: center;">
        <h1>Administration</h1>
        <button class="btn btn-warning"><a style="color:white;" href="<%= getServletConfig().getServletContext().getContextPath() %>/ExporterBDD">Créer Base de données</a></button>
        <br>
        <br>
        <p><% if (request.getAttribute("réponse")!=null){out.println(request.getAttribute("réponse"));}%></p>
        <br>
        </div>
        <%@include file="/Footer.jsp" %> 
    </body>
</html>