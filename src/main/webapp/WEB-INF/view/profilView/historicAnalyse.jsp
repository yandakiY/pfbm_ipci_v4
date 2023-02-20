<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Placer un echantillon dans la Biobanque</title>

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
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Historique des analyses pour l'echantillon : ${id_echantillon }</h1>
      </div>
      <a type="button" href="tableechantillonparreceptionmakeanalyse?id_reception=${echantillon.getId_reception() }" class="btn btn-danger btn-lg-12" style="margin-bottom:15px;">Voir la liste des echantillons</a>
      
      <c:choose>
	      <c:when test="${empty analyses}">
	      	<div class="col-lg-6 text-secondary" style="text-align:center; font-size: 29.5px;border:solid 1px black;margin:auto;margin-top: 150px;">
	      		Pas d'historique d'analyses pour ${id_echantillon }
	      	</div>
	      </c:when>
	      <c:otherwise>
	      <table class="table table-striped text-center table-bordered">
		          <thead>
			          <tr>
			            <th scope="col">ID analyse</th>
			            <th scope="col">Type d'analyse</th>
			            <th scope="col">Date analyse</th>
			            <th scope="col">Observation analyse</th>
			            <th scope="col">Resultat Analyse</th>
			            <th scope="col">Options</th>
			          </tr>
		          </thead>
		          <tbody>
		          	  <c:forEach items="${analyses }" var="analyse">
				          <tr>
				            <th scope="row">${analyse.getId_analyse() }</th>
				          	<td>${typeAnalyse.getTypeAnalyse(analyse.getId_type_analyse()).getNom_type_analyse() }</td>
				          	<td>${analyse.getDate_analyse() }</td>
				          	<c:choose>
				          		<c:when test="${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() eq null }">
				          			<td colspan="2"><span class="text-danger" style="font-weight: bold;">Resultat pas encore disponible.</span></td>
				          		</c:when>
				          		<c:otherwise>
				          			<td style="width: 30%;">${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getObservation_resultat() }</td>
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
				            <td>
				            	<a type="button" href="profilanalyse?id_analyse=${analyse.getId_analyse()}" class="btn-sm btn-primary">Voir plus</a>
				            </td>
				          </tr>
			          </c:forEach>
		          </tbody>
		        </table>
	      <!--  
		      <c:forEach items="${analyses }" var="analyse">
			      <div class="row-historic">
			      	<h4>Id Analyse : ${analyse.getId_analyse() }</h4>
			      	<p>Type d'analyse : ${typeAnalyse.getTypeAnalyse(analyse.getId_type_analyse()).getNom_type_analyse() }</p>
			      	<p>Date Analyse : ${analyse.getDate_analyse() }</p>
			      	<p>Echantillon : ${echantillon.getId_echantillon() }</p>
			      	<c:choose>
			      		<c:when test="${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() eq null }">
			      			<span class="text-danger" style="font-weight: bold;">Resultat pas encore disponible.</span>
			      		</c:when>
			      		<c:otherwise>
			      			<p>Observation faite : <em style="font-weight: bold;">${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getObservation_resultat() } </em></p>
			      			<c:if test="${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() eq 'positif' }">
			      				<p >Resultat : <span class="text-primary" style="font-weight: bold;">${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() }</span></p>
			      			</c:if>
			      			<c:if test="${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() eq 'negatif' }">
			      				<p >Resultat : <span class="text-danger" style="font-weight: bold;">${resultat.getResultatForIdAnalyse(analyse.getId_analyse()).getStatus_resultat() }</span> </p>
			      			</c:if>
			      		</c:otherwise>
			      	</c:choose>
			      </div>
		      </c:forEach>
		      -->
      	 </c:otherwise>
      </c:choose>
      
      			
      
    </main>
  </div>
</div>
	
	

    <script src="public/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="public/js/js-template/sidebars.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="public/js/js-template/dashboard.js"></script>
  </body>
</html>
