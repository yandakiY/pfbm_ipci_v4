<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

int echantillons = (int) request.getAttribute("echantillons");
int echantillonsUlcere = (int) request.getAttribute("echantillonsUlcere"); double perechantillonsUlcere = ( (double) echantillonsUlcere / (double) echantillons ) * 100;
int echantillonsMeningite = (int) request.getAttribute("echantillonsMeningite"); double perechantillonsMeningite = ( (double) echantillonsMeningite / (double) echantillons ) * 100;
int echantillonsLegionnella = (int) request.getAttribute("echantillonsLegionnella"); double perechantillonsLegionnella = ( (double) echantillonsLegionnella / (double) echantillons ) * 100;
int echantillonsChla = (int) request.getAttribute("echantillonsChla"); double perechantillonsChla = ( (double) echantillonsChla / (double) echantillons ) * 100;
 
map = new HashMap<Object,Object>(); map.put("label", "Ulcere de Buruli"); map.put("y", echantillonsUlcere); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Meningite"); map.put("y", echantillonsMeningite); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Legionnella"); map.put("y", echantillonsLegionnella); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "Chlamydiae"); map.put("y", echantillonsChla); list.add(map);
 
String dataPoints = gsonObj.toJson(list);

// // // // // // // // // // // // // // // // // // // // // // // // // Concernant les resultats

Gson gsonObj1 = new Gson();
Map<Object,Object> map1 = null;
List<Map<Object,Object>> list1 = new ArrayList<Map<Object,Object>>();

int resultats = (int) request.getAttribute("resultats");
int resultatsPositifs = (int) request.getAttribute("resultatsPositifs"); double perresultatsPositifs = ( (double) resultatsPositifs / (double) resultats ) * 100;
int resultatsNegatif = (int) request.getAttribute("resultatsNegatif"); double perresultatsNegatif = ( (double) resultatsNegatif / (double) resultats ) * 100;


map1 = new HashMap<Object,Object>(); map1.put("label", "Resultats positifs"); map1.put("y", resultatsPositifs);map1.put("per", Math.round(perresultatsPositifs)); list1.add(map1);
map1 = new HashMap<Object,Object>(); map1.put("label", "Resultats negatifs"); map1.put("y", resultatsNegatif);map1.put("per", Math.round(perresultatsNegatif)); list1.add(map1);

String dataPoints1 = gsonObj1.toJson(list1);

// // // // // // // // // // // // // // // // // // // // // // // // // Concernant le taux de conservation

Gson gsonObj2 = new Gson();
Map<Object,Object> map2 = null;
List<Map<Object,Object>> list2 = new ArrayList<Map<Object,Object>>();

// int echantillons1 = (int) request.getAttribute("echantillons");
int echantillonsConserver = (int) request.getAttribute("echantillonsConserver"); double perechantillonsConserver = ( (double) echantillonsConserver / (double) echantillons ) * 100;
int echantillonPasconserver = (int) request.getAttribute("echantillonPasconserver"); double perechantillonPasconserver = ( (double) echantillonPasconserver / (double) echantillons ) * 100;
int conservationNotDeterminate = (int) request.getAttribute("conservationNotDeterminate"); double perconservationNotDeterminate = ( (double) conservationNotDeterminate / (double) echantillons ) * 100;


map2 = new HashMap<Object,Object>(); map2.put("label", "Echantillons conservés"); map2.put("y", echantillonsConserver);map2.put("per", Math.round(perechantillonsConserver)); list2.add(map2);
map2 = new HashMap<Object,Object>(); map2.put("label", "Echantillons non conservés"); map2.put("y", echantillonPasconserver);map2.put("per", Math.round(perechantillonPasconserver)); list2.add(map2);
map2 = new HashMap<Object,Object>(); map2.put("label", "Pas determinés"); map2.put("y", conservationNotDeterminate);map2.put("per", Math.round(perconservationNotDeterminate)); list2.add(map2);

String dataPoints2 = gsonObj2.toJson(list2);

// // // // // // // // // // // // // // // // // // // // // // // // // Concernant les analyses effectuées pour chaque pathologies

Gson gsonObj3 = new Gson();
Map<Object,Object> map3 = null;
List<Map<Object,Object>> list3 = new ArrayList<Map<Object,Object>>();

int analyse = (int) request.getAttribute("analyse");
int analyseUlcere = (int) request.getAttribute("analyseUlcere"); double peranalyseUlcere = ( (double) analyseUlcere / (double) analyse ) * 100;
int analyseMeningite = (int) request.getAttribute("analyseMeningite"); double peranalyseMeningite = ( (double) analyseMeningite / (double) analyse ) * 100;
int analyseLegionella = (int) request.getAttribute("analyseLegionella"); double peranalyseLegionella = ( (double) analyseLegionella / (double) analyse ) * 100;
int analyseChla = (int) request.getAttribute("analyseChla"); double peranalyseChla = ( (double) analyseChla / (double) analyse ) * 100;
 
