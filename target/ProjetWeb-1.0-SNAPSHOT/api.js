$(function(){

var donnees = {};
var donneesParis = {};
var marker;
var mymap;
var ville = $("#ville").val();
var codePays= $("#codePays").val();
var place = [];
 
//================================================== RECUP DEFAULT ==================================================
    function appelApiParis(){
        $.get("http://api.openweathermap.org/data/2.5/weather?q=paris,fr&APPID=6903be97ffc6fc71dd684deb83487d44&units=Metric", callbackgetSuccess2)

        .done(function(){
                //alert("Olé, ca marche!");
                })
        .fail(function(){
                alert("API pas dispo");
                })
        .always(function(){
                //alert("End of the road, baby");
                });
        };

    var callbackgetSuccess2 = function(data){
        donneesParis = data;
        mapCreate(donneesParis, 0);
        return donneesParis;
    };

    appelApiParis();

//================================================== MAP ==================================================
    function mapCreate(paris, ville){

       if(ville == 0){
           mymap = L.map('map').setView([paris.coord.lat, paris.coord.lon], 5);

           L.tileLayer('https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png',{
               attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
               maxZoom:18,
               id: 'mapbox.streets',
               accessToken: 'your.mapbox.access.token'
           }).addTo(mymap);

           // var marker = L.marker([48.8575, 2.348]).addTo(map);
           marker = L.marker([paris.coord.lat, paris.coord.lon], {draggable:'true'}).addTo(mymap);
           marker.bindPopup("<b>"+paris.name+"</b><br>Température: "+paris.main.temp+"°C.").openPopup();

       } else{
           marker.setLatLng({lat: ville.coord.lat, lng: ville.coord.lon});
           marker.bindPopup("<b>"+ville.name+"</b><br>Température: "+ville.main.temp+"°C.").openPopup();
       }
       //_______________ BASIC MAP INTERACTION _______________
       var popup = L.popup();
       function onMapClick(e) {
           popup
               .setLatLng(e.latlng)
               .setContent("You clicked the map at " + e.latlng.toString())
               .openOn(mymap);
               marker.setLatLng(e.latlng);
               nomVille(e.latlng);
       }
       mymap.on('click', onMapClick);

       function relachement(e) {
           marker.getPopup().setContent(''+marker.getLatLng());
           marker.openPopup();    
       }
       marker.on('dragend', relachement);	
   }

//================================================== RECUP VILLE ==================================================
    // pression d'Enter = clique bouton 
    $("input").keypress(function () {
	var key = event.keyCode;
	if(key == 13 ) { $("#bouton").click(); }
    });
	
    $("#bouton").on("click", function appelApi(){

        $.get("http://api.openweathermap.org/data/2.5/weather?q="+ville+","+codePays+"&APPID=6903be97ffc6fc71dd684deb83487d44&units=Metric", callbackgetSuccess)

        .done(function(){
                // alert("Olé, ca marche!");
                })
        .fail(function(){
                alert("Oups, OWM failed.");
                })
        .always(function(){
                // alert("End of the road, baby");
                })
    });

    var callbackgetSuccess = function(data){
            $("#retour_api").empty();
            $("#retour_api").append("Température à " + data.name+" : " + data.main.temp +"°C.<br/>");
                    if (data.clouds.all <= 25){
                            $("#retour_api").append("<i class='material-icons'>wb_sunny</i><br/>" +data.clouds.all +"% de nuages");
                    }
                    else if (data.clouds.all <= 50 && data.clouds.all > 25){
                            $("#retour_api").append("<i class='material-icons'>filter_drama</i><br/>"+data.clouds.all +"% de nuages");
                    }
                    else if (data.clouds.all <= 75 && data.clouds.all > 50){
                            $("#retour_api").append("<i class='material-icons'>cloud</i><br/>"+ data.clouds.all +"% de nuages");
                    }
                    else if (data.clouds.all <= 100 && data.clouds.all > 75){
                            $("#retour_api").append("<i class='material-icons'>grain</i><br/>"+ data.clouds.all +"% de nuages");
                    };

            donnees = data;
            mapCreate(donneesParis, donnees);
            return donnees;
    };

//================================================== METEO ON CLICK ==================================================
    function nomVille(coord){
        lat = coord.lat;
        lon = coord.lng;

        $.get("http://nominatim.openstreetmap.org/reverse?format=xml&lat="+lat+"&lon="+lon+"&zoom=18&addressdetails=1", conversion)
        .done(function(){
                // alert("Olé, ca marche!");
                })
        .fail(function(){
                alert("Oups, nomVille failed.");
                })
        .always(function(){
                // alert("End of the road, baby");
                });

    }

    var conversion = function(info){
        console.log(info);
        place=[];

        for(let i=0 ; i < info.querySelector("addressparts").getElementsByTagName("*").length ; i++){
            if (info.querySelector("addressparts").getElementsByTagName("*")[i].innerHTML === "undefined"){
                i++;
            } else { 
                place.push(info.querySelector("addressparts").getElementsByTagName("*")[i].innerHTML+", ");}
        }

        console.log(place);
        ville = place[place.length-5];
        codePays = place[place.length-1].substring(0,2);
        console.log("On vise " + ville, codePays);

        $("#bouton").click();
        ville = $("#ville").val();
        codePays= $("#codePays").val();
        
    };		

});