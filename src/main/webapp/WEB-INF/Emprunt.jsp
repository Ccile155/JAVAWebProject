<%-- 
    Document   : Consult
    Created on : 30 juil. 2019, 11:55:42
    Author     : Administrateur
--%>
<%@ page import="java.util.ArrayList" 
         import="Mediatheque.Media"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emprunt</title>
    </head>
    <body>
        <%@include file="Navbar.jsp" %>
        <br>
         <form class="container">
            <br>
            <div class="form-group">
                <label for="exampleFormControlSelect2"><h3>Selectionner un média à emprunter</h3></label>
              <select multiple class="form-control" id="exampleFormControlSelect2">
                <% 
                ArrayList<Media> attr = (ArrayList<Media>) request.getAttribute("media");
                for (Media item : attr) {
                    out.println("<option>");
                    out.println(item.toString());
                    out.println("</option>");
                }
                %>
              </select>
              <br>
              <div style="text-align: center">
                <button type="submit" class="btn btn-info">Emprunter</button>
              </div>
            </div>
          </form>
          <br>    
          <%@include file="Footer.jsp" %>    
    </body>
</html>
