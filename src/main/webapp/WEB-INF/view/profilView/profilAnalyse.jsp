<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Resultat_${id_analyse }</title>

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
      		margin-top: 20px;
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
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Fiche des rendus des résultats : ${id_analyse }</h1>
    </div>
    
    
      
      <div class="container-fluid">
      	<div class="row flex">
      		<div class="row g-3">
	      		<div class="req-table-echantillon-par-reception">
	      		    <a class="btn-sm btn-danger" href="historiqueanalyse?id_echantillon=${analyse.getId_echantillon() }" style="text-align: center;">Retour a la liste des analyses</a>
	      			
	      			<a class="btn-sm btn-primary" onclick="window.print()" style="text-align: center;cursor: pointer;"> 
	      				Imprimer
	      				<i class="bi bi-printer"></i>
	      			</a>
		      		<a class="btn-sm btn-success" style="text-align: center;cursor: pointer;display:none;">
		      			Exporter
		      			<i class="bi bi-box-arrow-left"></i>
		      		</a>
		      		<form action="" style="display:none;">
		      			<input class="" type="search" placeholder="Numero glaciere, nom d'un patient" aria-label="Search">
	                	<button class="btn-sm btn-secondary" type="submit">Rechercher</button>
		      		</form>
	      		 </div> 
	      		 
	      		 
	      		 
	      		 <h3 class="title-print" style="font-family: consolas;text-align:center;">Fiche des rendus des résultats : ${id_analyse }</h3>
	      		 <div class="container-fluid fiche-analyse" style="border:solid 1px black;padding:20px;">
	      		 	<div class="row">
		      		 	<div class="col-lg-6 col-md-6 col-sm-6" style="border:solid .5px black;font-size: 15px">
		      		 		<span style="">Nom : ${patient.getPatientByIdPatient( echantillon.getEchantillonByIdEchantillon( analyse.getId_echantillon() ).getId_patient() ).getNom_patient() } </span> <br>
		      		 		<span style="">Prenom : ${patient.getPatientByIdPatient( echantillon.getEchantillonByIdEchantillon( analyse.getId_echantillon() ).getId_patient() ).getPrenom_patient() } </span> <br>
		      		 		<span style="">Sexe : ${patient.getPatientByIdPatient( echantillon.getEchantillonByIdEchantillon( analyse.getId_echantillon() ).getId_patient() ).getSexe_patient() } </span> <br>
		      		 		<span style="">Âge : ${patient.getPatientByIdPatient( echantillon.getEchantillonByIdEchantillon( analyse.getId_echantillon() ).getId_patient() ).getAge_patient() } </span> <br>
		      		 	    <span style="">Date de réception : ${ reception.getReceptionByIdReception( echantillon.getEchantillonByIdEchantillon( analyse.getId_echantillon() ).getId_reception() ).getDate_reception() } </span> <br>
		      		 	    <span style="">Labo numéro : ${analyse.getNum_labo() }</span> <br>
		      		 		<span style="">Prescripteur : ${analyse.getGrade_prescripteur() } ${analyse.getPrescripteur() } </span>
		      		 	</div>
		      		 	<div class="col-lg-6 col-md-6 col-sm-6" style="border:solid .5px black;font-size: 15px">
		      		 		<!--  <span style="">ID analyse : ${id_analyse } </span>  <br> --> 
		      		 		<span style="">Date analyse :  ${analyse.getDate_analyse() } </span> <br>
		      		 		<span style="">Type analyse : ${typeAnalyse.getTypeAnalyse( analyse.getId_type_analyse() ).getNom_type_analyse() } </span> <br>
		      		 		<span style="">Type d'examen : <span style="font-size:12px;"> Recherche de l'${analyse.getType_examen() } de la bactérie ${ pathologie.getPathologieByIdPathologie( echantillon.getEchantillonByIdEchantillon( analyse.getId_echantillon() ).getId_pathologie() ).getNom_pathologie() } par amplification génétique (PCR)</span> </span> <br> 
		      		 		<span style="">Date de prélèvement : ${ echantillon.getEchantillonByIdEchantillon( analyse.getId_echantillon() ).getDate_prelevement() } </span> <br>
		      		 		<span style="">Site : ${analyse.getSite() }</span> <br>
		      		 		<span style="">Adresse : ${analyse.getAdresse() }</span> <br>
		      		 	</div>
		      		 	
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
				          		<td>${analyse.getId_echantillon() }</td>
				          		<td><span style="font-weight: bold;"> ${ pathologie.getPathologieByIdPathologie( echantillon.getEchantillonByIdEchantillon( analyse.getId_echantillon() ).getId_pathologie() ).getNom_pathologie() } </span></td>
				          		<c:choose>
						          		<c:when test="${resultat.getStatus_resultat() eq null }">
						          			<td colspan="3"><span class="text-danger" style="font-weight: bold;">Pas encore disponible.</span></td>
						          		</c:when>
						          		<c:otherwise>
						          			<c:choose>
							          			<c:when test="${resultat.getStatus_resultat() eq 'positif' }">
							          				<td><span class="text-primary" style="font-weight: bold;text-transform: uppercase;">${resultat.getStatus_resultat() }</span></td>
							          			</c:when>
							          			<c:when test="${resultat.getStatus_resultat() eq 'negatif' }">
							          				<td><span class="text-danger" style="font-weight: bold;text-transform: uppercase;">${resultat.getStatus_resultat() }</span></td>
							          			</c:when>
						          			</c:choose>
						          			<td>${resultat.getValeur_ct() }</td>
						          			<td><span style="font-family: arial;font-size: 10px;width: 35%;text-align: justify;">${resultat.getObservation_resultat() }</span> </td>
						          		
						          		</c:otherwise>
						        </c:choose>
				          	</tr>
				          </tbody>
				        </table>
			        
				        <div style="" class="container-fluid">
					        
					        <div class="row">
						        <div style="text-align:justify" class="col-lg-6 col-md-6 col-sm-6">
						        	<h4>Interpretations : </h4>
						        	<c:forEach varStatus="i" items="${ interpretations.getInterpretationsByPathologie( pathologie.getPathologieByIdPathologie( echantillon.getEchantillonByIdEchantillon( analyse.getId_echantillon() ).getId_pathologie() ).getId_pathologie() )}" var="interpretations">
							        	<div style="font-size:13.5px;text-align: justify;">
							        		${i.count } - ${interpretations.getLibelle_inter() }
							        	</div>
						        	</c:forEach>
						        </div>
						        
						        <div style="text-align: center" class="col-lg-6 col-md-6 col-sm-6">
						        	<br>
							        <span style="padding-bottom: 100px; text-align: center; font-weight: bold;font-size: 1.105em">Signature du biologiste</span>
							        <br> <br> <br> <br> <br> <br> <br> <br> <br>
									<span style="text-align: center; font-weight: bold;font-size: 1.25em">Prof. KAKOU Solange</span>
		      		 			</div>
	      		 			</div>
      		 			</div>
		     </div>
		     <div class="row">
			     <div class="col-lg-6 col-md-4 col-sm-6" style="font-size: 10px; font-style: italic"><strong>Valeurs de référence</strong><br>
	      		 	CT > 20 : Charge bactérienne très élevée <br>
	      		 	CT = [21-26] : Charge bactérienne très élevée <br>
	      		 	CT = [27-30] : Charge bactérienne très élevée <br>
	      		 	CT = [30-36] : Charge bactérienne très élevée <br>
	      		 	CT = seuil de détection <br>
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
