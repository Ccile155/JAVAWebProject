<%-- 
    Document   : Meteo
    Created on : 7 août 2019, 13:32:55
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" href="https://unpkg.com/leaflet@1.5.1/dist/leaflet.css" crossorigin=""/>
    <script src="https://unpkg.com/leaflet@1.5.1/dist/leaflet.js" crossorigin=""></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
	<title>Météo</title>
</head>
<body>
    <%@include file="/Navbar.jsp" %>
    <br>
    <div class="container" id="meteo">
	<h1>Météo instantanée</h1>
        <br>
        <input type="text" id="ville" placeholder="paris"/> <input type="text" id="codePays" placeholder="fr"/>
        <button class="btn btn-secondary" id="bouton">Go !</button>
        <p id="retour_api"> </p>
<!-- 		<button  class="spacer" id="comp">Comparons avec Paris</button> -->
	<!--<iframe width="1000" height="500" frameborder="0" allowfullscreen  src="https://umap.openstreetmap.fr/fr/map/meteo_340854?scaleControl=false&miniMap=false&scrollWheelZoom=true&zoomControl=true&allowEdit=false&moreControl=true&searchControl=null&tilelayersControl=null&embedControl=null&datalayersControl=true&onLoadPanel=undefined&captionBar=false"></iframe><p><a href="https://umap.openstreetmap.fr/fr/map/meteo_340854">Voir en plein écran</a></p>-->
	
    	<div id="map">

	</div>
        <br>
    </div>
<%@include file="/Footer.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="api.js"></script>
</body>
</html>