<%-- 
    Document   : Deconnexion
    Created on : 31 juil. 2019, 16:19:35
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  if (session != null) {
            session.invalidate();
            System.out.println("Je suis dans session logout");
    } 
    response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader ("Expires", 0);
//    this.getServletContext().getRequestDispatcher("/WEB-INF/monlogin.jsp").forward(request, response);
%>
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
        <%@include file="/NavbarOut.jsp" %>
        <br>
        <div id="deco">
            <br>
            <br>
            <br>
            <br>            
            <br>
            <br>
            <h2> Vous avez été déconnecté</h2>
            <br>
        </div>
    </body>
</html>
