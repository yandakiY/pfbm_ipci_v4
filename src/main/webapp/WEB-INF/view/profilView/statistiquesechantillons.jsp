<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>



<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    
   
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
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Statistiques des échantillons</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
         
        </div>
      </div>
      
      <div class="container">
      	<div class="row">
      		  <div class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Receptions effectuées</h3>
		      </div> 
		      
		      <div class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Receptions effectuées</h3>
		      </div> 
		      <div class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Receptions effectuées</h3>
		      </div> 
		      <div class="col-lg-6 col-md-6 infos-dashboard">
		      	<h3>Receptions effectuées</h3>
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
