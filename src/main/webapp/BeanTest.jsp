<%-- 
    Document   : BeanTest
    Created on : 31 juil. 2019, 16:24:48
    Author     : Administrateur
--%>
<%--<%@page import="Mediatheque.Recherche"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Recherche</title>
    </head>
    <body>
        <%@include file="/Navbar.jsp" %>
        <jsp:useBean id="MaRecherche" scope="session" class="Mediatheque.Recherche"/>
        <div id="recherche">
            <br>
            <h1 style="text-align:center;">Rechercher un média</h1>
            <form style="width:500px" class="container" name="MaRecherche" method="POST" action="<%=getServletConfig().getServletContext().getContextPath()%>/Results.jsp">
                <div class="form-group">
                  <label for="exampleFormControlInput1">Titre</label>
                  <input name="titre" type="search" class="form-control transparent-input" id="titre" placeholder="Titre" value="<jsp:getProperty name="MaRecherche" property="titre"/>">
                </div>
                <div class="form-group">
                  <label for="exampleFormControlInput1">Auteur</label>
                  <input name="auteur" type="search" class="form-control transparent-input" id="auteur" placeholder="Auteur" value="<jsp:getProperty name="MaRecherche" property="auteur"/>">
                </div>
                <div class="form-check">
                  <input class="form-check-input" type="radio" name="param" id="typeMedia" value="<jsp:getProperty name="MaRecherche" property="param"/>" checked>
                  <label class="form-check-label" for="exampleRadios1"> Livre </label>
                  &nbsp; &nbsp; &nbsp;
                  <input class="form-check-input" type="radio" name="param" id="exampleRadios2" value="<jsp:getProperty name="MaRecherche" property="param"/>">
                  <label class="form-check-label" for="exampleRadios2"> DVD </label>
                </div>
                <br>
                <button type="submit" class="btn btn-secondary">Rechercher</button>   
            </form>
            <br>
            <!--<img src="./images/enfantlit.jpg" alt="enfant qui lit" id="imgSearch"/>-->  
        </div>
        <%@include file="/Footer.jsp" %>    
    </body>
</html>
