<%-- 
    Document   : Results
    Created on : 1 août 2019, 10:13:52
    Author     : Administrateur
--%>
<%--<%@page import="Mediatheque.FiltrerCata"%>--%>
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
        <%@include file="/Navbar.jsp" %>
        <br>
        <jsp:useBean id="MaRecherche" scope="session" class="Mediatheque.Recherche"/>
        <jsp:setProperty name="MaRecherche" property="titre" />
        <jsp:setProperty name="MaRecherche" property="auteur"/>
        <jsp:setProperty name="MaRecherche" property="param"/>
        
        <div class="container" id="resultats">

            <h1>Résultats</h1>
            <br>
            <jsp:include page="/filtrercata" />
            <% // String m = (String)session.getAttribute("resultat");
//            out.println(m);%>
            
            <!--<p><jsp:getProperty name="MaRecherche" property="titre"/>,-->
                <%--<jsp:getProperty name="MaRecherche" property="auteur"/>--%>
                 <!--qui fait <jsp:getProperty name="MaRecherche" property="param"/>.</p>-->
            
            <br>
            <form name="MaRecherche" method="POST" action="<%=getServletConfig().getServletContext().getContextPath()%>/BeanTest.jsp">
                <button type="submit" class="btn btn-secondary" >Nouvelle Recherche </button>
            </form>
        </div>
        <br>    
        <%@include file="/Footer.jsp" %>
    </body>
</html>
