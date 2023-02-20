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
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Liste des transporteurs</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
         
        </div>
      </div>
      
      <div class="container"></div>
      	<div class="row">
      		<div class="row g-3">
      		<!-- CHAMP TABLE DES ECHANTILLONS -->
	      		<div class="req-table-echantillon">
	      		
		      		
		      		<form action="">
		      			<input class="" type="search" placeholder="Numero glaciere, nom d'un patient" aria-label="Search">
	                	<button style="display: none;" class="btn-sm btn-secondary" type="submit">Rechercher</button>
		      		</form>
	      		 </div>
      		 	<table class="table table-striped text-center table-bordered">
		          <thead>
		          <tr>
		            <th scope="col">Identifiant</th>
		            <th scope="col">Nom</th>
		            <th scope="col">Prenom</th>
		            <th scope="col">Sexe</th>
		            <th scope="col">Contacts</th>
		            <th scope="col">Nombre de receptions</th>
		          </tr>
		          </thead>
		          <tbody>
		          
		          <c:forEach items="${transporteurs }" var="transporteur">
			          <tr>
			            <th scope="row">${transporteur.getId_transporteur() }</th>
			            <td>${transporteur.getNom_transporteur() }</td>
			            <td>${transporteur.getPrenom_transporteur() }</td>
			            <td>
			            	<c:choose>
			            		<c:when test="${transporteur.getSexe_transporteur() eq 'M' }">
			            			Masculin
			            		</c:when>
			            		<c:when test="${transporteur.getSexe_transporteur()  eq 'F'}">
			            			Feminin
			            		</c:when>
			            	</c:choose>
			            </td>
			            <td>${transporteur.getContact_transporteur() }</td>
			            <td>${transporteurDao.getCountReceptionOfTransporteur( transporteur.getId_transporteur() ) }</td>
			           
			            	<c:if test="${ echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq null}">
			            		<td class="bg-info">${echantillon.getStatus_reception() }</td>
			            	</c:if>
			            	
			            	<c:if test="${echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq 'Receptionné-Analysé' and echantillon.getStatus_conservation() eq null and echantillon.getStatus_resultat() eq null}">
			            		<td class="bg-warning">Analysé</td>
			            	</c:if>
			            	
			            	<c:if test="${ echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq 'Receptionné-Analysé' and echantillon.getStatus_conservation() eq 'Receptionné-Analysé-PasConservé' and echantillon.getStatus_resultat() eq 'Receptionné-Analysé-ResultatRendu'}">
			            		<td class="bg-secondary" style="font-weight: bold;">Resultat Rendu</td>
			            	</c:if>
			            	
			            	<c:if test="${ echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq 'Receptionné-Analysé' and echantillon.getStatus_conservation() eq 'Receptionné-Analysé-Conservé' and echantillon.getStatus_resultat() eq 'Receptionné-Analysé-ResultatRendu'}">
			            		<td class="bg-secondary" style="font-weight: bold;">Resultat Rendu</td>
			            	</c:if>
			            
			            	<!--  
			            	<c:if test="${ echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq 'Receptionné-Analysé' and echantillon.getStatus_conservation() eq 'Receptionné-Analysé-PasConservé' and echantillon.getStatus_resultat() eq null}">
			            		<td class="bg-secondary" style="font-weight: bold;">Resultat Pas Rendu</td>
			            	</c:if>
			            	-->
			           
			            	<c:if test="${ echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq 'Receptionné-Analysé' and echantillon.getStatus_conservation() eq 'Receptionné-Analysé-Conservé' and echantillon.getStatus_resultat() eq 'Receptionné-Analysé-ResultatRendu'}">
			            		<td class="bg-success" style="font-weight: bold;">OUI</td>
			            	</c:if>
			            	
			            	<c:if test="${ echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq 'Receptionné-Analysé' and echantillon.getStatus_conservation() eq 'Receptionné-Analysé-PasConservé' and echantillon.getStatus_resultat() eq 'Receptionné-Analysé-ResultatRendu'}">
			            		<td class="bg-danger" style="font-weight: bold;">NON</td>
			            	</c:if>
			            	
			            	<c:if test="${ echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq 'Receptionné-Analysé' and echantillon.getStatus_conservation() eq null and echantillon.getStatus_resultat() eq null}">
			            		<td class="bg-secondary" style="font-weight: bold;">Pas determiné</td>
			            	</c:if>
			            
			            <!-- 
			            <c:choose>
			          		<c:when test="${ echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq null}">
			          			<td class="bg-info">${echantillon.getStatus_reception() }</td>
			          		</c:when>
			          		<c:when test="${echantillon.getStatus_reception() eq 'Receptionné' and echantillon.getStatus_analyse() eq 'Receptionné-Analysé'}">
			          			<td class="bg-warning">Analysé ${echantillon.getStatus_analyse() } </td>
			          		</c:when>
			          		
			          		<c:when test="${ echantillon.getStatus_conservation() eq 'Receptionné-Analysé-PasConservé' and echantillon.getStatus_resultat() eq 'Receptionné-Analysé-ResultatRendu'}">
			          			<td class="bg-dark">${echantillon.getStatus_resultat() } - Pas Conservé</td>
			          		</c:when>
			          		
			          		
			          		
			          	</c:choose>
			          	 -->
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
