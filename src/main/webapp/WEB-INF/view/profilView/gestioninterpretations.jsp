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
<link href="public/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap Icons CSS -->
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
      
      .title-print{
      	visibility: hidden;
      }
      
      .entete{
      	visibility: hidden;
    	margin-top: -130px;
      }
      
      
      @media print{
      	body *{
      		visibility: hidden;
      	}
      	
      	.title-print , .fiche-analyse , .fiche-analyse *, .box{
      		visibility: visible;
      		
      	}
      	
      	.fiche-analyse{
      		margin-top:-45px;
      	}
      	
      	.title-print{
      		margin-top:-95px;
      	}
      	
      	.entete , .logo-institut , .infos-institut{
      	
      		visibility: visible;
      		height: 150px;
      		margin-top: -30px;
      	}
      	
      	.entete p{
      		visibility: visible;
      		font-size : 15px;
      	}
      	
      	.logo-institut img{
      		visibility: visible;
      	}
      	
      }
    </style>
    
    <style type="text/css" media="print">
    	@page {
    		size:auto;
    		margin:0;
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
    
	<div class="container-fluid entete" style="">
	    	<div class="row">
	    		<div class="col-lg-6 col-md-6 col-6 logo-institut" style="text-align:center; font-size:10px;">
					<br><img alt="" src="public/img/logo.png" width="250" height="130">
		      	</div>
		      	<div class="col-lg-6 col-md-6 col-6 infos-institut" style="text-align:center; font-size:10px;">
	    	  	 	<strong><p>INSTITUT PASTEUR DE COTE D'IVOIRE</p>
					<p>Plateforme de Biologie Moléculaire</p>
					<p>Tel : 22 44 91 00 / 22 48 53 05</p>
					<p>Responsable : Prof. KAKOU Solange</p></strong> 
		      	</div>
	    	</div>
	   </div>
    
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Gestions des interpretations</h1>
    </div>
    
    
      
      <div class="container-fluid">
      	<div class="row flex">
      		<div class="row g-3">
	      		<div class="req-table-echantillon-par-reception">
	      		    <a class="btn-sm btn-danger" href="makeanalyse" style="text-align: center;">Retour</a>
	      			
	      			
		      		<a class="btn-sm btn-success" style="text-align: center;cursor: pointer;display:none;">
		      			Exporter
		      			<i class="bi bi-box-arrow-left"></i>
		      		</a>
		      		<form action="" style="display:none;">
		      			<input class="" type="search" placeholder="Numero glaciere, nom d'un patient" aria-label="Search">
	                	<button class="btn-sm btn-secondary" type="submit">Rechercher</button>
		      		</form>
	      		 </div> 
	      		 
	      		 
	      		 
	      		 <h3 class="title-print" style="font-family: consolas;text-align:center;"></h3>
	      		 <div class="container-fluid fiche-analyse" style="border:solid 1px black;padding:20px;">
	      		 	<div class="row">
		      		 	
		      		 	
		      		 	<!-- 
				      	<table class="table table-striped text-center table-bordered">
				          <thead>
				          <tr>
				            <th scope="col">Numero echantillon</th>
				            <th scope="col">Pathologie</th>
				            <th scope="col">Resultat</th>
				            <th scope="col">Valeur CT</th>
				            <th scope="col">Observations</th>
				          </tr>
				          </thead>
				          <tbody>
				          	<tr>
				          		
				          	</tr>
				          </tbody>
				        </table>  -->
				        <div style="" class="container-fluid">
					        
					        <div class="row">
						        <div style="text-align:justify" class="col-lg-5 col-md-5 col-sm-5">
						        	<h4>Ajouter une interpreation : </h4>
						        	
						        	<form method="post" action="gestionInterpretations">
							        	
							        	<div class="col-md-8">
							              <label for="" class="form-label">Pathologie concernée :</label>
							              <select class="form-select" id="id_pathologie" name="id_pathologie" required>
								              <c:forEach items="${pathologies }" var="pathologie">
								                <option value="${pathologie.getId_pathologie() }">${pathologie.getNom_pathologie() }</option>
								              </c:forEach>
							              </select>
							            </div>
							            
							            <div class="col-md-8">
							              <label for="" class="form-label">Libellé interpretation :</label>
							              <textarea class="form-control" id="libelle_inter" name="libelle_inter"  required></textarea>
							            </div> <br>
							            <button class="btn btn-primary">Ajouter</button>
						            </form>
						        	
						        </div>
						        
						        <div style="text-align: center" class="col-lg-7 col-md-7 col-sm-7">
						        
							        <c:choose>
							        	<c:when test="${empty interpretations}">
							        		<h5 class="text-secondary" style="font-size:25px;margin-top: 85px;">Pas d'interpretations</h5>
							        	</c:when>
							        	
							        	<c:otherwise>
							        		<h4>Liste des interpretations</h4>
									        <table class="table table-striped text-center table-bordered">
									          <thead>
									          <tr>
									            <th scope="col">Interpretations</th>
									            <th scope="col">Pathologie</th>
									            <th scope="col">Options</th>
									          </tr>
									          </thead>
									          <tbody style="font-size:10px;">
									          	<c:forEach items="${interpretations }" var="interpretation">
										          	<tr>
										          		<td>${interpretation.getLibelle_inter() }</td>
										          		<td>${pathologie.getPathologieByIdPathologie( interpretation.getId_pathologie() ).getNom_pathologie() }</td>
										          		<td> 
										          			<a class="btn btn-sm btn-secondary" href="#">Modifier</a>
										          			<a class="btn btn-sm btn-danger" href="#">Supprimer</a>
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
		     </div>
		    
	      	</div>  		 			
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
