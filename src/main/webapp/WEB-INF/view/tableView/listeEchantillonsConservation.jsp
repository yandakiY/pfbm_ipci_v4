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
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Les echantillons de la reception ${id_reception} <br> (Pour faire les conservations) </h1>
        <div class="btn-toolbar mb-2 mb-md-0">
         
        </div>
      </div>
      
      <div class="container"></div>
      	<div class="row">
      		<div class="row g-3">
      		<!-- CHAMP TABLE DES ECHANTILLONS -->
	      		<div class="req-table-echantillon-par-reception">
	      			<a class="btn-sm btn-danger" href="makeemplacement" style="text-align: center;">Retour a la liste des receptions</a>
		      		
		      		<form style="display:none;" action="">
		      			<input class="" type="search" placeholder="Numero glaciere, nom d'un patient" aria-label="Search">
	                	<button class="btn-sm btn-secondary" type="submit">Rechercher</button>
		      		</form>
	      		 </div>
      		 	
      		 	<c:choose>
      		 		
      		 		<c:when test="${empty listEchantillons }">
						<div class="col-lg-6 text-secondary" style="text-align:center; font-size: 22.5px;border:solid 1px black;margin:auto;margin-top: 150px;">
				      		Pas d'échantillon a conserver pour la reception ${id_reception}
				      	</div>
      		 		</c:when>
      		 		
      		 		<c:when test="${!empty listEchantillons }">
      		 		
      		 		<div class="container-fluid">
      		 			<div class="row">
      		 				<div class="col-lg-6">
      		 				
		      		 			<h3>Echantillons conservés</h3>
		      		 			<table style="font-size: 15px;" class="table table-striped text-center table-bordered">
						          <thead>
						          <tr>
						            <th scope="col">Numero echantillon</th>
						            <th scope="col">Patient</th>
						            <th scope="col">Date de prelevement</th>
						            <th scope="col">Pathologie</th>
						            <th scope="col">Centre de prelevement</th>
						            <th style="display:none;" scope="col">Glaciere</th>
						            <th style="display: none; scope="col">Options</th>
						          </tr>
						          </thead>
						          <tbody>
						          
							          <c:forEach items="${listEchantillons }" var="echantillon">
								          <tr>
								            <th scope="row">${echantillon.getId_echantillon() }</th>
								          	<td>${patient.getPatientByIdPatient(echantillon.getId_patient()).getNom_patient() } ${patient.getPatientByIdPatient(echantillon.getId_patient()).getPrenom_patient() }</td>
								          	<td>${echantillon.getDate_prelevement() }</td>
								          	<td>${pathologie.getPathologieByIdPathologie(echantillon.getId_pathologie()).getNom_pathologie() }</td>
								          	<td>${reception.getReceptionByIdReception(echantillon.getId_reception()).getProvenance() }</td>
								          	<td style="display:none;"></td>
								            <td style="display: none;">
								            	<c:choose>
								            		<c:when test="${echantillon.getStatus_resultat_for_conservation() eq null }">
								            			<a type="button" href="registrationconservation?id_echantillon=${echantillon.getId_echantillon() }" class="btn-sm btn-primary">Ajouter emplacement BioBanque</a>
								            		</c:when>
								            		<c:when test="${echantillon.getStatus_resultat_for_conservation() eq 'Oui'}">
								            			<span style="border:solid 1px black;padding:5px; display: none;"class="bg-primary">Ajout deja effectué</span>
								            			<button type="button" style="" title="Ajout deja effectué" href="registrationconservation?id_echantillon=${echantillon.getId_echantillon() }" class="btn-sm btn-primary" disabled="disabled">Ajouter emplacement BioBanque</button>
								            		</c:when>
								            	</c:choose><!--  
								            	<a type="button" style="display:none;" href="registrationconservation?id_echantillon=${echantillon.getId_echantillon() }" class="btn-sm btn-primary">Ajouter emplacement BioBanque</a>
								            	<a type="button" href="registrationupdateconservation?id_echantillon=${echantillon.getId_echantillon() }&id_reception=${id_reception}" class="btn-sm btn-secondary">Modifier l'emplacement</a>
							            	-->
							            	</td>
								          </tr>
							          </c:forEach>
						          
						          </tbody>
						        </table>
					        </div>
					        
					        <div class="col-lg-6">
      		 				
		      		 			<h3>Echantillons non conservés</h3>
		      		 			<table style="font-size: 15px;" class="table table-striped text-center table-bordered">
						          <thead>
						          <tr>
						            <th scope="col">Numero echantillon</th>
						            <th scope="col">Patient</th>
						            <th scope="col">Date de prelevement</th>
						            <th scope="col">Pathologie</th>
						            <th scope="col">Centre de prelevement</th>
						            <th style="display:none;" scope="col">Glaciere</th>
						            <th style="display: none; scope="col">Options</th>
						          </tr>
						          </thead>
						          <tbody>
						          
							          <c:forEach items="${listEchantillons1 }" var="echantillon">
								          <tr>
								            <th scope="row">${echantillon.getId_echantillon() }</th>
								          	<td>${patient.getPatientByIdPatient(echantillon.getId_patient()).getNom_patient() } ${patient.getPatientByIdPatient(echantillon.getId_patient()).getPrenom_patient() }</td>
								          	<td>${echantillon.getDate_prelevement() }</td>
								          	<td>${pathologie.getPathologieByIdPathologie(echantillon.getId_pathologie()).getNom_pathologie() }</td>
								          	<td>${reception.getReceptionByIdReception(echantillon.getId_reception()).getProvenance() }</td>
								          	<td style="display:none;"></td>
								            <td style="display: none;">
								            	<c:choose>
								            		<c:when test="${echantillon.getStatus_resultat_for_conservation() eq null }">
								            			<a type="button" href="registrationconservation?id_echantillon=${echantillon.getId_echantillon() }" class="btn-sm btn-primary">Ajouter emplacement BioBanque</a>
								            		</c:when>
								            		<c:when test="${echantillon.getStatus_resultat_for_conservation() eq 'Oui'}">
								            			<span style="border:solid 1px black;padding:5px; display: none;"class="bg-primary">Ajout deja effectué</span>
								            			<button type="button" style="" title="Ajout deja effectué" href="registrationconservation?id_echantillon=${echantillon.getId_echantillon() }" class="btn-sm btn-primary" disabled="disabled">Ajouter emplacement BioBanque</button>
								            		</c:when>
								            	</c:choose><!--  
								            	<a type="button" style="display:none;" href="registrationconservation?id_echantillon=${echantillon.getId_echantillon() }" class="btn-sm btn-primary">Ajouter emplacement BioBanque</a>
								            	<a type="button" href="registrationupdateconservation?id_echantillon=${echantillon.getId_echantillon() }&id_reception=${id_reception}" class="btn-sm btn-secondary">Modifier l'emplacement</a>
							            	-->
							            	</td>
								          </tr>
							          </c:forEach>
						          
						          </tbody>
						        </table>
					        </div>
				        	</div>
				        </div>
      		 		</c:when>
      		 	
			        
		      </c:choose>
		     </div>
      	</div>
      </div>

<!-- 
      
-->
    </main>
  </div>
</div>
	
	

    <script src="public/js/bootstrap.min.js"></script>
    
    <script type="text/javascript" src="public/js/js-template/sidebars.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="public/js/js-template/dashboard.js"></script>
  </body>
</html>
