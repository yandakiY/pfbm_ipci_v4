<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

double testDouble = 3.14F;
int echantillons = (int) request.getAttribute("echantillons");
int echantillonReceptionnes = (int) request.getAttribute("echantillonReceptionnes"); double perechantillonReceptionnes = ( (double) echantillonReceptionnes / (double) echantillons ) * 100;
int echantillonstraites = (int) request.getAttribute("echantillonTraite"); double perechantillonstraites = ( (double) echantillonstraites / (double) echantillons ) * 100;
int echantillonsconserve = (int) request.getAttribute("echantillonConserve"); double perechantillonsconserve = ( (double) echantillonsconserve / (double) echantillons ) * 100;
int resultatsTransmis = (int) request.getAttribute("echantillonResultatsTransmis"); double perresultatsTransmis = ( (double) resultatsTransmis / (double) echantillons ) * 100;

map = new HashMap<Object,Object>(); map.put("label", "Echantillons non traités"); map.put("y", echantillonReceptionnes);map.put("per", Math.round(perechantillonReceptionnes)); map.put("exploded", true); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Echantillons traités"); map.put("y", echantillonstraites);map.put("per", Math.round(perechantillonstraites)); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Echantillons conservés"); map.put("y", echantillonsconserve); map.put("per", Math.round(perechantillonsconserve)); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Resultats rendus"); map.put("y", resultatsTransmis); map.put("per", Math.round(perresultatsTransmis)); list.add(map);

String dataPoints = gsonObj.toJson(list);
%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    
    <script type="text/javascript">
		window.onload = function() { 
		 
		var chart = new CanvasJS.Chart("chartContainer", {
			theme: "light2",
			animationEnabled: true,
			exportFileName: "Tableau de bord PFBM-IPCI",
			exportEnabled: true,
			title:{
				text: ""
			},
			data: [{
				type: "pie",
				showInLegend: true,
				legendText: "{label}",
				toolTipContent: "{label}: <strong>{per}  % des echantillons</strong>",
				indexLabel: "{y} d'{label}",
				dataPoints : <%out.print(dataPoints);%>
			}]
		});
		 
		chart.render();
		 
		}
	</script>
    <title>Tableau de bord : Plateforme Biologique Moléculaire</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/dashboard/">

    

    <!-- Bootstrap core CSS -->
<link href="public/css/bootstrap.min.css" rel="stylesheet">

<link href="public/css/bootstrap-icons-1.3.0/bootstrap-icons.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="public/css/css-template/sidebars.css" rel="stylesheet">
    <link href="public/css/css-template/dashboard.css" rel="stylesheet">
  </head>
  <body>
    
<%@ include file="/WEB-INF/view/registrationView/header.jsp" %>

<div class="container-fluid">
  <div class="row">
  
    <%@ include file="/WEB-INF/view/registrationView/navsidebar.jsp" %>

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Tableau de bord type : PFBM IPCI</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
         
        </div>
      </div>
      <div id="chartContainer" style="height: 370px; width: 100%;"></div>
      
      <div class="container">
      	<div class="row">
      		  <div class="col-lg-12 col-md-12 infos-dashboard">
		      	<h3>Receptions effectuées</h3>
		      	<span class="info-dashboard">${receptionsEffectuees }</span>
		      </div> 
		      <!--  
		      <div class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Echantillons receptionnés</h3>
		      	<span class="info-dashboard">${echantillonReceptionnés }</span>
		      </div>  
		      
		       <div class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Echantillons traités</h3>
		      	<span class="info-dashboard">${echantillonTraité } / ${echantillons }</span>
		      </div>
		      
		       <div class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Echantillons conservés</h3>
		      	<span class="info-dashboard">${echantillonConservé} / ${echantillons }</span>
		      </div>
		      
		       <div class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Resultats transmis</h3> 
		      	 <span class="info-dashboard">${echantillonResultatsTransmis} / ${echantillons }</span>
		      </div>
		      -->
      	</div>
      </div>

    </main>
  </div>
</div>
	
	

    <script src="public/js/bootstrap.min.js"></script>
   
    <script src="public/js/js-template/canvasjs.min.js"></script>
    <script type="text/javascript" src="public/js/js-template/sidebars.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="public/js/js-template/dashboard.js"></script>
    
  </body>
</html>
