<%-- 
    Document   : Connexion
    Created on : 30 juil. 2019, 17:02:27
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Connexion</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css"> 
    </head>
    <body>
        
        <%@include file="/Navbar.jsp" %>
        <br>
        <div class="container">
            <h2>Connexion</h2>
            <form name="Connexion" method="POST" action="<%=getServletConfig().getServletContext().getContextPath()%>/Authentifier">
<!--                <div class="form-group">
                  <label for="exampleFormControlInput1">Nom</label>
                  <input type="name" class="form-control" id="exampleFormControlInput1" placeholder="Votre nom">
                </div>-->
                <div class="form-group">
                  <label for="exampleFormControlInput1">Nom</label>
                  <input name="user" type="text" class="form-control" id="user" placeholder="Pseudo">
                </div>
                <div class="form-group">
                  <label for="exampleFormControlInput1">Adresse mail</label>
                  <input name="email" type="email" class="form-control" id="email" placeholder="name@example.com">
                </div>
                <div class="form-group">
                  <label for="exampleFormControlInput1">Mot de passe</label>
                  <input name="password" type="password" class="form-control" id="password" placeholder="********">
                </div>
                <button type="submit" class="btn btn-info">Connexion</button>
            </form>
        </div>
        <br>    
        <%@include file="/Footer.jsp" %>
    </body>
</html>
