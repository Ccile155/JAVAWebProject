<%-- 
    Document   : Success
    Created on : 31 juil. 2019, 12:16:42
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
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <h2> Connexion réussie !</h2>
        <h4> Bienvenue <%String user = (String) session.getAttribute("email");
                        out.println(user); %> </h4>
        <br>
    </body>
</html>
