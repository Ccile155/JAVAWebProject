<%-- 
    Document   : index
    Created on : 30 juil. 2019, 17:01:00
    Author     : Administrateur
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Médiathèque</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
     </head>
    <body >
        <%@include file="/Navbar.jsp" %>
        <div id="Accueil" >
            <br>
            <br>
            <br>
            <br>
            <div id="Annonce">
                <br>
                <br>
                <h1>Bienvenue sur MediaShare,<br>* les médias pas chers *</h1>
                <br>
                <h4> Retrouvez vos livres et DVDs préférés dans notre catalogue </h4>
            </div>
            <br>
        </div>
        <%@include file="/Footer.jsp" %>
    </body>
</html>