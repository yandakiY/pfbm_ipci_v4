<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>Ajouter une position dans la Biobanque</title>

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
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="position-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item" style="font-size: 20px;">
            <a class="nav-link active" aria-current="page" href="index">
              <span data-feather="home"></span>
              Tableau de bord
            </a>
          </li>
          <li class="mb-1">
	        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
	          Ajouter ...
	        </button>
	        <div class="collapse show" id="home-collapse">
	          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
	            <li><a href="registrationpathologie" class="link-dark rounded">Ajouter une pathologie</a></li>
	            <li><a href="registrationpatient" class="link-dark rounded">Ajouter un patient</a></li>
	            <li><a href="registrationtypeanalyse" class="link-dark rounded">Ajouter un type d'analyse</a></li>
	            <li><a href="registrationtypeechantillon" class="link-dark rounded">Ajouter un type d'echantillon</a></li>
	            <li><a href="registrationcentreprelevement" class="link-dark rounded">Ajouter un centre de prelevement (URAP) </a></li>
	            <li><a href="registrationcentredemandeur" class="link-dark rounded">Ajouter un centre demandeur</a></li>
	          </ul>
	        </div>
	      </li>
          <li class="mb-1">
	        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
	          Faire la reception
	        </button>
	        <div class="collapse" id="dashboard-collapse">
	          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
	            <li><a href="registrationechantillon" class="link-dark rounded">Receptionner un échantillon</a></li>
	          </ul>
	        </div>
	      </li>
          <li class="mb-1">
	        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#orders-collapse" aria-expanded="false">
	          Faire l'analyse
	        </button>
	        <div class="collapse" id="orders-collapse">
	          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
	            <li><a href="makeanalyse" class="link-dark rounded">Effectuer une analyse</a></li>
	            <li><a href="updateanalyse" class="link-dark rounded">Modifier une analyse</a></li>
	          </ul>
	        </div>
	      </li>
	      
	       <li class="mb-1">
	        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#conservation-collapse" aria-expanded="false">
	          Faire la conservation
	        </button>
	        <div class="collapse" id="conservation-collapse">
	          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
	            <li><a href="#" class="link-dark rounded">Ajouter un emplacement biobanque</a></li>
	            <li><a href="#" class="link-dark rounded">Modifier un emplacement biobanque</a></li>
	          </ul>
	        </div>
	      </li>
	      
	     </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span>Saved reports</span>
          <a class="link-secondary" href="#" aria-label="Add a new report">
            <span data-feather="plus-circle"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <!--  -->
          <li class="mb-1">
	        <button class="btn btn-toggle align-items-center rounded collapsed" data-bs-toggle="collapse" data-bs-target="#account-collapse" aria-expanded="false">
	          Statistiques
	        </button>
	        <div class="collapse" id="account-collapse">
	          <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
	            <li><a href="#" class="link-dark rounded">New...</a></li>
	            <li><a href="#" class="link-dark rounded">Profile</a></li>
	            <li><a href="#" class="link-dark rounded">Settings</a></li>
	            <li><a href="#" class="link-dark rounded">Sign out</a></li>
	          </ul>
	        </div>
	      </li>
        </ul>
      </div>
      
    </nav>  

    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2" style="border:solid 4px black;font-family: consolas">Ajouter une position dans la Biobanque</h1>
      </div>
      
      
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Renseignez les informations</h4>
        <form class="needs-validation" action="" method="post">
          <div class="row g-3">
            <div class="col-sm-12">
              <label for="firstName" class="form-label">Position biobanque</label>
              <input type="text" class="form-control" id="firstName" placeholder="" value="" required>
              <div class="invalid-feedback">
                Valid first name is required.
              </div>
            </div>

            <div class="col-sm-12">
              <label for="lastName" class="form-label">Date debut de conservation</label>
              <input type="date" class="form-control" id="lastName" placeholder="" value="" required>
              <div class="invalid-feedback">
                Valid last name is required.
              </div>
            </div>

          </div>

          <hr class="my-4">

          <button class="w-100 btn btn-secondary btn-lg" type="submit">Ajouter</button>
        </form>
      </div>
     
      
    </main>
  </div>
</div>
	
	

    <script src="public/js/bootstrap.min.js"></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="public/js/js-template/dashboard.js"></script>
  </body>
</html>
