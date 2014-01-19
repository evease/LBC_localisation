//Conversion des degrés en radian
function convertRad(input){
        return (Math.PI * input)/180;
}
 
function Distance(lat_a_degre, lon_a_degre, lat_b_degre, lon_b_degre){
     
    R = 6378000; //Rayon de la terre en mètre
    lat_a = convertRad(lat_a_degre);
    lon_a = convertRad(lon_a_degre);
    lat_b = convertRad(lat_b_degre);
    lon_b = convertRad(lon_b_degre);
     
    d = R * (Math.PI/2 - Math.asin( Math.sin(lat_b) * Math.sin(lat_a) + Math.cos(lon_b - lon_a) * Math.cos(lat_b) * Math.cos(lat_a)));
    return d;
}

function init_ville(){
    
}

function recup_page_lbc(){
    var xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    xmlHttp.open("GET", "http://www.lapagewebquejeparse.com", false);
    xmlHttp.send();
    xmlDoc=xmlHttp.responseText;
    document.write(xmlDoc);
}