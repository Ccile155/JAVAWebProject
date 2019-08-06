<%-- 
    Document   : Consult
    Created on : 30 juil. 2019, 11:55:42
    Author     : Administrateur
--%>
<%@page import="Mediatheque.Catalogue"%>
<%@page import="Mediatheque.Livre"%>
<%@page import="Mediatheque.DVD"%>
<%@page import="java.util.ArrayList" 
        import="Mediatheque.Media"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%! ArrayList<Media> liste = Catalogue.get();%>--%>
<% ArrayList<Media> liste = (ArrayList)getServletContext().getAttribute("catalogue");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Emprunt</title>
    </head>
    <body>
        <%@include file="/Navbar.jsp" %>
        <br>
        <form class="container" id="emprunt">
            <br>
            <h1>Médias disponibles</h1>
            <br>
            <div class="form-group container">
                <!--<label for="exampleFormControlSelect2">Médias disponibles</label>-->
                <select multiple class="form-control" id="selectEmprunt">
                    <% for (Media item : liste) {
                        %><option><%
                            out.println(item.toString());
                        %></option><%
                    }%>
                </select>
                <br>
                <div style="text-align: center">
                    <button type="submit" class="btn btn-info">Emprunter</button>
                </div>
            </div>
        </form>
        <br>    
        <%@include file="/Footer.jsp" %>   
    </body>
</html>
