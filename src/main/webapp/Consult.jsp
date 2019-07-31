<%-- 
    Document   : Consult
    Created on : 30 juil. 2019, 11:55:42
    Author     : Administrateur
--%>
<%@page import="Mediatheque.DVD"%>
<%@page import="Mediatheque.Livre"%>
<%@page import="Mediatheque.Catalogue"%>
<%@page import="java.util.ArrayList" 
        import="Mediatheque.Media"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! ArrayList<Media> liste = Catalogue.get();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Consulter</title>
    </head>
    <body>
        <%@include file="/Navbar.jsp" %>
        <br>
        <table class="table container">
          <thead>
            <tr>
              <th scope="col"></th>
              <th scope="col">Titre</th>
              <th scope="col">Auteur</th>
              <th scope="col">Infos</th>
            </tr>
          </thead>
          <tbody>
          <%String type = request.getParameter("t");
            int cpt = 0;
            for (Media item : liste) {
                if (type.equals("livre") && (item instanceof Livre)){
                    Livre l = (Livre)item;
                    %><tr>
                    <th scope='row'> <%= ++cpt %></th>
                    <td><%= l.getTitre() %></td>
                    <td><%= l.getAuteur() %></td><%
                    out.println("<td>"+ l.getNbpage()+ "</td>");
                    %></tr><%}
                if (type.equals("dvd") && (item instanceof DVD)){
                    DVD d = (DVD)item;
                    %><tr>
                    <th scope='row'> <%= ++cpt %></th>
                    <td><%= d.getTitre() %></td>
                    <td><%= d.getAuteur() %></td><%
                    out.println("<td>"+ d.getDuree()+ "</td>");
                    %></tr><%}
            }%>
          </tbody>
        </table>
        <br>       
        <%@include file="/Footer.jsp" %>
    </body>
</html>
