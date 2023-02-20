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
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Resultat de l'analyse ${id_analyse} pour l'echantillon : ${analyse.getId_echantillon() }</h1>
      </div>
      
      
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Renseignez les informations</h4>
        <form action="registrationresultatanalyse" method="post">
          <div class="row">
          
         	<div class="col-md-8">
              <label for="id_analyse" class="form-label">ID analyse :</label>
              <input type="text" class="form-control" id="id_analyse" name="id_analyse" readonly="readonly" value="${analyse.getId_analyse() }" required>
            </div>
            
            <div class="col-md-8">
              <label for="id_echantillon" class="form-label">Echantillon analysé :</label>
              <input type="text" class="form-control" id="id_echantillon" name="id_echantillon" readonly="readonly" value="${analyse.getId_echantillon() }" required>
            </div>
            
            <div class="col-md-8">
              <label for="date_analyse" class="form-label">Date analyse :</label>
              <input type="date" readonly="readonly" value="${analyse.getDate_analyse() }" class="form-control" name="date_analyse" id="date_analyse" required>
            </div>
            
            <div class="col-md-8">
              <label for="valeur_ct" class="form-label">Valeur CT :</label>
              <input type="number" class="form-control" name="valeur_ct" id="valeur_ct" required>
            </div>
            
            <div class="col-md-8">
              <label for="status_resultat" class="form-label">Status Resultat :</label>
              <select class="form-select" id="status_resultat" name="status_resultat" required>
                <option value="positif">Positif</option>
                <option value="negatif">Negatif</option>
              </select>
            </div>
            
            <div class="col-md-8">
              <label for="observation_resultat" class="form-label">Observation :</label>
              <textarea class="form-control" required="required" name="observation_resultat" rows="" cols=""></textarea>
            </div>
            

          </div>

          <hr class="col-md-8">

          <button class="btn btn-success btn-lg-12" type="submit">Enregistrer le resultat</button>
		  <a type="button" href="tableanalyseparechantillon?id_echantillon=${analyse.getId_echantillon() }" class="btn btn-danger btn-lg-12">Voir la liste des echantillons</a>
        </form>
      </div>
     
      
    </main>
  </div>
</div>
	
	

    <script src="public/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="public/js/js-template/sidebars.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="public/js/js-template/dashboard.js"></script>
  </body>
</html>
