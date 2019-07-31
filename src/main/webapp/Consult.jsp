<%-- 
    Document   : Consult
    Created on : 30 juil. 2019, 11:55:42
    Author     : Administrateur
--%>
<%@ page import="java.util.ArrayList" 
         import="Mediatheque.Media"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/style.css">
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
            
          <% ArrayList<Media> attr = (ArrayList<Media>) request.getAttribute("media");
            int cpt = 0;
            //out.println( attribut );
            for (Media item : attr) {
                out.println("<tr>");
                out.println("<th scope='row'>"+ ++cpt +"</th>");
                String[] parts = item.toString().split("de");
                String titre = parts[0]; 
                String [] parts2 = parts[1].split(",");
                String auteur = parts2[0];
                String param = parts2[1];
                out.println("<td>"+titre+"</td>");
                out.println("<td>"+auteur+"</td>");
                out.println("<td>"+param+"</td>");
                out.println("</tr>");
                }
        %>
          </tbody>
        </table>
    <br>       
    <%@include file="/Footer.jsp" %>
    </body>
</html>
