<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Création nouveau type utilisateur</title>

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
    
    <%@ include file="navsidebar.jsp" %>  

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Faire une analyse pour l'echantillon : ${id_echantillon }</h1>
      </div>
      
      
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Renseignez les informations</h4>
        <form action="registrationAnalyse" method="POST">
          <div class="row">
          
           <!--<div class="col-md-8" style="display: none;">
              <label for="firstName" class="form-label">Identifiant de l'analyse :</label>
              <input type="text" class="form-control" id="id_analyse" name="id_analyse" readonly="readonly">
            </div>-->
         
            <div class="col-md-8">
              <label for="" class="form-label">Echantillon analysé :</label>
              <input type="text" class="form-control" id="id_echantillon" name="id_echantillon" readonly="readonly"  value="${id_echantillon }" required>
            </div>
            
             <div class="col-md-8">
              <label for="" class="form-label">Pathologie concernée :</label>
              <input type="text" class="form-control" id="id_echantillon" readonly="readonly"  value="${pathologie.getPathologieByIdPathologie(echantillon.getId_pathologie()).getNom_pathologie() }">
            </div>
            
            <div class="col-md-8">
            	<div class="row">
            	
		            <div class="col-md-6">
		              <label for="" class="form-label">Analyse a faire :</label>
		              <select class="form-select" id="id_type_analyse" name="id_type_analyse" required>
			              <c:forEach items="${listTypeAnalyse }" var="typeAnalyse">
			                <option value="${typeAnalyse.getId_type_analyse() }">${typeAnalyse.getNom_type_analyse() }</option>
			              </c:forEach>
		              </select>
		            </div>
		            
		            <div class="col-md-6">
		              <label for="" class="form-label">Type d'examen :</label>
		              <select class="form-select" id="type_examen" name="type_examen" required>
			                <option value="ARN">ARN</option>
			             	<option value="ADN">ADN</option>
		              </select>
		            </div>
            	</div>
            </div>
            
           
            <div class="col-md-8">
              <label for="" class="form-label">Numéro du Labo :</label>
              <input type="text" class="form-control" id="num_labo" name="num_labo" required>
            </div>
            
            <div class="col-md-8">
            	<div class="row">
		            <div class="col-md-6">
		              <label for="" class="form-label">Titre prescripteur :</label>
		              <select class="form-select" id="grade_prescripteur" name="grade_prescripteur" required>
		              	<option value="Pr">Professeur</option>
		              	<option value="Dr">Docteur</option>
		              </select>
		            </div>
		            
		            <div class="col-md-6">
		              <label for="" class="form-label">Prescripteur :</label>
		              <input type="text" class="form-control" id="prescripteur" name="prescripteur" required>
		            </div>
            	</div>
            </div>
            
            <div class="col-md-8">
            	<div class="row">
		            <div class="col-md-6">
		              <label for="" class="form-label">Site :</label>
		              <input type="text" class="form-control" id="site" name="site" required>
		            </div>
		            
		            <div class="col-md-6">
		              <label for="" class="form-label">Adresse :</label>
		              <input type="text" class="form-control" id="adresse" name="adresse" required>
		            </div>
	            </div>
            </div>
            
             <!--  <div class="col-md-8" style="display: none;">
              <label for="type_analyse" class="form-label">Statut résultat :</label>
              <input class="form-select" id="id_type_analyse" name="status_resultat">
            </div>
            -->
            
            
            <div class="col-md-8">
              <label for="date_analyse" class="form-label">Date analyse :</label>
              <input type="date" class="form-control" id="date_analyse" name="date_analyse">
            </div>
            

          </div>

          <hr class="col-md-8">

          <button class="btn btn-success btn-lg-12" type="submit">Enregistrer</button>
		  <a type="button" href="tableechantillonparreceptionmakeanalyse?id_reception=${echantillon.getId_reception() }" class="btn btn-danger btn-lg-12">Voir la liste des echantillons</a>
         <!--  <a type="button" href="tableechantillonparreceptionmakeanalyse?id_reception=${id_reception1 }" class="btn btn-danger btn-lg-12">Voir la liste des echantillons</a> --> 
        </form>
      </div>
     
      
    </main>
  </div>
</div>
	
	<script src="public/js/bootstrap.min.js"></script>
	

    <script src="public/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="public/js/js-template/sidebars.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="public/js/js-template/dashboard.js"></script>
  </body>
</html>