map3 = new HashMap<Object,Object>(); map3.put("label", "Ulcere de Buruli"); map3.put("y", analyseUlcere); list3.add(map3);
map3 = new HashMap<Object,Object>(); map3.put("label", "Meningite"); map3.put("y", analyseMeningite); list3.add(map3);
map3 = new HashMap<Object,Object>(); map3.put("label", "Legionnella"); map3.put("y", analyseLegionella); list3.add(map3);
map3 = new HashMap<Object,Object>(); map3.put("label", "Chlamydiae"); map3.put("y", analyseChla); list3.add(map3);
 
String dataPoints3 = gsonObj3.toJson(list3);

%>

<% 

Gson gsonObj4 = new Gson();
Map<Object,Object> map4 = null;
List<Map<Object,Object>> list4 = new ArrayList<Map<Object,Object>>();

int analyseUlcerePositif = (int) request.getAttribute("analyseUlcerePositif");
int analyseLegionellaPositif = (int) request.getAttribute("analyseLegionellaPositif");
int analyseMeningitePositif = (int) request.getAttribute("analyseMeningitePositif");
int analyseChlaPositif = (int) request.getAttribute("analyseChlaPositif");

map4 = new HashMap<Object,Object>(); map4.put("label", "Ulcere"); map4.put("y", analyseUlcerePositif); list4.add(map4);
map4 = new HashMap<Object,Object>(); map4.put("label", "Legionella"); map4.put("y", analyseLegionellaPositif); list4.add(map4);
map4 = new HashMap<Object,Object>(); map4.put("label", "Meningite"); map4.put("y", analyseMeningitePositif); list4.add(map4);
map4 = new HashMap<Object,Object>(); map4.put("label", "Chlamydiae"); map4.put("y", analyseChlaPositif); list4.add(map4);
 
String dataPoints4 = gsonObj.toJson(list4);

int analyseUlcereNegatif = (int) request.getAttribute("analyseUlcereNegatif");
int analyseLegionellaNegatif = (int) request.getAttribute("analyseLegionellaNegatif");
int analyseMeningiteNegatif = (int) request.getAttribute("analyseMeningiteNegatif");
int analyseChlaNegatif = (int) request.getAttribute("analyseChlaNegatif");
 
list4 = new ArrayList<Map<Object,Object>>();
map4 = new HashMap<Object,Object>(); map4.put("label", "Ulcere"); map4.put("y", analyseUlcereNegatif); list4.add(map4);
map4 = new HashMap<Object,Object>(); map4.put("label", "Legionella"); map4.put("y", analyseLegionellaNegatif); list4.add(map4);
map4 = new HashMap<Object,Object>(); map4.put("label", "Meningite"); map4.put("y", analyseMeningiteNegatif); list4.add(map4);
map4 = new HashMap<Object,Object>(); map4.put("label", "Chlamydiae"); map4.put("y", analyseChlaNegatif); list4.add(map4);
 
