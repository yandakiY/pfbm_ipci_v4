<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Les echantillon - Plateforme Biologique Moléculaire</title>

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
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Listes des analyses</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
         
        </div>
      </div>
      
      <div class="container"></div>
      	<div class="row">
      		<div class="row g-3">
      		<!-- CHAMP TABLE DES ECHANTILLONS -->
	      		<div class="req-table-reception">
	      		  
		      		<p  style="font-size: 15px;font-weight: bold;" class="">Resultat connus : ${resultatsConnus }</p>
		      		<p  style="font-size: 15px;font-weight: bold;" class="">Resultat non connus : ${resultatsNonConnus }</p>
		      
		      		<form action="">
		      			<input class="" type="search" placeholder="Numero glaciere, nom d'un patient" aria-label="Search">
	                	
		      		</form>
	      		 </div>
      		 	<table class="table table-hover table-striped text-center table-bordered">
		          <thead>
		          <tr>
		            <th scope="col">Numero analyse</th>
		            <th scope="col">Date analyse</th>
		            <th scope="col">Laboratoire</th>
		            <!-- <th style="display:none;" scope="col">Nombre d'échantillons</th>  -->
		            <th scope="col">Prescripteur</th>
		            <th scope="col">Examen</th>
		            <th scope="col">Type d'analyse</th>
		            <th scope="col">Observation analyse</th>
			        <th scope="col">Resultat Analyse</th>
		          </tr>
		          </thead>
		          <tbody>
		          
		          <c:forEach items="${listesanalyses }" var="analyse">
		          
			          <tr>
			            <th scope="row">${analyse.getId_analyse() }</th>
			            <td>${analyse.getDate_analyse() }</td>
			            <td>${analyse.getNum_labo() }</td>
			            <!-- <td style="display:none;">${reception.getNb_prelevement() }</td>  -->
			            <td>${analyse.getGrade_prescripteur() } ${analyse.getPrescripteur() }</td>
			            <td>${analyse.getType_examen() }</td>
			            <td>${ type_analyse.getTypeAnalyse( analyse.getId_type_analyse() ).getNom_type_analyse() }</td>
			            <c:choose>
				          		<c:when test="${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() eq null }">
				          			<td colspan="2"><span class="text-danger" style="font-weight: bold;">Resultat pas encore disponible.</span></td>
				          		</c:when>
				          		<c:otherwise>
				          			<td style="width: 20%;font-size: 12px;text-align: justify;">${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getObservation_resultat() }</td>
				          			<c:choose>
					          			<c:when test="${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() eq 'positif' }">
					          				<td><span class="text-primary" style="font-weight: bold;text-transform: uppercase;">${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() }</span></td>
					          			</c:when>
					          			<c:when test="${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() eq 'negatif' }">
					          				<td><span class="text-danger" style="font-weight: bold;text-transform: uppercase;">${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() }</span></td>
					          			</c:when>
				          			</c:choose>
				          		</c:otherwise>
				          	</c:choose>
			            
			            <td style="display:none;">
			            	
			            	<c:choose>
			            		 <c:when test="${type_user eq 'TU-2022-1' }">
			            			<a type="button" style="display:none;" href="registrationechantillon?id_reception=${reception.getId_reception() }" class="btn-sm btn-primary">Ajouter des echantillons</a>
			            		 </c:when>
			            		 <c:otherwise>
			            		 	<a type="button" href="registrationechantillon?id_reception=${reception.getId_reception() }" class="btn-sm btn-primary">Ajouter des echantillons</a>
			            		 </c:otherwise>
			            	</c:choose>
			            	<!--  <a type="button" style="display: none;" href="registrationechantillon?id_reception=${reception.getId_reception() }" class="btn-sm btn-primary">Ajouter des echantillons</a>  -->
			            	
			            	<a type="button" href="tableechantillonparreception?id_reception=${reception.getId_reception() }" class="btn-sm btn-secondary">Voir la liste des echantillons</a>
			            </td>
			          </tr>
		          </c:forEach>
		          </tbody>
		        </table>
		      
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
