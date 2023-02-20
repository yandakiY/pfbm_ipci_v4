<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Reception numero : ${id_reception } - Plateforme Biologique Moléculaire</title>

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
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Resultats des analyses de l'echantillon ${id_echantillon}</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
         
        </div>
      </div>
      
      <div class="container"></div>
      	<div class="row">
      		<div class="row g-3">
      		<!-- CHAMP TABLE DES ECHANTILLONS -->
	      		<div class="req-table-echantillon-par-reception">
	      		    <a style="display:none;" class="btn-sm btn-danger" href="tableechantillonparreceptionmakeanalyse?id_reception=${id_reception1 }" style="text-align: center;">Retour a la liste des echantillons</a>
	      		    <a class="btn-sm btn-danger" href="tableechantillonparreceptionmakeanalyse?id_reception=${ echantillon.getId_reception() }" style="text-align: center;">Retour a la liste des echantillons</a>
	      			
		      		<form action="">
		      			<input class="" type="search" placeholder="Numero glaciere, nom d'un patient" aria-label="Search">
	                	<button class="btn-sm btn-secondary" type="submit">Rechercher</button>
		      		</form>
	      		 </div>
	      		<c:choose>
	      			<c:when test="${empty listAnalyses}">
	      				<div class="col-lg-6 text-secondary" style="text-align:center; font-size: 28px;border:solid 1px black;margin:auto;margin-top: 150px;">
				      		Pas de resultats pour l'échantillon ${id_echantillon }
				      	</div>
	      			</c:when>
	      			<c:otherwise>
	      				<table class="table table-striped text-center table-bordered">
					          <thead>
					          <tr>
					            <th scope="col">ID analyse</th>
					            <th scope="col">Patient</th>
					            <th scope="col">Pathologie</th>
					            <th scope="col">Date analyse</th>
					            <th scope="col">Type d'analyse</th>
					            <th scope="col">Options</th>
					          </tr>
					          </thead>
					          <tbody>
					          	<c:forEach items="${listAnalyses}" var="analyse">
						          <tr>
						            <th scope="row">${analyse.getId_analyse() }</th>
						          	<td>${ patient.getPatientByIdPatient(echantillon.getId_patient()).getNom_patient() } ${patient.getPatientByIdPatient( echantillon.getId_patient() ).getPrenom_patient()  }</td>
						          	<td>${ pathologie.getPathologieByIdPathologie( echantillon.getId_pathologie() ).getNom_pathologie() }</td>
						          	<td>${analyse.getDate_analyse() }</td>
						          	<td>${typeanalyse.getTypeAnalyse(analyse.getId_type_analyse()).getNom_type_analyse() }</td>
						            <td>
							            <c:choose>
							            	<c:when test="${analyse.getStatus_resultat() eq 'oui' }">
							            		<button disabled="disabled" href="registrationresultatanalyse?id_analyse=${analyse.getId_analyse()}" class="btn-sm btn-primary" aria-disabled="true">Resultat deja donner</button>
							            	</c:when>
							            	<c:when test="${analyse.getStatus_resultat() eq null }">
							            		<a role="button" href="registrationresultatanalyse?id_analyse=${analyse.getId_analyse()}" class="btn-sm btn-primary">Donner les resultats</a>
							            	</c:when>
							            </c:choose>
						            </td>
						          </tr>
					          	</c:forEach>
					          </tbody>
					        </table>
	      			</c:otherwise>
	      		</c:choose>
      		 	</div>
      	</div>
      </div>

    </main>
  </div>
</div>
	
	

    <script src="public/js/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="public/js/js-template/sidebars.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="public/js/js-template/dashboard.js"></script>
  </body>
</html>