String dataPoints5 = gsonObj.toJson(list4);

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
				animationEnabled: true,
				title: {
					text: "Nombre d'echantillons par pathologies"
				},
				axisY: {
					suffix: "",
					includeZero: true,
					title: "Nombre d'échantillons"
				},
				axisX: {
					title: "Pathologies"
				},
				data: [{
					type: "column",
					yValueFormatString: "#,##0\" echantillons\"",
					dataPoints: <%out.print(dataPoints);%>
				}],
				theme:"dark1"
			});
			
			var chart1 = new CanvasJS.Chart("chartContainer1", {
				theme: "dark1",
				animationEnabled: true,
				exportFileName: "",
				exportEnabled: false,
				title:{
					text: "Taux de positivité des échantillons"
				},
				data: [{
					type: "pie",
					showInLegend: true,
					legendText: "{label}",
					toolTipContent: "{label}: <strong>{per}  % des resultats</strong>",
					indexLabel: "{label}",
					dataPoints : <%out.print(dataPoints1);%>
				}]
			});
			
			var chart2 = new CanvasJS.Chart("chartContainer2", {
				theme: "dark1",
				animationEnabled: true,
				exportFileName: "",
				exportEnabled: false,
				title:{
					text: "Taux de conservation des échantillons"
				},
				data: [{
					type: "pie",
					showInLegend: true,
					legendText: "{label}",
					toolTipContent: "{label}: <strong>{y} échantillons</strong>",
					indexLabel: "{label}",
					dataPoints : <%out.print(dataPoints2);%>
				}]
			});
			
			var chart3 = new CanvasJS.Chart("chartContainer3", {
				animationEnabled: true,
				title: {
					text: "Nombre d'analyses par pathologies"
				},
				axisY: {
					suffix: "",
					includeZero: true,
					title: "Nombre d'analyses"
				},
				axisX: {
					title: "Pathologies"
				},
				data: [{
					type: "column",
					yValueFormatString: "#,##0\" analyses\"",
					dataPoints: <%out.print(dataPoints3);%>
				}],
				theme:"dark1"
			});
			
			
			var chart4 = new CanvasJS.Chart("chartContainer4", {
				animationEnabled: true,
				theme: "dark1",
				title: {
					text: "Taux de positivité/negativité de chaque pathologie"
				},
				axisY: {
					title: "en nombre d'echantillons",
					includeZero: true
				},
				toolTip: {
					shared: true
				},
				legend: {
					cursor: "pointer",
					itemclick: toggleDataSeries
				},
				data: [{
					type: "column",
					name: "Positif",
					yValueFormatString: "#0.0# nombre d'echantillons",
					showInLegend: true,
					dataPoints: <%out.print(dataPoints4);%>
				}, {
					type: "column",
					name: "Negatif",
					yValueFormatString: "#0.## nombre d'echantillons",
					showInLegend: true,
					dataPoints: <%out.print(dataPoints5);%>
				}]
			});
			
			
			function toggleDataSeries(e) {
				if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
					e.dataSeries.visible = false;
				}
				else {
					e.dataSeries.visible = true;
				}
				chart4.render();
			}
			
			
			chart.render();
			chart1.render();
			chart2.render();
			chart3.render();
			chart4.render();
		 
		}
		
		
		
		
	</script>
    
   
    <title>Statistiques des pathologies</title>

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
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Tableau de bord de PFBM-IPCI</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
         
        </div>
      </div>
      
      <div class="container">
      	<div class="row">
      		  <div style="display:none;" class="col-lg-12 col-md-12 infos-dashboard">
		      	<h3>Echantillons totals: ${echantillons }</h3>
		      </div> 
		      
		      <div style="display:none;" class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Pathologie Ulcere de Buruli : ${echantillonsUlcere }</h3>
		      </div> 
		      <div style="display:none;" class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Pathologie Meningite : ${echantillonsMeningite }</h3>
		      </div> 
		      <div style="display:none;" class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Pathologie Legionnella : ${echantillonsLegionnella }</h3>
		      </div>
		      <div style="display:none;" class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Pathologie Chlamydiae : ${echantillonsChla }</h3>
		      </div>  
		      <div  class="col-lg-6 col-md-12 infos-dashboard">
		      	<div id="chartContainer" style="height: 370px; width: 100%;font-size:15px;"></div>
		      </div>
		      <div class="col-lg-6 col-md-12 infos-dashboard">
		      	<h3 style="display:none;">Taux de positivité</h3>
		      	<div id="chartContainer1" style="height: 370px; width: 100%;font-size:15px;"></div>
		      </div>
		      <div class="col-lg-6 col-md-12 infos-dashboard">
		      	<h3 style="display:none;">Taux de positivité</h3>
		      	<div id="chartContainer2" style="height: 370px; width: 100%;font-size:15px;"></div>
		      </div>
		      <div class="col-lg-6 col-md-12 infos-dashboard">
		      	<h3 style="display:none;">Taux de positivité</h3>
		      	<div id="chartContainer3" style="height: 370px; width: 100%;font-size:15px;"></div>
		      </div>
		      
		      <div class="col-lg-12 col-md-12 infos-dashboard">
		      	<h3 style="display:none;" >Test Pi : ${essaiPi }</h3>
		      	<div id="chartContainer4" style="height: 370px; width: 100%;font-size:15px;"></div>
		      </div>
		      <div style="display:none;" class="col-lg-6 col-md-12 infos-dashboard">
		      	<h3 >Test Pi : ${essaiPi }</h3>
		      	<div style="">
		      		<strong>Analyse Positif</strong> <br>
		      		Analyse Positif Ulcere : ${analyseUlcerePositif } <br>
		      		Analyse Positif Legionella : ${analyseLegionellaPositif*5 } <br>
		      		Analyse Positif Chlamydiae : ${analyseChlaPositif } <br>
		      		Analyse Positif Meningite : ${analyseMeningitePositif } <br>
		      		<strong>Analyse Negatif</strong> <br>
		      		Analyse Negatif Ulcere : ${analyseUlcereNegatif} <br>
		      		Analyse Negatif Legionella : ${analyseLegionellaNegatif } <br>
		      		Analyse Negatif Chlamydiae : ${analyseChlaNegatif } <br>
		      		Analyse Negatif Meningite : ${analyseMeningiteNegatif } <br>
		      	</div>
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
