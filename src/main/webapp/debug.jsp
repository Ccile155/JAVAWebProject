<%-- 
    Document   : debug
    Created on : 7 août 2019, 11:29:25
    Author     : Administrateur
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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
        <title>Debug affichage Media</title>
    </head>
    <body>
        <%@include file="/Navbar.jsp" %>
        <div class="container recherche" style="text-align: center;">
            <br>
            <br>
            <h1>Liste des médias</h1>
            <br>
            <sql:setDataSource var="mediatheque" driver ="com.mysql.jdbc.Driver" 
                               url="jdbc:mysql://localhost:3306/mediatheque?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
                               user="root" password=""/>

            <sql:query var="medias" dataSource="${mediatheque}">
                SELECT titre, auteur, nbpage FROM media;
            </sql:query>
            <table class="table container" style="width:60%;">
             <thead>
               <tr>
                 <th scope="col">N°</th>
                 <th scope="col">Titre</th>
                 <th scope="col">Auteur</th>
                 <th scope="col">Infos</th>
               </tr>
             </thead>
             <tbody>
               <c:forEach var="x" items="${medias.rows}" varStatus="cpt">
                   <tr><td>${cpt.count}</td><td>${x.titre}</td><td>${x.auteur}</td><td>${x.nbpage}</td></tr>
               </c:forEach>
             </tbody>
            </table>
            <br>
        </div>
        <%@include file="/Footer.jsp" %>        
    </body>
</html>
