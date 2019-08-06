<%-- 
    Document   : Connexion
    Created on : 30 juil. 2019, 17:02:27
    Author     : Administrateur
--%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
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
            <br>
            <div class="container connexion">
                <h2>Inscription</h2>
                <jsp:useBean id="Inscription" scope="request" class="Mediatheque.UserId"/>
                <form name="Inscription" method="POST" action="<%=getServletConfig().getServletContext().getContextPath()%>/Inscrire">
                    <div class="form-group">
                      <label for="exampleFormControlInput1">Nom *</label>
                      <input name="nom" type="text" class="form-control transparent-input" id="nom" placeholder="Pseudo" required value='<jsp:setProperty name="Inscription" property="nom" value='<%= request.getParameter("nom")%>' />'>
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlInput1">Date de naissance *</label>
                      <input name="date" type="date" class="form-control transparent-input" id="date" required>
                      <jsp:setProperty name="Inscription" property="date" value='<%= request.getParameter("date")%>'/>
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlInput1">Adresse mail *</label>
                      <input name="email" type="email" class="form-control transparent-input" id="email" placeholder="name@example.com" required value='<jsp:setProperty name="Inscription" property="email" value='<%= request.getParameter("email")%>' />'>
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlInput1">Mot de passe *</label>
                      <input name="passwrd" type="password" class="form-control transparent-input" id="passwrd" placeholder="********" required>
                    </div>
                    <div class="form-group">
                      <label for="exampleFormControlInput1">Confirmer mot de passe *</label>
                      <input name="passwrd2" type="password" class="form-control transparent-input" id="passwrd2" placeholder="********" required>
                    </div>
                    <button type="submit" class="btn btn-info">Créer un compte</button>
                </form>
            </div>
        <br>
        <%@include file="/Footer.jsp" %>
    </body>
</html>
