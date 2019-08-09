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
        <%@include file="/favicon.html" %>
        <title>Gestion DB</title>
    </head>
    <body>
        <%@include file="/Navbar.jsp" %>
        <div class="container recherche" style="text-align: center;">
        <br>
        <br>
        <h1 style="color: white;">Administration</h1>
        <br>
        <br>
        <button class="btn btn-warning"><a style="color:white;" href="<%= getServletConfig().getServletContext().getContextPath() %>/ExporterBDD">Importer dans la base de données</a></button>
        <br>
        <br>
        <p><% if (request.getAttribute("réponse")!=null){out.println(request.getAttribute("réponse") + " média(s) importé(s).");}%></p>
        <br>
        <button class="btn btn-secondary"><a style="color:white;" href="<%= getServletConfig().getServletContext().getContextPath() %>/debug.jsp">Afficher la base de données</a></button>
        <br>
        <br>
        </div>
        <%@include file="/Footer.jsp" %> 
    </body>
</html>